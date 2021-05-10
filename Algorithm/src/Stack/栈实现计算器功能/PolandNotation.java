package Stack.栈实现计算器功能;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
逆波兰表达式
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";//为了方便，逆波兰表达式的数字和符号使用空格隔开
        List<String> recvList = getListString(suffixExpression);
        System.out.println(recvList);

        int res = calculate(recvList);
        System.out.println("计算的结果为：" + res);
    }

    public static List<String> getListString(String suffixExpression) {
        String split[] = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches("\\d+")) {//匹配的是多位数
                stack.push(item);
            } else {
                //pop出两个数计算后入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
