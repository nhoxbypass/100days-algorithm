package covid19.day4_move_zeroes;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 0, 3, 12, 0};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int nonZeroIdx = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap
                temp = nums[nonZeroIdx];
                nums[nonZeroIdx] = nums[i];
                nums[i] = temp;

                nonZeroIdx++;
            }
        }
    }
}