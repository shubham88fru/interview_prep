package com.intprep.tiktok.easy;

//@link - https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfs(root).balanced;
    }

    private NodeData dfs(TreeNode root) {
        if (root == null) return new NodeData(0, true);


        NodeData left = dfs(root.left);
        if (!left.balanced) return new NodeData(-1 ,false);

        NodeData right = dfs(root.right);
        if (!right.balanced) return new NodeData(-1 ,false);

        if (Math.abs(left.height - right.height) > 1) return new NodeData(-1, false);
        return new NodeData(1 + Math.max(left.height, right.height), true);

    }
}

class NodeData {
    int height;
    boolean balanced;
    public NodeData(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}