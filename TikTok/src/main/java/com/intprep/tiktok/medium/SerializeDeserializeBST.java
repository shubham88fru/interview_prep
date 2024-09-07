package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/serialize-and-deserialize-bst/
public class SerializeDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        preorder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] preorder = data.split(",");
        return constructBSTFromPreorder(preorder, new int[]{0}, Integer.MAX_VALUE);
    }

    //BST can only be reconstructed from preorder traversal array.
    //Tried with inorder but that doesn't work.
    //Other way to solve this problem is to directly
    //copypasta the Serial-deserial BT soln. But then that
    //won't utilize the fact that the input in this question is a BST.
    private void preorder(TreeNode root, StringBuffer sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    private TreeNode constructBSTFromPreorder(String[] preorder, int[] currIndex, int maxPossibleValue) {
        if (currIndex[0] >= preorder.length) return null;

        //if curr value in preorder array is more than max possible
        //value for the current sub tree, return null. We'll try to
        //set this value in parent's other half.
        if (Integer.parseInt(preorder[currIndex[0]]) > maxPossibleValue) return null;

        TreeNode root = new TreeNode(Integer.parseInt(preorder[currIndex[0]]));
        currIndex[0] += 1;

        //max value possible in curr nodes's left subtree is a value
        //smaller than curr nodes's value.
        root.left = constructBSTFromPreorder(preorder, currIndex, root.val);

        //max value possible in curr node's right subtree is anything smaller
        //than `maxPossibleValue`
        root.right = constructBSTFromPreorder(preorder, currIndex, maxPossibleValue);

        return root;
    }
}
