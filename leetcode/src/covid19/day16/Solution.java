package covid19.day16;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        checkValidString(")(");
    }

    public static boolean checkValidString(String s) {
        int len = s.length();

        int countOpen = 0;
        int countClose = 0;
        for (int i = 0; i < len; i++) {
            // Ưu tiên tất cả * đều tính là open "("
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                countOpen++;
            } else {
                countOpen--;
            }
            // Nếu như đã ưu tiên mà số close ")" vẫn nhiều hơn (`countOpen` < 0) thì coi như ko valid
            if (countOpen < 0)
                return false;

            // Tương tự, nhưng duyệt ngược lại, và ưu tiên tất cả * đều tính là close ")"
            if (s.charAt(len - 1 - i) == ')' || s.charAt(len - 1 - i) == '*') {
                countClose++;
            } else {
                countClose--;
            }
            if (countClose < 0)
                return false;
        }

        return true;
    }
}