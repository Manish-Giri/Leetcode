package insdelgetrandomo1.incorrect;

import java.util.HashSet;
import java.util.Random;

/**
 * Runtime: 251 ms, faster than 6.85% of Java online submissions for Insert Delete GetRandom O(1).
 * Memory Usage: 46.2 MB, less than 40.38% of Java online submissions for Insert Delete GetRandom O(1).
 */

class RandomizedSet {
    HashSet<Integer> hs;

    /**
     * Initialize your data structure here.
     */
    RandomizedSet() {
        hs = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    boolean insert(int val) {
        if (!hs.contains(val)) {
            hs.add(val);
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    boolean remove(int val) {
        return hs.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    int getRandom() {
        int size = hs.size();
        Random rd = new Random();
        int rndInd = rd.nextInt(size);
        return hs.toArray(new Integer[size])[rndInd];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
