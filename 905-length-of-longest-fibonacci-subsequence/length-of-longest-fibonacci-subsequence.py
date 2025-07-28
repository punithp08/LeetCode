class Solution(object):
    def lenLongestFibSubseq(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n = len(arr)
        s = set(arr)
        max_len = 0

        for i in range(n):
            for j in range(i + 1, n):
                a = arr[i]
                b = arr[j]
                current_len = 2
                while a + b in s:
                    current_len += 1
                    a, b = b, a + b
                max_len = max(max_len, current_len)

        return max_len if max_len >= 3 else 0    