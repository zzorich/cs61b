class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int xBound = matrix.length;
        int yBound = matrix[0].length;
        int[][] cache = new int[xBound][yBound];
        int max = 0;
        for (int i = 0; i < matrix.length - 1; i = i + 1) {
            for (int j = 0; j < matrix[0].length - 1; j = j + 1) {
                max = Math.max(helper(matrix, i, j, cache), max);
            }
        }
        return max;
    }

    private int helper(int[][] matrix, int x, int y, int[][] cache) {

        cache[x][y] = 1;
        if (!(0 <= x && x <= matrix.length - 1
                && y >= 0 && y <= matrix[0].length - 1)) {
            return 0;
        }
        if (cache[x][y] == 0) {
            if (x > 0) {
                if (matrix[x - 1][y] > matrix[x][y]) {
                    cache[x][y] = Math.max(1 + helper(matrix, x - 1, y, cache), cache[x][y]);
                }
            }

            if (y > 0) {
                if (matrix[x][y - 1] > matrix[x][y]) {
                    cache[x][y] = Math.max(1 + helper(matrix, x, y - 1, cache), cache[x][y]);
                }
            }

            if (x < matrix.length - 1) {
                if (matrix[x + 1][y] > matrix[x][y]) {
                    cache[x][y] = Math.max(1 + helper(matrix, x + 1, y, cache), cache[x][y]);
                }
            }

            if (y < matrix[0].length - 1) {
                if (matrix[x][y + 1] > matrix[x][y]) {
                    cache[x][y] = Math.max(helper(matrix, x, y + 1, cache),
                            cache[x][y]);
                }
            }

        }
        return cache[x][y];
    }
}