package LinkedList;

public class SingleLinked_List {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1,"宋江","及时雨");
        HeroNode h2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode h3 = new HeroNode(3,"吴用","智多星");
        HeroNode h4 = new HeroNode(4,"林冲","豹子头");

        //创建列表
        SingleList l = new SingleList();
//        l.add(h1);
//        l.add(h2);
//        l.add(h3);
//        l.add(h4);
//

        l.addByOrder(h1);
        l.addByOrder(h4);
        l.addByOrder(h2);
        l.addByOrder(h3);
        l.addByOrder(h3);

        //l.list();
        //HeroNode newHeroNode = new HeroNode(4,"？？","？？？");
        //l.update(newHeroNode);

        //l.deleteNode(4);

        System.out.println("有效节点个数："+getLength(l.getHead()));
        System.out.println("************************************");
        l. list();
        System.out.println("************************************");
        HeroNode res = findLastNode(l.getHead(),1);
        System.out.println(res);
        System.out.println("************************************");
        System.out.println("反转后的链表：");
        reverseList(l.getHead());
        l.list();


    }

    //查找单链表中倒数第K个节点
    public static HeroNode findLastNode(HeroNode head, int index){
        if(head.next == null){
            return null;
        }
        int size = getLength(head);
        if(index <= 0 || index > size){
            return null;
        }
        HeroNode cur = head.next;
        for(int i = 0; i < size - index; i++){
            cur = cur.next;
        }
        return  cur;
    }

    //获取单链表的节点个数
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode current = head.next;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }

    //将单链表反转
    public static void reverseList(HeroNode head){
        if(head.next == null||head.next.next == null){
            return ;
        }
        HeroNode cur = head.next;//定义辅助指针，帮助遍历原来的列表
        HeroNode Next = null;//指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历，每遍历一个节点就将其取出放在reverseHead的最前端
        while (cur != null){
            Next = cur.next;//保存当前节点的下一个节点
            cur.next = reverseHead.next;//将cur的下一个节点指向反转链表的第一个节点
            reverseHead.next = cur;//将cur连接到反转链表上[使reverseHead.next重新成为头节点】
            cur = Next;//让cur后移
        }
        head.next = reverseHead.next;

    }
}

//定义单链表管理heroes
class SingleList{
    //初始化头节点，头节点不动,不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }


    //添加节点到单向列表
    public void add(HeroNode heroNode){
        //辅助遍历temp
        HeroNode temp = head;
        //遍历列表找到最后
        while(true){
            if(temp.next == null){
                break;
            }
            //如果没有找到最后，temp后移
            temp = temp.next;
        }
        //此时temp指向最后，将最后这个节点的next指向新节点
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，通过辅助指针来找到添加的位置。temp位于添加位置的前一个位置
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认为false
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.num > heroNode.num){
                break;
            }else if(temp.next.num == heroNode.num){
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//后移，遍历当前列表
        }
        if(flag == true){//不能添加，编号已经存在
            System.out.println("This hero existence, can't insert");
        }else{//插入到链表中，temp后
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //修改信息，编号不变
    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("the list is empty");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.num == newHeroNode.num){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag = true){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{
            System.out.println("not found");
        }
    }

    //删除节点
    public void deleteNode(int num){
        HeroNode temp = head;
        boolean flag = false;//是否找到待删除节点的前一个节点
        while (true){
            if(temp.next == null){//已经到链表的最后
                break;
            }
            if(temp.next.num == num){
                flag = true;//找到的待删除节点的前一个节点
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("can not find");
        }
    }



    //显示列表
    public void list(){
        //判断列表是否为空
        if(head.next == null){
            System.out.println("The list is empty");
            return ;
        }
        //辅助变量遍历
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode{
    public int num;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int num, String name, String nickname){
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