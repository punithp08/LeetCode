class Solution {
    public long minSum(int[] nums1, int[] nums2) {
     long sum1 = 0;
        long zeroCount1 = 0;
        for (int num : nums1) {
            if (num == 0) {
                zeroCount1++;
            }
            sum1 += num;
        }

        long sum2 = 0;
        long zeroCount2 = 0;
        for (int num : nums2) {
            if (num == 0) {
                zeroCount2++;
            }
            sum2 += num;
        }

        long minSum1 = sum1 + zeroCount1;
        long minSum2 = sum2 + zeroCount2;

        if (minSum1 > minSum2) {
            if (zeroCount2 == 0) {
                return -1;
            } else {
                return minSum1;
            }
        } else if (minSum2 > minSum1) {
            if (zeroCount1 == 0) {
                return -1;
            } else {
                return minSum2;
            }
        } else {
            return minSum1;
        }   
    }
}