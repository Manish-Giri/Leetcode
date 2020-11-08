package countprimes.bruteforce;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: 0
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: 0
 * <p>
 * <p>
 * Let's start with a isPrime function. To determine if a number is prime, we need to check if it is not divisible by any
 * number less than n. The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers
 * up to n would be O(n2). Could we do better?
 * <p>
 * As we know the number must not be divisible by any number > n / 2, we can immediately cut the total iterations half by
 * dividing only up to n / 2. Could we still do better?
 * <p>
 * Let's write down all of 12's factors:
 * <p>
 * 2 × 6 = 12
 * 3 × 4 = 12
 * 4 × 3 = 12
 * 6 × 2 = 12
 * As you can see, calculations of 4 × 3 and 6 × 2 are not necessary. Therefore, we only need to consider factors up to √n because, if n is divisible by some number p, then n = p × q and since p ≤ q, we could derive that p ≤ √n.
 * <p>
 * Our total runtime has now improved to O(n1.5), which is slightly better. Is there a faster approach?
 */
class Solution {

    /*
    Runtime: 566 ms, faster than 5.34% of Java online submissions for Count Primes.
    Memory Usage: 35.9 MB, less than 6.00% of Java online submissions for Count Primes.
    */

    int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    private boolean isPrime(int num) {
        for (int i = 2; (i * i <= num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(10));
    }

}
