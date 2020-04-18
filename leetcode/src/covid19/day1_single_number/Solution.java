package covid19.day1_single_number;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 0, 3, 12, 0};
        int res = singleNumber(nums);
    }

    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}