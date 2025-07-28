class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
     int max_score = 0;
        int current_sum = 0;
        int left = 0;
        std::unordered_set<int> unique_elements;

        for (int right = 0; right < nums.size(); ++right) {
            while (unique_elements.count(nums[right])) {
                unique_elements.erase(nums[left]);
                current_sum -= nums[left];
                left++;
            }
            unique_elements.insert(nums[right]);
            current_sum += nums[right];
            max_score = std::max(max_score, current_sum);
        }
        return max_score;   
    }
};