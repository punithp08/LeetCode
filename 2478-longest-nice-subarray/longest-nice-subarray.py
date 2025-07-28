class Solution(object):
    def longestNiceSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        max_len = 0
        left = 0
        current_or = 0

        for right in range(n):
            while (current_or & nums[right]) != 0:
                current_or ^= nums[left]
                left += 1
            
            current_or |= nums[right]
            max_len = max(max_len, right - left + 1)
        
        return max_len