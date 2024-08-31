package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];

        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1' && visited[i][j] != -1) {
                    count += 1;
                    mask(grid, i, j, m, n, visited);
                }
            }
        }

        return count;
    }

    private void mask(char[][] grid, int i, int j, int m, int n, int[][] visited) {
        if (
                i < 0 || i >= m ||
                        j < 0 || j >= n ||
                        grid[i][j] != '1' ||
                        visited[i][j] == -1
        ) return;

        visited[i][j] = -1;

        mask(grid, i-1, j, m, n, visited);
        mask(grid, i+1, j, m, n, visited);
        mask(grid, i, j-1, m, n, visited);
        mask(grid, i, j+1, m, n, visited);
    }
}
