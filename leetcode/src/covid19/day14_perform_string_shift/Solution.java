package covid19.day14_perform_string_shift;

class Solution {
    public static void main(String[] args) {
        int[][] shift = new int[][]{{0, 1}, {1, 2}};
        String res = stringShift("abc", shift);
        System.out.println(res);
    }

    public static String stringShift(String s, int[][] shift) {
        int length = s.length();
        int start = 0;
        int direction, amount;
        for (int i = 0; i < shift.length; i++) {
            direction = shift[i][0];
            amount = shift[i][1];

            while (amount > length) {
                amount -= length;
            }

            if (direction == 0) {
                // Left
                start = start + amount;
                if (start > length)
                    start = start - length;
            } else {
                // Right
                start = start - amount;
                if (start < 0)
                    start = length + start;
            }
        }

        char[] res = new char[length];
        if (start == 0) {
            for (int i = start; i < length; i++) {
                res[i] = s.charAt(i);
            }
        } else {
            int idx = 0;
            for (int i = start; i < length; i++) {
                res[idx] = s.charAt(i);
                idx++;
            }

            for (int i = 0; i < start; i++) {
                res[idx] = s.charAt(i);
                idx++;
            }
        }

        return new String(res);
    }
}