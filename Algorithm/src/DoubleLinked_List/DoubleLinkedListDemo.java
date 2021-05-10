package DoubleLinked_List;


public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 h1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 h2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 h3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 h4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList l = new DoubleLinkedList();
        l.add(h1);
        l.add(h2);
        l.add(h3);
        l.add(h4);
        System.out.println("遍历列表");
        l.list();
        HeroNode2 updateHeroNode = new HeroNode2(4, "??", "???");
        l.update(updateHeroNode);
        System.out.println("修改节点");
        l.list();
        System.out.println("删除节点");
        l.delete(3);
        l.list();

    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("the list is empty");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            } else {
                System.out.println(temp);
            }
            temp = temp.next;
        }
    }

    public void add(HeroNode2 hero) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        //形成一个双向链表
        temp.next = hero;
        hero.pre = temp;
    }

    public void update(HeroNode2 newHero) {
        if (head.next == null) {
            System.out.println("The list is empty");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.num == newHero.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true) {
            temp.name = newHero.name;
            temp.nickname = newHero.nickname;
        } else {
            System.out.println("can't find this hero");
        }
    }

    public void delete(int num) {
        if (head.next == null) {
            System.out.println("can not delete");
            return;
        }
        HeroNode2 temp = head;
        boolean isFound = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.num == num) {
                isFound = true;
                break;
            }
            temp = temp.next;
        }
        if (isFound = true) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;//如果是删除最后一个节点就不需要执行这句话，否则会出现空指针异常
            }
        } else {
            System.out.printf("can not find this node");
        }
    }

}

//定义HeroNode2，每个HeroNode2对象就是一个节点
class HeroNode2 {
    public int num;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点，默认为null
    public HeroNode2 pre;//指向前一个节点

    public HeroNode2(int num, String name, String nickname) {
        this.num = num;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                '}';
    }
}