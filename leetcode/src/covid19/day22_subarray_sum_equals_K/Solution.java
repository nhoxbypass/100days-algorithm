package covid19.day22_subarray_sum_equals_K;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        int res = subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(res);
    }

    /*
     * Time: O(n), Space: O(n)
     *
     * sum(i,j) = sum(0,j)-sum(0,i). Where sum(i,j) represents the sum of all the elements from index i to j-1.
     * So we need to find
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Add first value to support case sum(0,j) = K (or sum(0,j)-sum(0,0) = K or sum(0,j)-K = 0)
        map.put(0, 1);
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            // It means sum(0,j)-K = sum(pos_in_map) (or sum(0,j)-sum(pos_in_map) = K)
            // We found an sub-array [pos_in_map,j] with sum K
            if (map.containsKey(sum - k))
                count += map.get(sum - k);

            // Put new item (if this sum value doesn't exist), or increase the sum frequency (if this sum already exist)
            int sumFreq = map.getOrDefault(sum, 0);
            map.put(sum, sumFreq + 1);
        }
        return count;
    }

    /*
     * Time: O(n^2), Space: O(1)
     */
    /*public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }*/
}