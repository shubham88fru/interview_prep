package com.intprep.tiktok.medium;

import java.util.*;

//@link - https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        return revise(root);
        // return strvr(root);
    }

    private List<List<Integer>> revise(TreeNode root) {
        PriorityQueue<NodeWrapper> pq = bfs(root);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        int prevLevel = -6000;
        while (!pq.isEmpty()) {
            NodeWrapper nw = pq.remove();

            if (prevLevel == -6000 || prevLevel != nw.level) {
                lst = new ArrayList<>();
                ans.add(lst);
                prevLevel = nw.level;
            }
            lst.add(nw.node.val);
        }

        return ans;
    }

    private List<List<Integer>> strvr(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, PriorityQueue<NodeWrapper>> tmap = bfsForVerticalOrder(root);

        //once we get the the data in desired datastructre.
        //iterate over the map and return the list.
        for (Map.Entry<Integer, PriorityQueue<NodeWrapper>> entry:  tmap.entrySet()) {
            List<Integer> lst = new ArrayList<>();
            PriorityQueue<NodeWrapper> pq = entry.getValue();
            while (!pq.isEmpty()) {
                lst.add(pq.remove().node.val);
            }
            ans.add(lst);
        }

        return ans;
    }

    private PriorityQueue<NodeWrapper> bfs(TreeNode root) {
        Comparator<NodeWrapper> cmp1 = (nw1, nw2) -> nw1.level - nw2.level;
        Comparator<NodeWrapper> cmp2 = (nw1, nw2) -> nw1.depth - nw2.depth;
        Comparator<NodeWrapper> cmp3 = (nw1, nw2) -> nw1.node.val - nw2.node.val;

        PriorityQueue<NodeWrapper> pq = new PriorityQueue<NodeWrapper>(cmp1.thenComparing(cmp2).thenComparing(cmp3));
        Deque<NodeWrapper> q = new ArrayDeque<>();
        q.addLast(new NodeWrapper(root, 0, 0));

        while (!q.isEmpty()) {
            NodeWrapper nw = q.removeFirst();
            TreeNode node = nw.node;

            pq.add(nw);
            if (node.left != null) {
                q.addLast(new NodeWrapper(node.left, nw.level-1, nw.depth+1));
            }

            if (node.right != null) {
                q.addLast(new NodeWrapper(node.right, nw.level+1, nw.depth+1));
            }
        }

        return pq;
    }

    private Map<Integer, PriorityQueue<NodeWrapper>> bfsForVerticalOrder(TreeNode root) {
        //Treemap to store a priorty queue (sorted wrt depth->level->value) against each
        //vertical level in a sorted fashion. This entire treemap is what we will return
        //from this method, after populating it correctly.
        Map<Integer, PriorityQueue<NodeWrapper>> tmap = new TreeMap<>();

        Deque<NodeWrapper> q = new ArrayDeque<>();
        q.addLast(new NodeWrapper(root, 0, 0));

        while (!q.isEmpty()) {
            NodeWrapper nw = q.removeFirst();

            //If seeing a vertical level for the first time, initialize.
            if (!tmap.containsKey(nw.level)) {

                //comparators for inserts in desired fashion.
                Comparator<NodeWrapper> cmp = Comparator.comparingInt(nw2 -> nw2.depth);
                PriorityQueue<NodeWrapper> arr = new PriorityQueue<>(cmp.thenComparingInt(nw2 -> nw2.level).thenComparingInt(nw2 -> nw2.node.val));
                arr.add(nw);
                tmap.put(nw.level, arr);
            } else {
                tmap.get(nw.level).offer(nw);
            }


            //typical bfs.
            if (nw.node.left != null) {
                //when moving left child. level-1 and depth+1;
                q.addLast(new NodeWrapper(nw.node.left, nw.level-1, nw.depth+1));
            }

            if (nw.node.right != null) {
                //when moving right child. level+1 and depth+1;
                q.addLast(new NodeWrapper(nw.node.right, nw.level+1, nw.depth+1));
            }
        }

        return tmap;

    }
}

//a utility class that will store
//useful information for each node.
//like the level (vertical), and depth.
class NodeWrapper {
    TreeNode node;
    int level;
    int depth;

    public NodeWrapper(TreeNode node, int level, int depth) {
        this.node = node;
        this.level = level;
        this.depth = depth;
    }

    public String toString() {
        return "[" + node.val + ", " + level + ", " + depth + "]";
    }
}