class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
     if (mat == null || mat.length == 0) {
            return new int[0];
        }
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0;
        int col = 0;
        int direction = 1;
        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];
            if (direction == 1) {
                if (col == n - 1) {
                    direction = -1;
                    row++;
                } else if (row == 0) {
                    direction = -1;
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {
                    direction = 1;
                    col++;
                } else if (col == 0) {
                    direction = 1;
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;   
    }
}