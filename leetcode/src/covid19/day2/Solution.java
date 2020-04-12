package covid19.day2;

class Solution {
    public static void main(String[] args) {
        boolean res = isHappy(22);
    }

    public static boolean isHappy(int number) {
        int[] loop_magic_numbs = new int[]{58, 89, 145};
        int magicIdx = 0;

        while (true) {
            int sum = 0;
            while (number > 0) {
                int d = number % 10;
                sum = sum + d * d;
                number = number / 10;
            }

            if (sum == 1)
                return true;

            if (magicIdx >= loop_magic_numbs.length) {
                return false;
            } else {
                if (sum == loop_magic_numbs[magicIdx]) {
                    magicIdx++;
                }
            }

            // continue
            number = sum;
        }
    }
}