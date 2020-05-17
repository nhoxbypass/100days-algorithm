package covid19_1.day13_remove_K_digits;

class Solution {
    public static void main(String[] args) {
        String res = removeKdigits("1234567890", 9);
        System.out.println(res);
    }

    public static String removeKdigits(String num, int k) {
        if (k >= num.length())
            return "0";

        StringBuilder builder = new StringBuilder(num);
        int caret = 0;
        while (k > 0 && caret < builder.length() - 1) {
            if (builder.charAt(caret) <= builder.charAt(caret + 1)) {
                caret++;
            } else {
                builder.deleteCharAt(caret);
                k--;
                // Go back a character
                if (caret != 0)
                    caret--;
            }
        }

        // Delete last chars until number of deleted is K
        if (k > 0) {
            builder.delete(builder.length() - k, builder.length());
        }

        // Remove leading zeroes
        while (builder.length() > 0) {
            if (builder.charAt(0) == '0') {
                builder.deleteCharAt(0);
            } else {
                break;
            }
        }

        if (builder.length() == 0)
            return "0";
        return builder.toString();
    }

    /*public static String removeKdigits(String num, int k) {
        if (k >= num.length())
            return "0";

        int keep = num.length() - k;
        char[] newNum = null;
        int currMinIdx = 0;
        int currCaret = 0;
        for (int i = 0; i < keep; i++) {
            // Find the index of the min character (from previous min idx, limit with keep - i)
            currMinIdx = findMin(num, currMinIdx, keep - i);
            char currMinChar = num.charAt(currMinIdx);
            if (newNum == null) {
                if (currMinChar != '0') {
                    newNum = new char[keep - i];
                    newNum[currCaret] = currMinChar;
                    currCaret++;
                } else {
                    // Skip leading zero
                }
            } else {
                newNum[currCaret] = currMinChar;
                currCaret++;
            }
            currMinIdx++;
        }

        if (newNum == null)
            return "0";
        return new String(newNum);
    }

    public static int findMin(String num, int fromIdx, int minLen) {
        int minIdx = fromIdx;
        char min = num.charAt(fromIdx);
        for (int i = fromIdx; i <= num.length() - minLen; i++) {
            char val = num.charAt(i);
            if (val < min) {
                minIdx = i;
                min = val;
            }
        }
        return minIdx;
    }*/
}