package designhashmap.efficient;

import java.util.LinkedList;
import java.util.List;

/**
 Design a HashMap without using any built-in hash table libraries.

 To be specific, your design should include these functions:

 put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

 Example:

 MyHashMap hashMap = new MyHashMap();
 hashMap.put(1, 1);
 hashMap.put(2, 2);
 hashMap.get(1);            // returns 1
 hashMap.get(3);            // returns -1 (not found)
 hashMap.put(2, 1);          // update the existing value
 hashMap.get(2);            // returns 1
 hashMap.remove(2);          // remove the mapping for 2
 hashMap.get(2);            // returns -1 (not found)
 */

class Pair<K,V> {
    private K key;
    private V value;

    Pair(K k, V v) {
        key = k;
        value = v;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    void setValue(V v) {
        value = v;
    }
}

class Bucket {
    // bucket is a linkedlist of pairs (Key->value) that map to a specific index of the HT
    private List<Pair<Integer, Integer>> bucket;

    Bucket() {
        bucket = new LinkedList<>();
    }

    Integer get(Integer key) {
        for(int i = 0; i < bucket.size(); i++) {
            if(bucket.get(i).getKey().equals(key)) {
                return bucket.get(i).getValue();
            }
        }
        return -1;
    }

    void delete(Integer key) {
        int idx = -1;
        for(int i = 0; i < bucket.size(); i++) {
            if(bucket.get(i).getKey().equals(key)) {
                idx = i;
                break;
            }
        }
        if(idx != -1) {
            bucket.remove(idx);
        }
    }

    void add(Integer key, Integer value) {
        for(int i = 0; i < bucket.size(); i++) {
            if(bucket.get(i).getKey().equals(key)) {
                bucket.get(i).setValue(value);
                return;
            }
        }
        bucket.add(new Pair<>(key, value));
    }
}

 class MyHashMap {
    int tableLen;
    Bucket[] hashTable;

    /** Initialize your data structure here. */
     MyHashMap() {
        tableLen = 2069;
        hashTable = new Bucket[tableLen];
        for(int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new Bucket();
        }
    }

    /** value will always be non-negative. */
     void put(int key, int value) {
        // get hashkey of the key
        int hash = key % tableLen;
        hashTable[hash].add(key, value);

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
     int get(int key) {
        int hash = key % tableLen;
        return hashTable[hash].get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
     void remove(int key) {
        int hash = key % tableLen;
        hashTable[hash].delete(key);
    }
}

/*
Success
Details
Runtime: 17 ms, faster than 50.63% of Java online submissions for Design HashMap.
Memory Usage: 47.1 MB, less than 100.00% of Java online submissions for Design HashMap.
 */

