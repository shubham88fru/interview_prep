package com.intprep.tiktok.medium;

import java.util.ArrayList;
import java.util.List;

//@link - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorInBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return revise(root, p, q);
        // return searchInSubTree(root, p, q);
    }

    //optimal soln.
    private TreeNode searchInSubTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = searchInSubTree(root.left, p, q);

        TreeNode right = searchInSubTree(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;

        return null;
    }

    //my soln.
    private TreeNode revise(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> ppath = new ArrayList<>();
        List<List<TreeNode>> qpath = new ArrayList<>();

        dfs(root, p, new ArrayList<>(), ppath);
        dfs(root, q, new ArrayList<>(), qpath);


        int i=0;
        int j=0;
        TreeNode lca = root;
        while (i<ppath.get(0).size() && j<qpath.get(0).size()) {
            if (ppath.get(0).get(i).val == qpath.get(0).get(j).val) {
                lca = ppath.get(0).get(i);
            }
            i +=1;
            j +=1;
        }

        return lca;
    }

    private void dfs(TreeNode root, TreeNode target, List<TreeNode> curr, List<List<TreeNode>> path) {
        if (root == null) return;

        if (root.val == target.val) {
            curr.add(root);
            path.add(new ArrayList<>(curr));
            return;
        }

        curr.add(root);
        dfs(root.left, target, curr, path);
        dfs(root.right, target, curr, path);
        curr.remove(root);
    }
}
