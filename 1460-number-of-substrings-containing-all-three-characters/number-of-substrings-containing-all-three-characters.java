class Solution {
    public int numberOfSubstrings(String s) {
      int n = s.length();
        int count = 0;
        Map<Character, Integer> charCounts = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            charCounts.put(s.charAt(right), charCounts.getOrDefault(s.charAt(right), 0) + 1);

            while (charCounts.containsKey('a') && charCounts.get('a') > 0 &&
                   charCounts.containsKey('b') && charCounts.get('b') > 0 &&
                   charCounts.containsKey('c') && charCounts.get('c') > 0) {
              
                count += (n - right); 

                charCounts.put(s.charAt(left), charCounts.get(s.charAt(left)) - 1);
                left++;
            }
        }
        return count;  
    }
}