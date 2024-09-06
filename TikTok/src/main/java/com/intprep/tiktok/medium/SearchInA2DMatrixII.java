package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchInA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        return revise(matrix, target);
    }

    private boolean revise(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n-1;
        while (i >= 0 && j >= 0 && i < m && j < n) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) {
                i += 1;
            } else {
                j -= 1;
            }
        }

        return false;
    }
}
