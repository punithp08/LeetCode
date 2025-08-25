class Solution {
    public String pushDominoes(String dominoes) {
      int n = dominoes.length();
        char[] result = dominoes.toCharArray();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, n);
        Arrays.fill(right, n);

        int lastR = -1;
        for (int i = 0; i < n; i++) {
            if (result[i] == 'R') {
                lastR = i;
            } else if (result[i] == 'L') {
                lastR = -1;
            }
            if (lastR != -1) {
                right[i] = i - lastR;
            }
        }

        int lastL = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (result[i] == 'L') {
                lastL = i;
            } else if (result[i] == 'R') {
                lastL = -1;
            }
            if (lastL != -1) {
                left[i] = lastL - i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (result[i] == '.') {
                if (left[i] < right[i]) {
                    result[i] = 'L';
                } else if (right[i] < left[i]) {
                    result[i] = 'R';
                }
            }
        }
        return new String(result);  
    }
}