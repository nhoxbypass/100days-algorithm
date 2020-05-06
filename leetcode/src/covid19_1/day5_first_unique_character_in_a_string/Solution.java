package covid19_1.day5_first_unique_character_in_a_string;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int res = firstUniqChar("daodaodao");
        System.out.println(res);
    }

    public static int firstUniqChar(String s) {
        int res = Integer.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                // If first idx == last idx
                // --> unique
                // We need to get the min, because we're not looping in the real String
                res = Math.min(res, index);
            }
        }

        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    /*public static int firstUniqChar(String s) {
        if (s.isEmpty())
            return -1;
        if (s.length() == 1)
            return 0;

        Map<Character, Integer> countMap = new LinkedHashMap<>();
        Map<Character, Integer> resMap = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = countMap.getOrDefault(c, 0);
            if (count == 0) {
                countMap.put(c, 1);
                resMap.put(c, i);
            } else {
                resMap.remove(c);
                countMap.put(c, count + 1);
            }
        }

        for (Map.Entry<Character, Integer> x : resMap.entrySet()) {
            return x.getValue();
        }
        return -1;
    }*/

    /*public static int firstUniqChar(String s) {
        if (s.isEmpty())
            return -1;
        if (s.length() == 1)
            return 0;

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c == ' ')
                continue;

            boolean duplicated = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (c == arr[j]) {
                    duplicated = true;
                    arr[j] = ' ';
                }
            }
            if (!duplicated) {
                return i;
            }
        }
        return -1;
    }*/
}