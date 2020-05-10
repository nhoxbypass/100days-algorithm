package covid19_1.day8_check_if_it_is_a_straight_line;

class Solution {
    public static void main(String[] args) {
        boolean res = checkStraightLine(new int[][]{{-3, -2}, {-1, -2}, {2, -2}, {-2, -2}, {0, -2}});
        System.out.println(res);
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2)
            return true;

        int[] first = coordinates[0];
        int[] second = coordinates[1];
        float frag = Math.abs((second[0] - first[0]) * 1.0f / (second[1] - first[1]));

        for (int i = 1; i < coordinates.length - 1; i++) {
            first = coordinates[i];
            second = coordinates[i + 1];
            float newFrag = Math.abs((second[0] - first[0]) * 1.0f / (second[1] - first[1]));

            if (newFrag != frag) {
                return false;
            }
        }

        return true;
    }
}