class Solution {
    public double new21Game(int n, int k, int maxPts) {
     if (k == 0 || n >= k + maxPts) {
            return 1.0;
        }

        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double s = 1.0;
        double ans = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = s / maxPts;
            if (i < k) {
                s += dp[i];
            }
            if (i >= maxPts) {
                s -= dp[i - maxPts];
            }
        }

        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }

        return ans;   
    }
}