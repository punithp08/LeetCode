class Solution(object):
    def smallestSubarrays(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        
        suffix_or = [0] * n
        suffix_or[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            suffix_or[i] = nums[i] | suffix_or[i + 1]
            
        answer = [0] * n
        
        MAX_BITS = 30
        last_bit_idx = [-1] * MAX_BITS 
        
        for i in range(n - 1, -1, -1):
            current_num = nums[i]
            target_max_or = suffix_or[i]
            
            for bit_pos in range(MAX_BITS):
                if (current_num >> bit_pos) & 1:
                    last_bit_idx[bit_pos] = i
            
            min_j = i
            
            for bit_pos in range(MAX_BITS):
                if (target_max_or >> bit_pos) & 1:
                    min_j = max(min_j, last_bit_idx[bit_pos])
            
            answer[i] = min_j - i + 1
            
        return answer