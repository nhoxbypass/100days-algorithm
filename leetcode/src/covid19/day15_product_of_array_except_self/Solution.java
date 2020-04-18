package covid19.day15_product_of_array_except_self;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] res = productExceptSelf(nums);
        System.out.println(res);
    }

    public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];

        int product = 1;
        for (int i = 0; i < N; i++) {
            res[i] = product;
            product = product * nums[i];
        }

        product = 1;
        for (int i = N - 1; i >= 0; i--) {
            res[i] = res[i] * product;
            product = product * nums[i];
        }

        return res;
    }
}