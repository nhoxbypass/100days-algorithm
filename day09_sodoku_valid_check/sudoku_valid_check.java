boolean sudoku2(char[][] grid) {
    // Init count array with 0 value. If value is 1 -> already found
    // If we general the matrix not (9 x 9) but (n x n), we will have
    // Additional memory O(3n)
    int[][] v = new int[9][9];
    int[][] h = new int[9][9];
    int[][] s = new int[9][9];
    
    // Time complexity O(n^2)
    for(int i = 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
            if(grid[i][j] != '.') {
                // Get the number out of the char
                int curr = grid[i][j] - '0';
                
                // Check vertical, horizontal, sub-matrix
                if(h[i][curr - 1] > 0 || v[curr - 1][j] > 0 || s[(i - i%3) + ((curr - 1)/3)][(j - j%3) + (curr - 1)%3] > 0) {
                    return false;
                }
                else {
                    // Mark item found vertical
                    v[curr - 1][j] = 1;
                    
                    // Mark item found horizontal
                    h[i][curr - 1] = 1;
                    
                    // Mark item found in sub-matrix
                    s[(i - i%3) + ((curr - 1)/3)][(j - j%3) + (curr - 1)%3] = 1;
                }
            } else {
                // Do nothing
            }
        }
    }
    
    return true;
}
