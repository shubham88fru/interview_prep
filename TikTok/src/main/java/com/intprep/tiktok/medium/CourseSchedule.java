package com.intprep.tiktok.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//@link - https://leetcode.com/problems/course-schedule/solutions/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return revise(numCourses, prerequisites);
        // return accepted(numCourses, prerequisites);
    }

    private boolean accepted(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;

        //Construct graph (adjacency list representation) from the
        //prerequisites array.
        List<List<Integer>> adj = getGraph(prerequisites, numCourses);

        /*** Kahn's algorithm ***/
        //Step 1: Find indegree array
        int[] inDegrees = new int[numCourses];
        for (int vertex=0; vertex<numCourses; vertex++) {
            List<Integer> neighbours = adj.get(vertex);
            for (int neighbour: neighbours) {
                inDegrees[neighbour] += 1;
            }
        }

        //Step 2: Add all vertices with 0 indegree to queue.
        Deque<Integer> queue = new ArrayDeque<>();
        for (int vertex=0; vertex<numCourses; vertex++) {
            if (inDegrees[vertex] == 0) queue.addLast(vertex);
        }

        //Step 3: Run bfs. If after bfs, we're not able to
        //visit all vertices, then we have a cycle in the graph.
        //If graph has cycles, means topological sort not possible.
        //i.e. wrt question, not possible to schedule courses.
        boolean[] visited = new boolean[numCourses];
        int totalVisitedVertices = bfsKahn(adj, queue, inDegrees, visited);
        if (totalVisitedVertices != numCourses) {
            return false;
        }

        //else if cycle not detected in graph means,
        //topological sort is certainly possible i.e.
        //in context of this question, scheduling the
        //course is possible.
        return true;
    }

    //BFS for kahn's algorithm
    private int bfsKahn(List<List<Integer>> adj, Deque<Integer> queue, int[] inDegrees, boolean[] visited) {
        int visitedVertices = 0;

        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            if (visited[curr]) continue;

            visited[curr] = true;
            visitedVertices += 1;

            List<Integer> neighbours = adj.get(curr);
            for (int neighbour: neighbours) {

                //Decrement the indegree of each neighbour,
                //and if indegree becomes 0, add to queue.
                inDegrees[neighbour] -= 1;
                if (inDegrees[neighbour] == 0) {
                    queue.addLast(neighbour);
                }
            }
        }

        return visitedVertices;
    }

    private boolean revise(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<List<Integer>> graph = getGraph(prerequisites, numCourses);

        for (int[] pre: prerequisites) {
            int c1 = pre[0];
            int c2 = pre[1];

            indeg[c1] += 1;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i =0; i<indeg.length; i++) {
            if (indeg[i] == 0) q.addLast(i);
        }

        List<Integer> visited = new ArrayList<>();
        // int[] seen = new int[numCourses];
        while (!q.isEmpty()) {
            int n = q.removeFirst();
            // if (seen[n] == -1) continue;

            // seen[n] = -1;
            visited.add(n);
            List<Integer> neighbours = graph.get(n);
            for (int neigh: neighbours) {
                indeg[neigh] -= 1;
                if (indeg[neigh] == 0) q.addLast(neigh);
            }
        }

        return visited.size() == numCourses;
    }

    private List<List<Integer>> getGraph(int[][] prerequisites, int numCourses) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre: prerequisites) {
            int u = pre[0];
            int v = pre[1];

            graph.get(v).add(u);
        }

        return graph;
    }
}
