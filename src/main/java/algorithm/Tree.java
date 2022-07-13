package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
//        print2(root);
        levelOrder(root);

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

    public static void levelOrder(Node root) {
        List<List<Integer>> l=new ArrayList<>();
        Queue<Node> q=new LinkedList<Node>();
        if(root!=null){
            q.add(root);
        }
        while(!q.isEmpty()){
            List<Integer> l2=new ArrayList<>();
            int number=q.size();
            while(number>0){
                Node t = q.poll();
                l2.add(t.value);
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
                number--;
            }
            l.add(l2);
        }
        l.forEach(System.out::println);
    }

    public static void level(Node node){
        // 创建一个最大的list，最后返回的顺序就是这个
        List<List<Integer>>  resList = new ArrayList<>();
        // 将node放到一个queue中
        Queue<Node> queue = new LinkedList<>();
        if(node != null){
            queue.add(node);
        }

        //遍历这个queue
        while (!queue.isEmpty()){
            // 1.取出queue的大小
            int size = queue.size();
            //创建一个新的list
            List<Integer> list = new ArrayList<>();
            //2.当有数据的时候，继续遍历
            while (size > 0){
                Node cur = queue.poll();
                if(cur != null){
                    list.add(cur.value);
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                }
                //刚才队列里面有一个元素，现在--后就没有了，所以跳出这层循环
                size--;
            }
            resList.add(list);
        }
        resList.forEach(System.out::println);
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