class Solution {
    public int[][] merge(int[][] intervals) {
      if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastMerged = merged.getLast();

            if (currentInterval[0] <= lastMerged[1]) {
                lastMerged[1] = Math.max(lastMerged[1], currentInterval[1]);
            } else {
                merged.add(currentInterval);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);  
    }
}