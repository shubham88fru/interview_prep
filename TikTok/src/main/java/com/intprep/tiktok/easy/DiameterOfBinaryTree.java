package com.intprep.tiktok.easy;

//@link - https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diam = {0};
        diameterOfBT(root, diam);
        return diam[0];
    }

    private int diameterOfBT(TreeNode root, int[] diam) {
        if (root == null) return 0;

        int left = 0;
        if (root.left != null) left = 1 + diameterOfBT(root.left, diam);

        int right = 0;
        if (root.right != null) right = 1 + diameterOfBT(root.right, diam);

        diam[0] = Math.max(diam[0], left + right);
        return Math.max(left, right);
    }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}