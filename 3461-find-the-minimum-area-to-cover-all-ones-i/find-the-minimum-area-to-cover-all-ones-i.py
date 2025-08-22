class Solution(object):
    def minimumArea(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        rows = len(grid)
        cols = len(grid[0])
        min_row, max_row = rows, -1
        min_col, max_col = cols, -1

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    if r < min_row:
                        min_row = r
                    if r > max_row:
                        max_row = r
                    if c < min_col:
                        min_col = c
                    if c > max_col:
                        max_col = c

        if min_row == rows:
            return 0
        else:
            height = max_row - min_row + 1
            width = max_col - min_col + 1
            return height * width 