package firstbadversion.attempt;

class VersionControl {
    boolean isBadVersion(int n) {
        return true;
    }
}

class Solution extends VersionControl {

    int firstBadVersion(int n) {
        int start = 1;
        int finish = n;
        if (start == finish)
            return start;
        return helperRec(start, finish);
        // return helperIter(start, finish);
    }

    /**
     * Recursive Implementation
     * Runtime: 32 ms, faster than 6.56% of Java online submissions for First Bad Version.
     * Memory Usage: 37.8 MB, less than 8.61% of Java online submissions for First Bad Version.
     */
    private int helperRec(int start, int finish) {
        // mid calculation to avoid overflow
        int mid = (start + finish) >>> 1;
        // base case - when currentVer is bad and currentVer - 1 is good
        // -> then currentVer is 1st bad version
        boolean isMidBad = isBadVersion(mid);
        if (isMidBad && !isBadVersion(mid - 1))
            return mid;
        else if (isMidBad) {
            // check lower half
            return helperRec(start, mid - 1);
        } else {
            // check upper half
            return helperRec(mid + 1, finish);
        }
    }


    /**
     * Iterative Implementation
     * Runtime: 16 ms, faster than 43.20% of Java online submissions for First Bad Version.
     * Memory Usage: 35.6 MB, less than 85.19% of Java online submissions for First Bad Version.
     */
    private int helperIter(int start, int finish) {
        while (start <= finish) {
            int mid = (start + finish) >>> 1;
            boolean isMidBad = isBadVersion(mid);
            if (isMidBad && !isBadVersion(mid - 1))
                return mid;
            if (isMidBad) {
                finish = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
