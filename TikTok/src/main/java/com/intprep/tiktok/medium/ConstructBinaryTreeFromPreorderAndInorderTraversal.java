package com.intprep.tiktok.medium;

import java.util.HashMap;
import java.util.Map;

//@link - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return revise(preorder, inorder);
    }

    private TreeNode revise(int[] preorder, int[] inorder) {
        int[] preorderIdx = {0};
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        int root = preorder[preorderIdx[0]];
        return construct(preorder, inorder, inorderMap, preorderIdx, 0 , inorder.length-1);
    }

    private TreeNode construct(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int[] preorderIdx, int low, int high) {
        if (low > high) return null;

        int inorderIdx = inorderMap.get(preorder[preorderIdx[0]]);
        TreeNode root = new TreeNode(inorder[inorderIdx]);
        preorderIdx[0] += 1;
        root.left = construct(preorder, inorder, inorderMap, preorderIdx, low, inorderIdx-1);
        root.right = construct(preorder, inorder, inorderMap, preorderIdx, inorderIdx+1, high);

        return root;
    }
}
