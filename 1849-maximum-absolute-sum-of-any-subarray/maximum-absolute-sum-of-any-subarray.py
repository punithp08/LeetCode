class Solution(object):
    def maxAbsoluteSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_so_far = 0
        current_max = 0

        min_so_far = 0
        current_min = 0

        for num in nums:
            current_max += num
            max_so_far = max(max_so_far, current_max)
            if current_max < 0:
                current_max = 0

            current_min += num
            min_so_far = min(min_so_far, current_min)
            if current_min > 0:
                current_min = 0
        
        return max(abs(max_so_far), abs(min_so_far))   