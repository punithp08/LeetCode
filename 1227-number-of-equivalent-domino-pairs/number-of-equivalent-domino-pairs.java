class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
    Map<String, Integer> count = new HashMap<>();
        int ans = 0;

        for (int[] domino : dominoes) {
            Arrays.sort(domino);
            String key = domino[0] + ":" + domino[1];
            int c = count.getOrDefault(key, 0);
            ans += c;
            count.put(key, c + 1);
        }

        return ans;
            
    }
}