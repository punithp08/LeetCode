class Solution {
    public int countCompleteSubarrays(int[] nums) {
      Set<Integer> distinctElements = new HashSet<>();
        for (int num : nums) {
            distinctElements.add(num);
        }
        int totalDistinct = distinctElements.size();

        int count = 0;
        int left = 0;
        Map<Integer, Integer> window = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);

            while (window.size() == totalDistinct) {
                count += (nums.length - right);

                int leftElement = nums[left];
                window.put(leftElement, window.get(leftElement) - 1);
                if (window.get(leftElement) == 0) {
                    window.remove(leftElement);
                }
                left++;
            }
        }
        return count;   
    }
}