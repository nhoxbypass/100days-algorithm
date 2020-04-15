package covid19.day13;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0};
        int res = findMaxLength(nums);
        System.out.println(res);
    }

    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        int n = nums.length;
        int sum = 0;
        int maxLen = 0;

        /*for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] == 0) ? -1 : 1;
        }*/

        int currLen;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            currLen = i + 1;
            if (currLen % 2 == 0 && sum == currLen / 2) {
                // Is balanced array
                maxLen = i + 1;
            }

            // If this sum is seen before, then check to update max length
            if (sumMap.containsKey(sum + n)) {
                if (maxLen < i - sumMap.get(sum + n)) {
                    maxLen = i - sumMap.get(sum + n);
                }
            } else {
                // Else put this sum in hash table
                sumMap.put(sum + n, i);
            }
        }

        return maxLen;
    }

    public static int findMaxLength_n2(int[] nums) {
        int arrayLen = nums.length;

        if (arrayLen < 2)
            return 0;

        int maxLength = 0;

        for (int s = 0; s < arrayLen - 1; s++) {
            int maxEnd = (arrayLen - s) % 2 == 0 ? arrayLen - 1 : arrayLen - 2;
            int sum = sum(nums, s, maxEnd);
            for (int e = maxEnd; e >= s + 1; e -= 2) {
                int len = e - s + 1;
                if (sum == len / 2) {
                    if (len > maxLength) {
                        maxLength = len;
                    }
                }

                sum -= nums[e];
                sum -= nums[e - 1];
            }
        }

        return maxLength;
    }

    private static int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}