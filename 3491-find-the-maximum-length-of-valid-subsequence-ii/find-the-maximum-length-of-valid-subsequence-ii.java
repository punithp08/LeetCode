class Solution {
    public int maximumLength(int[] nums, int k) {
       int n = nums.length;
        int maxOverallLength = 0;

        for (int c_val = 0; c_val < k; c_val++) {
            int[] dp_for_c_val = new int[k];

            for (int num : nums) {
                int curr_mod = num % k;
                int required_prev_mod = (c_val - curr_mod + k) % k;

                dp_for_c_val[curr_mod] = Math.max(dp_for_c_val[curr_mod], dp_for_c_val[required_prev_mod] + 1);
            }

            for (int len : dp_for_c_val) {
                maxOverallLength = Math.max(maxOverallLength, len);
            }
        }

        return maxOverallLength; 
    }
}