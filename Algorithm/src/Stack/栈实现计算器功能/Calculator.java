package Stack.栈实现计算器功能;//中缀表达式

public class Calculator {
    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 symbolStack = new ArrayStack2(10);
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int symbol = 0;
//        int res = 0;
        char ch = ' ';//将每次扫描得到的char保存到ch
        String connectString = "";//拼接多位数
        //while循环扫描expression
        while (true) {
            //依次得到每个字符
            ch = expression.substring(index, index + 1).charAt(0);
            if (symbolStack.isSymbol(ch)) {
                if (!symbolStack.isEmpty()){
                    //如果符号栈有操作符，就进行比较，如果当前操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop两个数
                    //再从符号栈中pop出一个符号进行运算，然后将结果入数栈，将当前操作符入符号栈
                    if (symbolStack.priority(ch) <= symbolStack.priority(symbolStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        symbol = symbolStack.pop();
                        //运算结果入数栈
                        numStack.push(numStack.cal(num1, num2, symbol));
                        //将当前操作符入符号栈
                        symbolStack.push(ch);
                    } else {
                        //如果当前操作符的优先级大于栈中的操作符，就直接入符号栈
                        symbolStack.push(ch);
                    }
                }else {
                    //如果为空直接入符号栈
                    symbolStack.push(ch);
                }
            }else {
                connectString += ch;
                //判断index是否为最后一位，如果是则直接入栈
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(connectString));
                }else {
                    //判断下一个字符是否为数字，如果是则继续扫描，否则直接入栈
                    if (symbolStack.isSymbol(expression.substring(index+1, index+2).charAt(0))){
                        numStack.push(Integer.parseInt(connectString));
                        connectString = "";
                    }
                }

//                //如果是数，直接入数栈
//                numStack.push(ch - '0');
            }
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号并运行
        while (true) {
            if (symbolStack.isEmpty()){
                break;
            }else {
                num1 = numStack.pop();
                num2 = numStack.pop();
                symbol = symbolStack.pop();
                //运算结果入数栈
                numStack.push(numStack.cal(num1, num2, symbol));
            }
        }
        System.out.printf("%s = %d", expression, numStack.pop());
    }
}

class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据就放在该数组
    private int top = -1;//top表示栈顶，初始化为-1

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty, no data");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈【从栈顶开始显示数据】
    public void list() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack[%d] = %d\n", i, stack[i]);
            }
        }
    }

    //返回运算符的优先级，数字越大，优先级越高
    public int priority(int symbol) {
        if (symbol == '*' || symbol == '/') {
            return 1;
        } else if (symbol == '+' || symbol == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否为运算符
    public boolean isSymbol(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int symbol) {
        int result = 0; //存放计算结果
        switch (symbol) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }

    //返回栈顶的值
    public int peek() {
        return stack[top];
    }
}