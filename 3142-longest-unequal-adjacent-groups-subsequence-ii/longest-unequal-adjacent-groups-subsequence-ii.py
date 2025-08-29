class Solution(object):
    def getWordsInLongestSubsequence(self, words, groups):
        """
        :type words: List[str]
        :type groups: List[int]
        :rtype: List[str]
        """
        n = len(words)
        dp = [(1, [i]) for i in range(n)]
        
        def hamming_distance(s1, s2):
            if len(s1) != len(s2):
                return float('inf')
            dist = 0
            for c1, c2 in zip(s1, s2):
                if c1 != c2:
                    dist += 1
            return dist

        for i in range(n):
            for j in range(i):
                if groups[i] != groups[j] and len(words[i]) == len(words[j]) and hamming_distance(words[i], words[j]) == 1:
                    if dp[j][0] + 1 > dp[i][0]:
                        dp[i] = (dp[j][0] + 1, dp[j][1] + [i])
                        
        max_len = 0
        max_seq = []
        for length, seq in dp:
            if length > max_len:
                max_len = length
                max_seq = seq
        
        return [words[i] for i in max_seq]