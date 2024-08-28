package com.intprep.tiktok.easy;

//@link - https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = 1 + dfs(root.left);
        int right = 1 + dfs(root.right);

        return Math.max(left, right);
    }
}
