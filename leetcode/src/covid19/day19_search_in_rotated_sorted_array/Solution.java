package covid19.day19_search_in_rotated_sorted_array;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int res = search(nums, 4);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public static int search(int[] nums, int start, int end, int target) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;

        if (nums[start] <= nums[mid]) {
            // First sub-array is completely sorted
            // We can check if the target item is in first sub-array or not
            if (nums[start] <= target && target <= nums[mid]) {
                // In first sub-array
                // From now on, the process is like normal binary search
                return search(nums, start, mid - 1, target);
            }

            // Retry with the second array
            return search(nums, mid + 1, end, target);
        } else {
            // Second sub-array is completely sorted
            // We can check if the target item is in second sub-array or not
            if (nums[mid] <= target && target <= nums[end]) {
                // In second sub-array
                // From now on, the process is like normal binary search
                return search(nums, mid + 1, end, target);
            }

            // Retry with the first array
            return search(nums, start, mid - 1, target);
        }
    }

    /*public static int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        if (pivot == -1) {
            // The array is not rotated
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (target == nums[pivot])
            return pivot;

        // We must compare with the first item, not the pivot item
        // To determine to search on left or right part
        if (nums[0] <= target) {
            return binarySearch(nums, 0, pivot - 1, target);
        } else {
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        }
    }

    public static int findPivot(int[] nums, int start, int end) {
        if (start > end)
            return -1;
        if (start == end)
            return start;

        int mid = start + (end - start) / 2;
        int midVal = nums[mid];

        if (mid < end && midVal > nums[mid + 1])
            return mid;

        if (mid > start && nums[mid - 1] > midVal)
            return mid;

        if (nums[start] > midVal) {
            // Start has lower index, but bigger -> the pivot must be in the first sub-array
            return findPivot(nums, start, mid);
        } else {
            return findPivot(nums, mid + 1, end);
        }
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        int midVal = nums[mid];

        if (midVal == target)
            return mid;
        if (nums[start] == target)
            return start;
        if (nums[end] == target)
            return end;

        if (target < midVal) {
            // In the left part
            return binarySearch(nums, start, mid - 1, target);
        } else {
            // In the right part
            return binarySearch(nums, mid + 1, end, target);
        }
    }*/
}