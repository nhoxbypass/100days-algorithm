package covid19.day25_longest_common_subsequence;

/**
 * Note that:
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 */
class Solution {
    public static void main(String[] args) {
        int res = longestCommonSubsequence("abc", "abc");
        System.out.println(res);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int m = text1.length();
        int n = text2.length();

        if (m == 0 || n == 0)
            return 0;

        // We store longest matched sub-array (at a point of time) in lms[]
        int[] lms = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                // Fetch the longest matched sub-array of the last char of text1 (arr1[i-1]) (or last row in table)
                // with this current char of text2 (current column in table)
                int prevLongest = lms[j];
                if (arr1[i - 1] == arr2[j - 1]) {
                    // Matched
                    // increase the longest matched sub-array length by 1
                    lms[j] = prev + 1;
                } else {
                    lms[j] = Math.max(lms[j], lms[j - 1]);
                }
                prev = prevLongest;
            }
        }
        return lms[n];
    }

    /*public static int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int m = text1.length();
        int n = text2.length();

        if (m == 0 || n == 0)
            return 0;

        // We store longest matched sub-array (at a point of time) in lms[][]
        int[][] lms = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    // Matched
                    // Check whether the previous chars arr1[i-1] and [arr2[j-1] (and also their previous chars) are also matching
                    // To check the longest match of previous chars, we get value from lms[i-1][j-1]
                    // Then increase the longest matched sub-array length by 1
                    lms[i][j] = lms[i - 1][j - 1] + 1;
                } else {
                    // Get the longest of the previous matched sub-sequence
                    // We get the longest of previous matched sub-sequence SO FAR when we reach [i-1][j] OR [i][j-1]
                    lms[i][j] = Math.max(lms[i - 1][j], lms[i][j - 1]);
                }
            }
        }

        // Return the longest sub-array (at the time we reach the end)
        return dp[m][n];
    }*/
}