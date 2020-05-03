package covid19_1.day2_jewels_and_stones;

class Solution {
    public static void main(String[] args) {
    }

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            for (int j = 0; j < S.length(); j++) {
                if (c == S.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }
}