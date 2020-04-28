package covid19.day26_maximal_square;

class Solution {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
        
        /*
            [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]
            []
            [['0','0','0','1'],['1','1','0','1'],['1','1','1','1'],['0','1','1','1'],['0','1','1','1']]
         */

        int res = maximalSquare(matrix);
        System.out.println(res);
    }

    public static int maximalSquare(char[][] matrix) {
        int M = matrix.length;
        if (M == 0)
            return 0;
        int N = matrix[0].length;
        if (N == 0)
            return 0;

        int maxEdge = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '1') {
                    // Because the requirement is to get max area,
                    // So, when we reach any '1', we just need to check whether this position can form a BIGGER square
                    // We don't need to check every square that can created ([1x1], [2x2],..)
                    while (true) {
                        if (i + maxEdge >= M)
                            break;
                        if (j + maxEdge >= N)
                            break;

                        if (isValidSquare(matrix, i, j, maxEdge)) {
                            maxEdge++;
                        } else {
                            break;
                        }
                    }
                } else {
                    // Hmmmm
                }
            }
        }

        return maxEdge * maxEdge;
    }

    private static boolean isValidSquare(char[][] matrix, int row, int col, int step) {
        for (int i = row; i <= row + step; i++) {
            for (int j = col; j <= col + step; j++) {
                if (matrix[i][j] == '0') {
                    return false;
                }
            }
        }
        return true;
    }

    /*private static void clearProcessedMatrix(char[][] matrix, int row, int col, int step) {
        for (int i = row; i <= row + step; i++) {
            for (int j = col; j <= col + step; j++) {
                matrix[i][j] = '0';
            }
        }
    }*/
}