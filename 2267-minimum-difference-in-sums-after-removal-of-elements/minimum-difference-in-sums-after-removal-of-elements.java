class Solution {
    public long minimumDifference(int[] nums) {
     int n = nums.length / 3;

        long[] minSumLeft = new long[3 * n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long currentSum = 0;

        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            currentSum += nums[i];
            if (maxHeap.size() > n) {
                currentSum -= maxHeap.poll();
            }
            if (maxHeap.size() == n) {
                minSumLeft[i] = currentSum;
            } else {
                minSumLeft[i] = Long.MAX_VALUE;
            }
        }

        long[] maxSumRight = new long[3 * n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        currentSum = 0;

        for (int i = 3 * n - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            currentSum += nums[i];
            if (minHeap.size() > n) {
                currentSum -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                maxSumRight[i] = currentSum;
            } else {
                maxSumRight[i] = Long.MAX_VALUE;
            }
        }

        long minDifference = Long.MAX_VALUE;

        for (int i = n - 1; i < 2 * n; i++) {
            if (minSumLeft[i] != Long.MAX_VALUE && maxSumRight[i + 1] != Long.MAX_VALUE) {
                minDifference = Math.min(minDifference, minSumLeft[i] - maxSumRight[i + 1]);
            }
        }

        return minDifference;   
    }
}