class Solution(object):
    def numSubseq(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        n = len(nums)
        mod = 10**9 + 7
        
        powers_of_2 = [1] * n
        for i in range(1, n):
            powers_of_2[i] = (powers_of_2[i - 1] * 2) % mod
            
        left, right = 0, n - 1
        count = 0
        
        while left <= right:
            if nums[left] + nums[right] <= target:
                count = (count + powers_of_2[right - left]) % mod
                left += 1
            else:
                right -= 1
        
        return count