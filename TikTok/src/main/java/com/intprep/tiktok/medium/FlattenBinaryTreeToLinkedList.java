package com.intprep.tiktok.medium;

import java.util.ArrayDeque;
import java.util.Deque;

//@link - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreeToLinkedList {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        // flattenToLLRecursive(root);
        // flattenToLLIterative(root);
        reviseIterative(root);
    }

    //more like edctv's soln.
    private void reviseIterative(TreeNode root) {
        if (root == null) return;
        TreeNode rut = root;
        while (rut != null) {
            if (rut.left != null) {
                TreeNode rleaf = rut.left;
                while (rleaf.right != null) rleaf = rleaf.right;

                TreeNode next = rut.right;
                rut.right = rut.left;
                rut.left = null;
                rut = rut.right;
                rleaf.right = next;
            } else rut = rut.right;

        }
    }

    //1) Recurisve soln
    //This builds the list from end.
    private void flattenToLLRecursive(TreeNode root) {
        if (root == null) return;

        //notice - sort of a reverse preorder traversal.
        flattenToLLRecursive(root.right); //right
        flattenToLLRecursive(root.left);//left
        root.right = prev;//root
        root.left = null;

        prev = root;
    }

    //2) Iterative solution
    //This builds the list from the front.
    private void flattenToLLIterative(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peekFirst();
            stack.removeFirst();

            if (curr.right != null) stack.addFirst(curr.right);
            if (curr.left != null) stack.addFirst(curr.left);

            if (!stack.isEmpty()) curr.right = stack.peekFirst();
            curr.left = null;
        }
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
