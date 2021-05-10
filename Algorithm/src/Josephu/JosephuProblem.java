package Josephu;

public class JosephuProblem {
    public static void main(String[] args) {
        CircleSingleList circleSingleList = new CircleSingleList();
        circleSingleList.addNode(5);
        circleSingleList.show();

        circleSingleList.countNode(1, 2, 5);//2->4->1->5->3
    }
}

//创建一个类，表示一个节点
class Node {
    private int num;
    private Node next;

    public Node(int num) {
        this.num = num;
    }

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
}

//创建环形的单向链表

class CircleSingleList {
    private Node first = null;

    //添加节点，构建环形链表
    public void addNode(int num) {
        if (num < 1) {
            System.out.println("error");
            return;
        } else {
            Node temp = null;//辅助指针
            for (int i = 1; i <= num; i++) {
                Node node = new Node(i);
                if (i == 1) {
                    first = node;
                    first.setNext(first);//构成一个环
                    temp = first;//让temp指向第一个小孩
                } else {
                    temp.setNext(node);
                    node.setNext(first);
                    temp = node;
                }
            }
        }
    }

//    根据用户输入，计算node出圈的顺序

    /**
     * @param startNum 从第几个节点开始数
     * @param countNum 表示数几下
     * @param num      表示最初有几个节点在圈中
     */
    public void countNode(int startNum, int countNum, int num) {
        if (first == null || startNum < 1 || startNum > num) {
            System.out.println("error, please reenter");
        }
        Node helper = first;
        while (true) {
            if (helper.getNext() == first) {//helper指向最后一个节点
                break;
            } else {
                helper = helper.getNext();
            }
        }
        //报数前，让first和helper移动startNum-1次
        for (int i = 0; i < startNum - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == first) {
                break;
            } else {
                //让first和helper移动countNum-1下
                for (int j = 0; j < countNum - 1; j++) {
                    first = first.getNext();
                    helper = helper.getNext();
                }
                //first指向的节点就是要出圈的节点
                System.out.printf("Node %d is out\n", first.getNum());
                //让first指向的节点出圈
                first = first.getNext();
                helper.setNext(first);
            }
        }
        System.out.printf("The last node is %d\n", first.getNum());
    }

    public void show() {
        if (first == null) {
            System.out.println("No nodes");
            return;
        } else {
            Node temp = first;
            while (true) {
                System.out.printf("The Node number is %d \n", temp.getNum());
                if (temp.getNext() == first) {//遍历完毕
                    break;
                } else {
                    temp = temp.getNext();
                }
            }
        }
    }
}