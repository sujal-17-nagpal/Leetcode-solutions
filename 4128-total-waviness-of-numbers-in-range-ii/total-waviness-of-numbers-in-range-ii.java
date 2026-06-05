import java.util.Arrays;

class Solution {

    long[][][][][] dp;

    public long[] f(int idx, int tight, int prev, int inc, String s) {
        if (idx == s.length()) {
            return new long[]{1, 0};
        }
        
        if (dp[idx][tight][prev + 1][inc + 1][0] != -1) {
            return dp[idx][tight][prev + 1][inc + 1];
        }
        
        long ways = 0;
        long waviness = 0;
        
        if (prev == -1) {
            int max = (tight == 1) ? s.charAt(idx) - '0' : 9;
            for (int i = 1; i <= max; i++) {
                int newTight = ((i == max && tight == 1) ? 1 : 0);
                long[] res = f(idx + 1, newTight, i, -1, s);
                ways += res[0];
                waviness += res[1];
            }
            int newTight = (tight == 1 && s.charAt(idx) == '0') ? 1 : 0;
            long[] res = f(idx + 1, newTight, -1, -1, s);
            ways += res[0];
            waviness += res[1];
            
            dp[idx][tight][prev + 1][inc + 1][0] = ways;
            dp[idx][tight][prev + 1][inc + 1][1] = waviness;
            return dp[idx][tight][prev + 1][inc + 1];
        }
        
        int max = (tight == 1 ? s.charAt(idx) - '0' : 9);
        for (int i = 0; i <= max; i++) {
            int newTight = (tight == 1 && i == max) ? 1 : 0;
            
            if (i < prev) {
                long[] res = f(idx + 1, newTight, i, 0, s);
                ways += res[0];
                waviness += res[1];
                if (inc == 1) {
                    waviness += res[0];
                }
            } else if (i > prev) {
                long[] res = f(idx + 1, newTight, i, 1, s);
                ways += res[0];
                waviness += res[1];
                if (inc == 0) {
                    waviness += res[0];
                }
            } else {
                long[] res = f(idx + 1, newTight, i, -1, s);
                ways += res[0];
                waviness += res[1];
            }
        }
        
        dp[idx][tight][prev + 1][inc + 1][0] = ways;
        dp[idx][tight][prev + 1][inc + 1][1] = waviness;
        return dp[idx][tight][prev + 1][inc + 1];
    }

    void fillDp(long[][][][][] dp) {
        for (long[][][][] a : dp) {
            for (long[][][] b : a) {
                for (long[][] c : b) {
                    for (long[] d : c) {
                        Arrays.fill(d, -1);
                    }
                }
            }
        }
    }

    public long totalWaviness(long num1, long num2) {
        if (num1 == 0) num1 = 1; 

        String s = Long.toString(num1 - 1);
        String t = Long.toString(num2);
        
        dp = new long[t.length()][2][11][3][2];
        
        fillDp(dp);
        long v1 = f(0, 1, -1, -1, s)[1];
        
        fillDp(dp);
        long v2 = f(0, 1, -1, -1, t)[1];
        
        return v2 - v1;
    }
}