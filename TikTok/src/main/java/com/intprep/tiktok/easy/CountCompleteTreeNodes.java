package com.intprep.tiktok.easy;

import java.util.ArrayDeque;
import java.util.Deque;

//@link - https://leetcode.com/problems/count-complete-tree-nodes/
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        return revise(root);
    }

    private int revise(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        int nodes = 0;
        int level = 0;
        boolean lastLevel = false;
        while (!q.isEmpty()) {

            nodes += q.size();
            if (lastLevel) {
                return nodes;
            }

            int sz = q.size();
            lastLevel = true;
            while (sz > 0) {
                TreeNode curr = q.removeFirst();
                if (curr.left != null) {
                    q.addLast(curr.left);
                    if (curr.left.left != null || curr.left.right != null) {
                        lastLevel = false;
                    }
                }

                if (curr.right != null) {
                    q.addLast(curr.right);
                    if (curr.right.left != null || curr.right.right != null) {
                        lastLevel = false;
                    }
                }

                sz -= 1;
            }
        }

        return nodes;
    }
}
