package covid19_1.day12_single_element_in_a_sorted_array;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        int res = singleNonDuplicate(nums);
        System.out.println(res);
    }

    /**
     * For each pair,
     * FIRST element always takes EVEN pos, and SECOND element takes ODD position
     * <p>
     * This pattern will be missed when single element is appeared in the array.
     */
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        return binarySearch(nums, 0, nums.length);
    }


    private static int binarySearch(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }

        int midPos = start + (end - start) / 2;

        if (midPos == 0 || midPos == nums.length - 1)
            return nums[midPos];

        // If MID position is EVEN --> we need to compare with NEXT item
        // Otherwise, compare with PREVIOUS item
        int pairPos = (midPos % 2 == 0) ? 1 : -1;

        // Compare MID item with it's pair
        if (nums[midPos] != nums[midPos + pairPos]) {
            // It's not equals to it's pair
            // So the unique item could be
            // - this MID item
            // - in the LEFT part of the MID item
            if (nums[midPos] != nums[midPos - pairPos]) {
                // it's not equals to any relevant item --> it's the unique item
                return nums[midPos];
            } else {
                // Continue search in the LEFT part of the MID item
                return binarySearch(nums, start, midPos - 1);
            }
        } else {
            // It's still equals to it's pair
            // So the unique item must be in the RIGHT part of the MID item
            // --> continue search in the RIGHT part.
            return binarySearch(nums, midPos + 1, end);
        }
    }
}