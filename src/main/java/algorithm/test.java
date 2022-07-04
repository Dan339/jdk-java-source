package algorithm;

import sun.tools.tree.Node;

import javax.swing.tree.TreeNode;

/**
 * @author Dan.L
 * @date 2022年06月15日16:02
 */
public class test {
    // 任意一个子节点的高度差不超过1
    public static void main(String[] args) {
        TreeNode1 node1 = new TreeNode1();
        TreeNode1 node2 = new TreeNode1();
        TreeNode1 node3 = new TreeNode1();
        TreeNode1 node4 = new TreeNode1();
        TreeNode1 node5 = new TreeNode1();
        TreeNode1 node6 = new TreeNode1();
        TreeNode1 node7 = new TreeNode1();

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node4.left = node6;

        System.out.println(isBan(node1));
    }


    static boolean isBan(TreeNode1 node){
        if(node == null){
            return true;
        }

        if(deep(node) == -1){
            return false;
        }
        return  true;
    }

    static int deep(TreeNode1 node){
        if (node == null){
            return 0;
        }
        //,,..
        int left = deep(node.left);
        if(left == -1){
            return -1;
        }

        int right = deep(node.right);
        if(right == -1){
            return -1;
        }

        // 高度差
        if(Math.abs(left-right) > 1){
            return -1;
        }

        return  1 + Math.max(right, left);
    }
}

class TreeNode1 {
    TreeNode1 left;
    TreeNode1 right;

    public void setLeft(final TreeNode1 left) {
        this.left = left;
    }

    public void setRight(final TreeNode1 right) {
        this.right = right;
    }
}

