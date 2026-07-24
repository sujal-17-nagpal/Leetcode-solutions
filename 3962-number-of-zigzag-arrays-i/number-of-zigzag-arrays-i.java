class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;

        int[][] inc = new int[n][r + 1];
        int[][] dec = new int[n][r + 1];

        for (int i = l; i <= r; i++) {
            inc[0][i] = 1;
            dec[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int[] pref = new int[r + 1];
            int[] suff = new int[r + 1];

            for (int j = 0; j <= r; j++) {
                if (j > 0) pref[j] = (pref[j] + pref[j - 1]) % MOD;
                pref[j] = (pref[j] + dec[i - 1][j]) % MOD;
            }

            for (int j = r; j >= 0; j--) {
                if (j != r) suff[j] = (suff[j] + suff[j + 1]) % MOD;
                suff[j] = (suff[j] + inc[i - 1][j]) % MOD;
            }

            for (int curr = l; curr <= r; curr++) {
                inc[i][curr] = pref[curr - 1] % MOD;
            }

            for (int curr = l; curr < r; curr++) {
                dec[i][curr] = suff[curr + 1] % MOD;
            }
        }

        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans = (ans + inc[n - 1][i]) % MOD;
            ans = (ans + dec[n - 1][i]) % MOD;
        }

        return ans;
    }
}