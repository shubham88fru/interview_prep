package com.intprep.tiktok.medium;

import java.util.ArrayDeque;
import java.util.Deque;

//@link - https://leetcode.com/problems/check-completeness-of-a-binary-tree/
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        return bfs(root);
    }

    private boolean bfs(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        int level = 0;
        boolean lastLevel = true;
        while (!q.isEmpty()) {
            int sz = q.size();
            if ((sz != Math.pow(2, level)) && !lastLevel) return false;
            lastLevel = true;
            boolean nullSeen = false;
            while (sz > 0) {
                TreeNode curr = q.removeFirst();

                if (curr.left != null) {
                    if (nullSeen) return false;
                    q.addLast(curr.left);
                    if (curr.left.left != null || curr.left.right != null) lastLevel = false;
                } else nullSeen = true;

                if (curr.right != null) {
                    if (nullSeen) return false;
                    q.addLast(curr.right);
                    if (curr.right.left != null || curr.right.right != null) lastLevel = false;
                } else nullSeen = true;

                sz -= 1;

            }
            level += 1;
        }

        return true;
    }
}
