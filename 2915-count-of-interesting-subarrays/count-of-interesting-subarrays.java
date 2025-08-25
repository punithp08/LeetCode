class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
     long count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for (int num : nums) {
            int val = (num % modulo == k) ? 1 : 0;
            prefixSum = (prefixSum + val) % modulo;

            int target = (prefixSum - k + modulo) % modulo;
            count += freq.getOrDefault(target, 0);

            freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;   
    }
}