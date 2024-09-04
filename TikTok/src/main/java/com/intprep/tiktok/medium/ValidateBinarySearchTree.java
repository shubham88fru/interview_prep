package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        //return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE).bst;
        // long[] prev = {Long.MIN_VALUE};
        // return dfs2(root, prev);

        return revise(root).bst;
    }

    private TraversalData revise(TreeNode root) {
        if (root == null) return new TraversalData(true, Long.MAX_VALUE, Long.MIN_VALUE);

        TraversalData left = revise(root.left);
        if (!left.bst) return new TraversalData(false, Long.MIN_VALUE, Long.MAX_VALUE);

        TraversalData right = revise(root.right);
        if (!right.bst) return new TraversalData(false, Long.MIN_VALUE, Long.MAX_VALUE);

        return new TraversalData(
                left.bst && right.bst && root.val > left.max && root.val < right.min,
                Math.min(root.val, Math.min(left.min, right.min)),
                Math.max(root.val, Math.max(left.max, right.max))
        );
    }


    //Solution 1
    private TraversalData dfs(TreeNode root, long min, long max) {
        if (root == null) return new TraversalData(true, Long.MAX_VALUE, Long.MIN_VALUE);
        if (root.left == null && root.right == null) {
            return new TraversalData(true, root.val, root.val);
        }

        TraversalData left = dfs(root.left, min, max);
        TraversalData right = dfs(root.right, min, max);

        if (!left.bst || !right.bst) return new TraversalData(false, -1, -1);

        if (root.val > left.max && root.val < right.min) {
            return new TraversalData(true,
                    Math.min(Math.min(left.min, root.val), right.min),
                    Math.max(Math.max(left.max, root.val), right.max)
            );
        }

        return new TraversalData(false, -1, -1);
    }

    private boolean dfs2(TreeNode root, long[] prev) {
        if (root == null)
            return true;

        if (!dfs2(root.left, prev))
            return false;

        if (root.val <= prev[0])
            return false;

        prev[0] = root.val;

        return dfs2(root.right, prev);
    }
}

class TraversalData {
    boolean bst;
    long min;
    long max;
    public TraversalData(boolean bst, long min, long max) {
        this.bst = bst;
        this.min = min;
        this.max = max;
    }
}
