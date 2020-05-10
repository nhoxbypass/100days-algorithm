package covid19_1.day10_find_the_town_judge;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int res = findJudge(2, new int[][]{{1, 2}});
        System.out.println(res);
    }

    public static int findJudge(int N, int[][] trust) {
        if (N == 1 && trust.length == 0)
            return 1;

        int[] count = new int[N];
        for (int i = 0; i < trust.length; i++) {
            int trusted = trust[i][1];
            int trustee = trust[i][0];
            count[trusted - 1] = count[trusted - 1] + 1;
            count[trustee - 1] = count[trustee - 1] - 1;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == N - 1)
                return i + 1;
        }
        return -1;
    }

    /*public static int findJudge(int N, int[][] trust) {
        if (N == 1 && trust.length == 0)
            return 1;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            countMap.put(trust[i][1], countMap.getOrDefault(trust[i][1], 0) + 1);
            countMap.put(trust[i][0], countMap.getOrDefault(trust[i][0], 0) - 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == N - 1)
                return entry.getKey();
        }
        return -1;
    }*/
}