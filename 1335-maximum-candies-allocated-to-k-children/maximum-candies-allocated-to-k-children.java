class Solution {
    public int maximumCandies(int[] candies, long k) {
      int low = 0;
        int high = 1_000_000_000; // Maximum possible candy per pile is 10^7, but sum can be larger. A safe upper bound.
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == 0) { // If 0 candies per child, it's always possible unless k is extremely large and no candies.
                            // But problem constraints imply at least 1 candy per pile, so 0 is always possible.
                ans = Math.max(ans, mid);
                low = mid + 1;
                continue;
            }

            if (canAllocate(candies, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAllocate(int[] candies, long k, int numCandiesPerChild) {
        long totalChildrenServed = 0;
        for (int pile : candies) {
            totalChildrenServed += (pile / numCandiesPerChild);
        }
        return totalChildrenServed >= k;  
    }
}