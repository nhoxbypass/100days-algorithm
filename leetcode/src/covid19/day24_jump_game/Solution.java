package covid19.day24_jump_game;

class Solution {
    public static void main(String[] args) {
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;

        if (nums[0] == 0)
            return false;

        // We travel back (from the end), to check if we able to jump over all `0` in the array.
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                int neededStep = 2; // The max step needed to jump over `0` item
                i--;
                while (nums[i] < neededStep) {
                    neededStep++;
                    i--;

                    if (i < 0)
                        return false;
                }
            }
        }

        return true;
    }

    /*
     * O(n)
     */
    /*public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;

        int maxStep = nums[0]; // max stands for the largest index that can be reached.
        for (int i = 0; i < nums.length; i++) {
            // if not enough to go to next
            if (maxStep < i)
                return false;

            // update max
            maxStep = Math.max(maxStep, i + nums[i]);

            // max is enough to reach the end
            if (maxStep >= nums.length - 1)
                return true;
        }

        return false;
    }*/
}