package com.intprep.tiktok.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@link - https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        revise(root, 0, new HashSet<>(), lst);
        return lst;
    }

    private void revise(TreeNode root, int level, Set<Integer> cache, List<Integer> lst) {
        if (root == null) return;

        if (!cache.contains(level)) {
            lst.add(root.val);
            cache.add(level);
        }
        revise(root.right, level+1, cache, lst);
        revise(root.left, level+1, cache, lst);
    }
}
