package covid19.day3_maximum_subarray;

class Solution {
    static int currMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1};
        int max = maxSubArray(nums);
        System.out.println(max);
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (dp[i] > max)
                max = dp[i];
        }

        return max;
    }

    static int travel(int[] nums, int start, int end) {
        int sum;
        int maxCross = Integer.MIN_VALUE;
        if (start == end)
            sum = nums[start];
        else {
            int mid = (start + end) / 2;
            sum = travel(nums, start, mid) + travel(nums, mid + 1, end);
            maxCross = maxCrossSubArray(nums, start, mid, end);
        }

        if (sum > currMax)
            currMax = sum;
        if (maxCross > currMax)
            currMax = maxCross;

        return sum;
    }

    static int maxCrossSubArray(int[] nums, int start, int mid, int end) {
        int maxLeftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= start; i--) {
            sum = sum + nums[i];
            if (sum > maxLeftSum)
                maxLeftSum = sum;
        }

        int maxRightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= end; i++) {
            sum = sum + nums[i];
            if (sum > maxRightSum)
                maxRightSum = sum;
        }

        return maxLeftSum + maxRightSum;
    }
}