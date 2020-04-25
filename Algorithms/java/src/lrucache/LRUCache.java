package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2  capacity  );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * <p>
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Runtime: 11 ms, faster than 99.92% of Java online submissions for LRU Cache.
 * Memory Usage: 47.6 MB, less than 100.00% of Java online submissions for LRU Cache.
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    int get(int key) {
        return super.getOrDefault(key, -1);
    }

    void put(int key, int value) {
        super.put(key, value);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/*
class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
     LRUCache(int capacity) {
        cache =  new LinkedHashMap<Integer, Integer>(capacity, 1, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
            {
                return size() > capacity;
            }
        };
    }

     int get(int key) {
        return cache.getOrDefault(key, -1);
    }

     void put(int key, int value) {
        cache.put(key, value);
    }
}

Details
Runtime: 12 ms, faster than 99.48% of Java online submissions for LRU Cache.
Memory Usage: 50.6 MB, less than 96.93% of Java online submissions for LRU Cache.
 */