package covid19_1.day9_valid_perfect_square;

class Solution {
    public static void main(String[] args) {
        boolean res = isPerfectSquare(2147483647);
        System.out.println(res);
    }

    public static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int divided = num / mid;

            if (divided == mid && num % mid == 0)
                return true;

            if (mid > divided) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    /*public static boolean isPerfectSquare(int num) {
        int i = 1;
        while (true) {
            int divided = num / i;
            if (divided == i && num % i == 0)
                return true;

            if (divided < i)
                return false;

            i++;
        }
    }*/
}