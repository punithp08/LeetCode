class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix or not matrix[0]:
            return 0
        
        rows = len(matrix)
        cols = len(matrix[0])
        heights = [0] * cols
        max_area = 0

        def largestRectangleArea(h):
            stack = [-1]
            area = 0
            for i, height in enumerate(h):
                while stack[-1] != -1 and h[stack[-1]] >= height:
                    current_height = h[stack.pop()]
                    width = i - stack[-1] - 1
                    area = max(area, current_height * width)
                stack.append(i)
            
            while stack[-1] != -1:
                current_height = h[stack.pop()]
                width = len(h) - stack[-1] - 1
                area = max(area, current_height * width)
            
            return area

        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == '1':
                    heights[j] += 1
                else:
                    heights[j] = 0
            
            max_area = max(max_area, largestRectangleArea(heights))

        return max_area 