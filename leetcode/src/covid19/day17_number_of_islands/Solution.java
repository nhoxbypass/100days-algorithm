package covid19.day17_number_of_islands;

class Solution {
    public static void main(String[] args) {
        char[][] map = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int res = numIslands(map);
        System.out.println(res);
    }

    public static int numIslands(char[][] grid) {
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    travelOnIsland(grid, i, j);
                    island++;
                }
            }
        }
        return island;
    }

    private static void travelOnIsland(char[][] grid, int row, int col) {
        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
            grid[row - 1][col] = '0';
            travelOnIsland(grid, row - 1, col);
        }

        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
            grid[row + 1][col] = '0';
            travelOnIsland(grid, row + 1, col);
        }

        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
            grid[row][col - 1] = '0';
            travelOnIsland(grid, row, col - 1);
        }

        if (col + 1 < grid[row].length && grid[row][col + 1] == '1') {
            grid[row][col + 1] = '0';
            travelOnIsland(grid, row, col + 1);
        }
    }
}