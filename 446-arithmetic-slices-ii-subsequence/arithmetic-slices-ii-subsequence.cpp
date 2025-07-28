class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
     int n = nums.size();
        if (n < 3) {
            return 0;
        }

        std::vector<std::map<long long, int>> dp(n);
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long long diff = (long long)nums[i] - nums[j];
                
                // Number of sequences of length at least 2 ending at j with this diff
                // that can be extended by nums[i]
                int count_at_j = dp[j].count(diff) ? dp[j][diff] : 0;
                
                // Add to total answer. These are sequences of length at least 3.
                ans += count_at_j;
                
                // Update dp[i][diff]:
                // 1. For the pair (nums[j], nums[i])
                // 2. For extending existing sequences ending at j with this diff
                dp[i][diff] += (1 + count_at_j);
            }
        }
        return ans;   
    }
};