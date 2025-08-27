class Solution {
    public boolean reorderedPowerOf2(int n) {
      String s = String.valueOf(n);
        int[] count = new int[10];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }

        Set<String> powersOf2 = new HashSet<>();
        long power = 1;
        while (power <= 1_000_000_000) {
            powersOf2.add(countDigits(power));
            power *= 2;
        }

        return powersOf2.contains(countDigits(n));
    }

    private String countDigits(long num) {
        int[] count = new int[10];
        String s = String.valueOf(num);
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        return Arrays.toString(count);  
    }
}