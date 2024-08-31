package com.intprep.tiktok.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//@link - https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // inorder(root, ans);
        inorderIterative(root, ans);
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    private void inorderIterative(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushAllLeftNodesToStack(root, stack);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            ans.add(node.val);
            TreeNode right = node.right;
            if (right != null) {
                pushAllLeftNodesToStack(right, stack);
            }
        }
    }

    private void pushAllLeftNodesToStack(TreeNode root, Deque<TreeNode> stack) {
        TreeNode curr = root;
        while (curr != null) {
            stack.addFirst(curr);
            curr = curr.left;
        }
    }
}
