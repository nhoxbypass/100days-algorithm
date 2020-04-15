package covid19.day12;

class Solution {
    public static void main(String[] args) {
        int[] stones = new int[]{9, 3, 2, 10};
        lastStoneWeight(stones);
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 1)
            return stones[0];

        if (stones.length == 2)
            return Math.abs(stones[0] - stones[1]);

        //Arrays.sort(stones);

        int idx = 0;
        while (idx < stones.length - 1) {
            int firstMax = -1, secondMax = -1;
            int firstMaxIdx = -1, secondMaxIdx = -1;

            for (int i = idx; i < stones.length; i++) {
                if (stones[i] > firstMax) {
                    secondMax = firstMax;
                    secondMaxIdx = firstMaxIdx;

                    firstMax = stones[i];
                    firstMaxIdx = i;

                    continue;
                }

                if (stones[i] > secondMax) {
                    secondMax = stones[i];
                    secondMaxIdx = i;
                }
            }

            if (firstMax == secondMax) {
                stones[firstMaxIdx] = stones[idx];
                stones[secondMaxIdx] = stones[idx + 1];
                stones[idx] = -1;
                stones[idx + 1] = -1;
                idx += 2;
            } else {
                stones[firstMaxIdx] = firstMax - secondMax;
                stones[secondMaxIdx] = stones[idx];
                stones[idx] = -1;
                idx++;
            }
        }

        if (idx < stones.length)
            return stones[idx];
        return 0;
    }
}