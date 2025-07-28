class Solution(object):
    def largestDivisibleSubset(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
            return []

        nums.sort()
        n = len(nums)
        
        # dp[i] stores the length of the largest divisible subset ending with nums[i]
        dp = [1] * n
        # prev[i] stores the index of the previous element in the largest divisible subset ending with nums[i]
        prev = [-1] * n
        
        max_len = 0
        end_idx = -1

        for i in range(n):
            for j in range(i):
                if nums[i] % nums[j] == 0:
                    if dp[j] + 1 > dp[i]:
                        dp[i] = dp[j] + 1
                        prev[i] = j
            
            if dp[i] > max_len:
                max_len = dp[i]
                end_idx = i
        
        result = []
        current_idx = end_idx
        while current_idx != -1:
            result.append(nums[current_idx])
            current_idx = prev[current_idx]
            
        return result[::-1]