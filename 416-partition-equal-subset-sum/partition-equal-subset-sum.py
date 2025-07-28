class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        total_sum = sum(nums)
        
        if total_sum % 2 != 0:
            return False
        
        target_sum = total_sum // 2
        
        dp = [False] * (target_sum + 1)
        dp[0] = True
        
        for num in nums:
            for s in range(target_sum, num - 1, -1):
                dp[s] = dp[s] or dp[s - num]
                
        return dp[target_sum]