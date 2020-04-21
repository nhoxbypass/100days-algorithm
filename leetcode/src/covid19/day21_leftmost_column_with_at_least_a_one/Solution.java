package covid19.day21_leftmost_column_with_at_least_a_one;

import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        BinaryMatrix binaryMatrix = new BinaryMatrixImpl();
        int res = leftMostColumnWithOne(binaryMatrix);
        System.out.println(res);
    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int n = dimensions.get(0), m = dimensions.get(1);

        int minCol = -1;
        int r = 0, c = m - 1;
        while (r < n && c >= 0) {
            if (binaryMatrix.get(r, c) == 0) {
                // Move down to find `1`
                r++;
            } else {
                minCol = c;
                // Move left to find the left most `1`
                c--;
            }
        }

        return minCol;
    }

    /*public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int n = dimensions.get(0), m = dimensions.get(1);
        int minCol = m;

        for (int r = 0; r < n; r++) {
            int pos = binarySearchLeftMost(binaryMatrix, 1, r, m);
            if (pos != -1 && pos < minCol) {
                minCol = pos;
            }
        }

        return minCol != m ? minCol : -1;
    }*/

    public static int binarySearchLeftMost(BinaryMatrix binaryMatrix, int target, int row, int M) {
        int left = 0;
        int right = M;
        while (left < right) {
            int mid = (left + right) >>> 1; // Similar to (left+right)/2, but faster
            int midVal = binaryMatrix.get(row, mid);

            if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }


    /**
     * This is the BinaryMatrix's API interface.
     * You should not implement it, or speculate about its implementation
     */

    interface BinaryMatrix {
        int get(int x, int y);

        List<Integer> dimensions();
    }

    static class BinaryMatrixImpl implements BinaryMatrix {

        int[][] mat;

        public BinaryMatrixImpl() {
            mat = new int[][]{
                    {0, 0},
                    {0, 1},
            };
        }

        @Override
        public int get(int x, int y) {
            return mat[x][y];
        }

        @Override
        public List<Integer> dimensions() {
            return Arrays.asList(mat.length, mat[0].length);
        }
    }
}