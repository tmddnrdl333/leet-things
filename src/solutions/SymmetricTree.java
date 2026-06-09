package solutions;

import leet.LeetIO;
import leet.TreeNode;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode mirroredRight = createMirroredNode(root.right);


        return isSame(left, mirroredRight);
    }

    private static TreeNode createMirroredNode(TreeNode node) {
        if (node == null || node.left == null && node.right == null) {
            return node;
        }
        return new TreeNode(node.val, createMirroredNode(node.right), createMirroredNode(node.left));
    }

    private static boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }
        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        leet.TreeNode treeNode = io.nextTreeNode();
        boolean symmetric = isSymmetric(treeNode);
        System.out.println(symmetric);
    }

}
