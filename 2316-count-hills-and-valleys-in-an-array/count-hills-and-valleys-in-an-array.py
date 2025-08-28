class Solution(object):
    def countHillValley(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        condensed_nums = []
        if nums:
            condensed_nums.append(nums[0])
            for i in range(1, len(nums)):
                if nums[i] != nums[i-1]:
                    condensed_nums.append(nums[i])
        
        if len(condensed_nums) < 3:
            return 0
        
        count = 0
        for i in range(1, len(condensed_nums) - 1):
            left_neighbor = condensed_nums[i-1]
            current_num = condensed_nums[i]
            right_neighbor = condensed_nums[i+1]
            
            if current_num > left_neighbor and current_num > right_neighbor:
                count += 1
            elif current_num < left_neighbor and current_num < right_neighbor:
                count += 1
                
        return count  