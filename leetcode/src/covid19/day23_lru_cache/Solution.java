package covid19.day23_lru_cache;

import java.util.LinkedHashMap;

class Solution {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        /*cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4*/
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);
    }

    static class LRUCache {
        private int capacity = 0;
        private int currCapacity = 0;
        private LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>();
        }

        public int get(int key) {
            Integer val = map.remove(key);
            if (val != null) {
                // Re-put into map to make it recent used
                map.put(key, val);
                return val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key) && currCapacity >= capacity) {
                map.remove(map.keySet().iterator().next()); // Remove the first inserted item
                map.put(key, value);
                currCapacity = capacity;
            } else {
                map.remove(key);
                map.put(key, value);
                currCapacity++;
            }
        }
    }
}