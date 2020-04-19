package covid19.day6_group_anagrams;

import java.util.*;

class Solution {
    public static void main(String[] args) {
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int N = strs.length;

        if (N == 0)
            return new ArrayList<>();

        HashMap<Integer, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        int[] primes = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101
        };

        for (String s : strs) {
            // Prime number cannot get duplicated when multiply!
            int score = getScoreOf(s, primes);
            List<String> list = map.get(score);
            if (list == null) {
                list = new ArrayList<>();
                map.put(score, list);
                res.add(list);
            }
            list.add(s);
        }
        return res;
    }

    private int getScoreOf(String s, int[] primes) {
        int score = 1;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            score *= primes[c - 'a'];
        }
        return score;
    }

    /*public List<List<String>> groupAnagrams(String[] strs) {
        int N = strs.length;

        if (N == 0)
            return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String sorted = getSortedString(strs[i]);
            List<String> sub = map.get(sorted);
            if (sub != null) {
                sub.add(strs[i]);
            } else {
                sub = new ArrayList<>();
                sub.add(strs[i]);
                map.put(sorted, sub);
            }
        }

        return new ArrayList<>(map.values());
    }

    public String getSortedString(String str) {
        char[] ar = str.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }*/
}