class Solution {
public:
    int countMaxOrSubsets(vector<int>& nums) {
     int max_or = 0;
        for (int num : nums) {
            max_or |= num;
        }

        int count = 0;
        int n = nums.size();

        for (int i = 0; i < (1 << n); ++i) {
            int current_or = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j) & 1) {
                    current_or |= nums[j];
                }
            }
            if (current_or == max_or) {
                count++;
            }
        }
        return count;
       
    }
};