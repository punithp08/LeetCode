class Solution(object):
    def flowerGame(self, n, m):
        """
        :type n: int
        :type m: int
        :rtype: int
        """
        n_odd = (n + 1) // 2
        n_even = n // 2
        m_odd = (m + 1) // 2
        m_even = m // 2
        
        return n_odd * m_even + n_even * m_odd 