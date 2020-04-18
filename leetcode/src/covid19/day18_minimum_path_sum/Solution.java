package covid19.day18_minimum_path_sum;

class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        int res = minPathSum(grid);
        System.out.println(res);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (i == 0) {
                    // The only way is right
                    grid[i][j] += grid[0][j - 1];
                } else if (j == 0) {
                    // The only way is down
                    grid[i][j] += grid[i - 1][0];
                } else {
                    // Two ways to reach i,j is down & right: so take minimum way
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}