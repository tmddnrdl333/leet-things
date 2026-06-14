package solutions;

import leet.LeetIO;
import leet.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        TreeNode p = io.nextTreeNode();
        TreeNode q = io.nextTreeNode();
        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(p, q));
    }
}
