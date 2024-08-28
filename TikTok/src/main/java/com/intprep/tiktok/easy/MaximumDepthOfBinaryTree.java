package com.intprep.tiktok.easy;

//@link - https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return dfs1(root);
    }

    private int dfs1(TreeNode root) {
        if (root == null) return 0;
        int left = 1 + dfs1(root.left);
        int right = 1 + dfs1(root.right);

        return Math.max(left, right);
    }

    private int dfs2(TreeNode root) {
        if (root == null) return 0;
        int left = dfs2(root.left);
        int right = dfs2(root.right);

        return 1 + Math.max(left, right);
    }
}
