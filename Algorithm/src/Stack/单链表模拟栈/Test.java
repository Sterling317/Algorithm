package Stack.单链表模拟栈;

public class Test {
    public static void main(String[] args) {
        LinkedListStack list = new LinkedListStack(5);
        list.show();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
//        list.pop();
        list.show();
    }
}

class Node {
    private int num;
    private Node next;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int num) {
        this.num = num;
    }
}

class LinkedListStack {
    private Node head = new Node(0);
    int maxSize;
    public LinkedListStack(int maxSize){
        this.maxSize = maxSize;
    }
//    //判断栈是否为空
//    public boolean isEmpty(){
//        return top.getNum() == -1;
//    }
    //入栈
    public void push(int num){
        Node temp = head;
        int i = 0;
        while (true){
            if (temp.getNext() == null){
                break;
            }
            temp = temp.getNext();
            i++;
        }
        if (i < maxSize){
            temp.setNext(new Node(num));
        }else{
            System.out.println("stack is full, can not add node");
        }
    }

    public void pop(){
        Node temp = head;
        if (temp.getNext() == null){
            System.out.println("stack is empty, can not pop node");
            return;
        }
        while (true){
            if (temp.getNext().getNext() == null){
//                temp = temp.getNext();
                temp.setNext(null);
                break;
            }
            temp = temp.getNext();
        }
    }

    public void show() {
        Node temp = head.getNext();
        if (temp == null){
            System.out.println("no data");
            return;
        }
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp.getNum());
            temp = temp.getNext();
        }
    }
}