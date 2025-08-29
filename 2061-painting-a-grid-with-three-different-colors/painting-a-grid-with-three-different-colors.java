class Solution {
    public int colorTheGrid(int m, int n) {
     int MOD = 1_000_000_007;

        List<Integer> validMasks = new ArrayList<>();
        generateValidMasks(m, 0, new int[m], validMasks);

        Map<Integer, List<Integer>> transitions = new HashMap<>();
        for (int mask1 : validMasks) {
            for (int mask2 : validMasks) {
                if (canTransition(mask1, mask2, m)) {
                    transitions.computeIfAbsent(mask1, k -> new ArrayList<>()).add(mask2);
                }
            }
        }

        long[][] dp = new long[n][validMasks.size()];

        for (int i = 0; i < validMasks.size(); i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < validMasks.size(); j++) {
                int prevMask = validMasks.get(j);
                if (transitions.containsKey(prevMask)) {
                    for (int nextMask : transitions.get(prevMask)) {
                        int nextMaskIndex = validMasks.indexOf(nextMask);
                        dp[i][nextMaskIndex] = (dp[i][nextMaskIndex] + dp[i-1][j]) % MOD;
                    }
                }
            }
        }

        long totalWays = 0;
        for (long count : dp[n - 1]) {
            totalWays = (totalWays + count) % MOD;
        }

        return (int) totalWays;
    }

    private void generateValidMasks(int m, int row, int[] colors, List<Integer> validMasks) {
        if (row == m) {
            int mask = 0;
            for (int i = 0; i < m; i++) {
                mask = mask * 3 + colors[i];
            }
            validMasks.add(mask);
            return;
        }

        for (int c = 0; c < 3; c++) {
            if (row > 0 && colors[row - 1] == c) {
                continue;
            }
            colors[row] = c;
            generateValidMasks(m, row + 1, colors, validMasks);
        }
    }

    private boolean canTransition(int mask1, int mask2, int m) {
        int[] colors1 = new int[m];
        int[] colors2 = new int[m];
        int temp1 = mask1;
        int temp2 = mask2;
        for (int i = m - 1; i >= 0; i--) {
            colors1[i] = temp1 % 3;
            temp1 /= 3;
            colors2[i] = temp2 % 3;
            temp2 /= 3;
        }

        for (int i = 0; i < m; i++) {
            if (colors1[i] == colors2[i]) {
                return false;
            }
        }
        return true;   
    }
}