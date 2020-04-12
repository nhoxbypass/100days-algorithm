package covid19.day9;

class Solution {
    public static void main(String[] args) {
        backspaceCompare("a##c", "#a#c");
    }

    public static boolean backspaceCompare(String S, String T) {
        if (S.isEmpty() && T.isEmpty())
            return true;
        if (S.isEmpty() || T.isEmpty())
            return false;

        int skipS = 0, skipT = 0;
        int caretS = S.length() - 1, caretT = T.length() - 1;
        while (caretS >= 0 || caretT >= 0) {
            while (caretS >= 0) {
                if (S.charAt(caretS) == '#') {
                    skipS++;
                    caretS--;
                } else {
                    if (skipS > 0) {
                        caretS--;
                        skipS--;
                    } else {
                        break;
                    }
                }
            }

            while (caretT >= 0) {
                if (T.charAt(caretT) == '#') {
                    skipT++;
                    caretT--;
                } else {
                    if (skipT > 0) {
                        caretT--;
                        skipT--;
                    } else {
                        break;
                    }
                }
            }

            if (caretS >= 0 && caretT >= 0) {
                if (S.charAt(caretS) == T.charAt(caretT)) {
                    caretS--;
                    caretT--;
                } else {
                    return false;
                }
            } else {
                if (caretS >= 0 || caretT >= 0) {
                    return false;
                }
            }
        }

        return true;
    }
}