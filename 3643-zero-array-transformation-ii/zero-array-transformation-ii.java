class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int qLen = queries.length;

        int low = 0;
        int high = qLen;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid == 0) {
                boolean allZeros = true;
                for (int x : nums) {
                    if (x != 0) {
                        allZeros = false;
                        break;
                    }
                }
                if (allZeros) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                continue;
            }

            if (check(mid, nums, queries, n)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int numQueries, int[] nums, int[][] queries, int n) {
        long[] totalDecrements = new long[n + 1];

        for (int i = 0; i < numQueries; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            totalDecrements[l] += val;
            if (r + 1 <= n) {
                totalDecrements[r + 1] -= val;
            }
        }

        long currentAvailableDecrement = 0;
        for (int i = 0; i < n; i++) {
            currentAvailableDecrement += totalDecrements[i];

            if (currentAvailableDecrement < nums[i]) {
                return false;
            }
        }

        return true;    
    }
}