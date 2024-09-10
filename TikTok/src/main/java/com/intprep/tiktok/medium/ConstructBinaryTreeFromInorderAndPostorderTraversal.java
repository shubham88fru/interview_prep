package com.intprep.tiktok.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return revise(inorder, postorder);
    }

    private TreeNode revise(int[] inorder, int[] postorder) {

        Map<Integer, Integer> inmap = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            inmap.put(inorder[i], i);
        }

        int[] pindex = {postorder.length-1};
        int root = inmap.get(postorder[pindex[0]]);
        return dfs(inorder, postorder, inmap, pindex, 0, postorder.length-1);
    }

    private TreeNode dfs(int[] inorder, int[] postorder, Map<Integer, Integer> inmap, int[] pindex, int low, int high) {
        if (pindex[0] < 0) return null;
        if (low > high) return null;

        int rootIndex = inmap.get(postorder[pindex[0]]);
        TreeNode root = new TreeNode(postorder[pindex[0]]);

        pindex[0] -= 1;
        root.right = dfs(inorder, postorder, inmap, pindex, rootIndex+1, high);
        root.left = dfs(inorder, postorder, inmap, pindex, low, rootIndex-1);
        return root;
    }
}
