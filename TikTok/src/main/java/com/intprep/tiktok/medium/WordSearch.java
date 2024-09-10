package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/word-search/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j]==word.charAt(0)) {
                    if (dfs(board, word, i, j, m, n, 0, new int[m][n])) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int m, int n, int curr, int[][] visited) {
        if (curr >= word.length()) return true;
        if (
                i >= m || i < 0 ||
                        j >= n || j < 0 ||
                        word.charAt(curr) != board[i][j] ||
                        visited[i][j] == -1
        ) return false;

        visited[i][j] = -1;

        boolean left = dfs(board, word, i, j-1,  m, n,curr+1, visited);
        if (left) return true;

        boolean right = dfs(board, word, i, j+1,  m, n,curr+1, visited);
        if (right) return true;

        boolean up = dfs(board, word, i-1, j,  m, n,curr+1, visited);
        if (up) return true;

        boolean down = dfs(board, word, i+1, j,  m, n,curr+1, visited);
        if (down) return true;

        visited[i][j] = 0;

        return false;
    }
}
