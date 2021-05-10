package Search.BinaryTree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "a");
        Node node2 = new Node(2, "b");
        Node node3 = new Node(3, "c");
        Node node4 = new Node(4, "d");
        Node node5 = new Node(5, "e");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //前序
        System.out.println("前序");
        binaryTree.preOrder();
        //中序
        System.out.println("中序");
        binaryTree.infixOrder();
        //后序
        System.out.println("后序");
        binaryTree.postOrder();
        //前序遍历
        System.out.println("前序遍历");
        Node node = binaryTree.preOrderSearch(3);
        if (node != null) {
            System.out.println(node.getName()+node.getNum());
        }
    }
}

//定义一个二叉树
class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("error");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("error");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("error");
        }
    }

    public Node preOrderSearch(int num) {
        if (root != null) {
            return root.preOrderSearch(num);
        } else {
            return null;
        }
    }
}

class Node {
    private int num;
    private String name;
    private Node left;  //默认为null
    private Node right;

    public Node() {
    }

    public Node(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历方法
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public Node preOrderSearch(int num) {
        if (this.num == num) {
            return this;
        }
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(num);
        }
        return resNode;
    }

    //中序遍历查找
    public Node infixOrderSearch(int num) {
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.num == num) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(num);
        }
        return resNode;
    }

    //后序遍历查找
    public Node postOrderSearch(int num)  {
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(num);
        }
        if (this.num == num) {
            return this;
        }
        return resNode;
    }
}