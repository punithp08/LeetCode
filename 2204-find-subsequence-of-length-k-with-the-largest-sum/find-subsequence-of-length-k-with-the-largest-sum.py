class Solution(object):
    def maxSubsequence(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        sorted_nums = sorted(nums, reverse=True)
        top_k_elements = sorted_nums[:k]
        counts = collections.Counter(top_k_elements)
        result = []
        for num in nums:
            if counts[num] > 0:
                result.append(num)
                counts[num] -= 1
        return result