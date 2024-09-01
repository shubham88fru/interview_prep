package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/max-area-of-island/description/
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1 && visited[i][j] != -1) {
                    int[] area = {0};
                    mask(grid, i, j, m, n, area, visited);
                    maxArea = Math.max(maxArea, area[0]);
                }
            }
        }

        return maxArea;
    }

    private void mask(int[][] grid, int i, int j, int m, int n, int[] area, int[][] visited) {
        if (
                i < 0 || i >= m ||
                        j < 0 || j >= n ||
                        grid[i][j] != 1 ||
                        visited[i][j] == -1
        ) return;

        area[0] += 1;
        visited[i][j] = -1;

        mask(grid, i-1, j, m, n, area, visited);
        mask(grid, i+1, j, m, n, area, visited);
        mask(grid, i, j-1, m, n, area, visited);
        mask(grid, i, j+1, m, n, area, visited);
    }
}
