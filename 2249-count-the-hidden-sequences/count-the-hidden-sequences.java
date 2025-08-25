class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
     long current = 0;
        long minVal = 0;
        long maxVal = 0;

        for (int diff : differences) {
            current += diff;
            minVal = Math.min(minVal, current);
            maxVal = Math.max(maxVal, current);
        }

        long possibleFirstElements = (upper - lower) - (maxVal - minVal) + 1;

        return (int) Math.max(0, possibleFirstElements);   
    }
}