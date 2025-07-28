class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
        long long good_subarrays_count = 0;
        std::map<int, int> freq_map;
        long long current_pairs = 0;
        int left = 0;
        int n = nums.size();

        for (int right = 0; right < n; ++right) {
            current_pairs -= (long long)freq_map[nums[right]] * (freq_map[nums[right]] - 1) / 2;
            freq_map[nums[right]]++;
            current_pairs += (long long)freq_map[nums[right]] * (freq_map[nums[right]] - 1) / 2;

            while (current_pairs >= k) {
                good_subarrays_count += (n - right);
                current_pairs -= (long long)freq_map[nums[left]] * (freq_map[nums[left]] - 1) / 2;
                freq_map[nums[left]]--;
                current_pairs += (long long)freq_map[nums[left]] * (freq_map[nums[left]] - 1) / 2;
                left++;
            }
        }
        return good_subarrays_count;
    }
};