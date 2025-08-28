class Solution(object):
    def sortMatrix(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: List[List[int]]
        """
        n = len(grid)
        
        diagonals = {}
        
        # Extract elements and group by diagonal
        for i in range(n):
            for j in range(n):
                diff = i - j
                if diff not in diagonals:
                    diagonals[diff] = []
                diagonals[diff].append(grid[i][j])
        
        # Sort diagonals based on their position
        for diff in diagonals:
            if diff >= 0:
                # Bottom-left triangle and middle diagonal (i - j >= 0)
                diagonals[diff].sort(reverse=True)
            else:
                # Top-right triangle (i - j < 0)
                diagonals[diff].sort()
                
        # Reconstruct the matrix
        result = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                diff = i - j
                if diff in diagonals:
                    result[i][j] = diagonals[diff].pop(0)
        
        return result