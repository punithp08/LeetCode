class Solution(object):
    def findLHS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        counts = collections.Counter(nums)
        max_length = 0
        for num in counts:
            if num + 1 in counts:
                max_length = max(max_length, counts[num] + counts[num + 1])
        return max_length