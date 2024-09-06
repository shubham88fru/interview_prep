package com.intprep.tiktok.medium;

import java.util.*;

//@link - https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentsmap = new HashMap<>();

        //store a map of all nodes of tree v/s their parents;
        traverseForParents(root, null, parentsmap);

        List<Integer> ans = new ArrayList<>();

        //Start iterating from the targetNode (not the root)
        //traverseForAllNodesAtDistKDFS(target, k, ans, parentsmap, new HashMap<TreeNode, Integer>());
        traverseForAllNodesAtDistKBFS(target, k, ans, parentsmap);

        return ans;
    }

    //Algorithm to find parents of all nodes.
    private void traverseForParents(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentsmap) {
        if (root == null) return;

        parentsmap.put(root, parent);
        traverseForParents(root.left, root, parentsmap);
        traverseForParents(root.right, root, parentsmap);
    }

    //0) Convert the tree to graph and then do bfs/dfs.

    //1) DFS Solution.
    private void traverseForAllNodesAtDistKDFS(TreeNode node, int k, List<Integer> ans, Map<TreeNode, TreeNode> parentsmap, Map<TreeNode, Integer> seenmap) {
        if (node == null) return;

        //If already visited, return.
        if (seenmap.containsKey(node)) return;

        //else, mark visited.
        seenmap.put(node, 1);

        if (k == 0) ans.add(node.val);

        //visit left
        traverseForAllNodesAtDistKDFS(node.left, k-1, ans, parentsmap, seenmap);
        //visit right
        traverseForAllNodesAtDistKDFS(node.right, k-1, ans, parentsmap, seenmap);
        //visit parent
        traverseForAllNodesAtDistKDFS(parentsmap.get(node), k-1, ans, parentsmap, seenmap);
    }

    //2) BFS Solution.
    private void traverseForAllNodesAtDistKBFS(TreeNode node, int k, List<Integer> ans, Map<TreeNode, TreeNode> parentsmap) {

        //a map to store to nodes that we have
        //visited till now.
        Map<TreeNode, Integer> seen = new HashMap<>();

        //queue for bfs.
        ArrayDeque<WrappedNode> queue = new ArrayDeque<>();
        queue.addLast(new WrappedNode(node, k));
        seen.put(node, node.val);

        //run bfs.
        while (!queue.isEmpty()) {
            WrappedNode wrappedNode = queue.removeFirst();
            TreeNode currNode = wrappedNode.node;
            int targetDist = wrappedNode.dist;

            //if reached a target node, add to list.
            if (targetDist == 0) {
                ans.add(currNode.val);
                continue;
            }

            //If left node and not visited before, enqueue it.
            if (currNode.left != null && !seen.containsKey(currNode.left)) {
                seen.put(currNode.left, currNode.left.val);
                queue.addLast(new WrappedNode(currNode.left, targetDist-1));
            }

            //If right node, and not visited before, enqueue it.
            if (currNode.right != null && !seen.containsKey(currNode.right)) {
                seen.put(currNode.right, currNode.right.val);
                queue.addLast(new WrappedNode(currNode.right, targetDist-1));
            }

            //if parent node, and not visited before, enqueue it.
            if (parentsmap.get(currNode) != null && !seen.containsKey(parentsmap.get(currNode))) {
                seen.put(parentsmap.get(currNode), parentsmap.get(currNode).val);
                queue.addLast(new WrappedNode(parentsmap.get(currNode), targetDist-1));
            }
        }
    }
}

//A treenode wrapper that stores
//extra info.
class WrappedNode {
    TreeNode node;
    int dist;

    public WrappedNode(TreeNode node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}