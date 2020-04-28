package covid19.day27_first_unique_number;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        /*FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
        firstUnique.showFirstUnique(); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        firstUnique.showFirstUnique(); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        firstUnique.showFirstUnique(); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        firstUnique.showFirstUnique(); // return -1*/

        FirstUnique firstUnique = new FirstUnique(new int[]{7, 7, 7, 7, 7, 7});
        firstUnique.showFirstUnique();
        firstUnique.add(7);
        firstUnique.add(3);
        firstUnique.add(3);
        firstUnique.add(7);
        firstUnique.add(17);
        firstUnique.showFirstUnique();

        /*
        ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
        [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
         */
    }

    static class FirstUnique {
        // Insert all array elements in hash table
        Map<Integer, Integer> map = new LinkedHashMap<>();
        //int first = -1;

        public FirstUnique(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    // Duplicated
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }

            //findFirstUniqueValue();
        }

        public int showFirstUnique() {
            return findFirstUniqueValue();
        }

        public void add(int value) {
            if (map.containsKey(value)) {
                // Duplicated
                int dup = map.get(value);
                if (dup == 1) {
                    map.put(value, 2);
                    //first = -1;
                    //findFirstUniqueValue();
                } else {
                    map.put(value, dup + 1);
                }
            } else {
                map.put(value, 1);
                //first = -1;
                //findFirstUniqueValue();
            }
        }

        private int findFirstUniqueValue() {
            for (Map.Entry<Integer, Integer> x : map.entrySet()) {
                if (x.getValue() == 1) {
                    return x.getKey();
                }
            }
            return -1;
        }
    }
}

