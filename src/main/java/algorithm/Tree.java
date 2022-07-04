package algorithm;

/**
 * @author Dan.L
 * @date 2022年06月25日00:04
 */
public class Tree {
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.right = new Node(150);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right.left = new Node(125);
        root.right.right = new Node(175);

        root.left.left.left = new Node(12);
//        print1(root);
        print2(root);

    }

    private static void print1(final Node root) {
        if (root.left != null) {
            print1(root.left);
        }
        realPrint1(root);
        if (root.right != null) {
            print1(root.right);
        }

    }

    private static void print2(final Node root) {
        realPrint1(root);
        if (root.left != null) {
            print2(root.left);
        }
        if (root.right != null) {
            print2(root.right);
        }
    }

    private static void realPrint1(final Node node) {
        System.out.println(node);
    }
}

class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }

    public String toString() {
        return this.value + "";
    }
}