package covid19_1.day6_majority_element;

class Solution {
    public static void main(String[] args) {
        int res = majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(res);
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        // We take any number and make it the most frequent number
        int maxCount = 1;
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num == maxNum) {
                // When encounter it again, increase the frequency
                maxCount++;
            } else {
                // When meet other number, we decrease the frequency
                // The number with most frequency will be stay in the end
                maxCount--;
                if (maxCount == 0) {
                    maxNum = num;
                    maxCount = 1;
                }
            }
        }

        return maxNum;
    }

    /*public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                max = entry.getKey();
            }
        }

        return max;
    }*/
}