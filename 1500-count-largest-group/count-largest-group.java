class Solution {
    public int countLargestGroup(int n) {
      Map<Integer, Integer> groupSizes = new HashMap<>();
        int maxGroupSize = 0;
        
        for (int i = 1; i <= n; i++) {
            int digitSum = getDigitSum(i);
            int currentSize = groupSizes.getOrDefault(digitSum, 0) + 1;
            groupSizes.put(digitSum, currentSize);
            maxGroupSize = Math.max(maxGroupSize, currentSize);
        }
        
        int count = 0;
        for (int size : groupSizes.values()) {
            if (size == maxGroupSize) {
                count++;
            }
        }
        
        return count;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;  
    }
}