class Solution(object):
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        memo = {}
        
        def solve(s1_sub, s2_sub):
            if (s1_sub, s2_sub) in memo:
                return memo[(s1_sub, s2_sub)]
            
            if s1_sub == s2_sub:
                return True
            
            if collections.Counter(s1_sub) != collections.Counter(s2_sub):
                return False
            
            n = len(s1_sub)
            for i in range(1, n):
                # Case 1: No swap
                if solve(s1_sub[:i], s2_sub[:i]) and solve(s1_sub[i:], s2_sub[i:]):
                    memo[(s1_sub, s2_sub)] = True
                    return True
                
                # Case 2: Swap
                if solve(s1_sub[:i], s2_sub[n-i:]) and solve(s1_sub[i:], s2_sub[:n-i]):
                    memo[(s1_sub, s2_sub)] = True
                    return True
            
            memo[(s1_sub, s2_sub)] = False
            return False

        return solve(s1, s2) 