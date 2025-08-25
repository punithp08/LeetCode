class Solution {
    public int countSubarrays(int[] nums) {
      int count = 0;
        if (nums.length < 3) {
            return 0;
        }

        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] + nums[i + 2] == (double) nums[i + 1] / 2) {
                count++;
            }
        }
        return count;  
    }
}