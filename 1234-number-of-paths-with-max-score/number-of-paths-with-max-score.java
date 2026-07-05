class Pair{
    long f;
    long s;
    Pair(long f,long s){
        this.f = f;
        this.s = s;
    }
}

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int m = board.get(0).length();
        Pair [][] dp = new Pair[n][m];
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                dp[i][j] = new Pair(-1,0);
            }
        }
        int min = -(int)(1e9);
        // f -> cost
        // s -> cnt
        dp[0][0].f = 0;
        dp[0][0].s = 1; 
        long mod = 1_000_000_007l;
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                char ch = board.get(i).charAt(j);
                long val = ch-'0';
                if(ch == 'S'){
                    val = 0;
                } else if(ch == 'X'){
                    dp[i][j].f = min;
                    continue;
                } 
                if(i-1 >=0 && j-1 >=0){
                    long newVal = dp[i-1][j-1].f + val;
                    if(newVal > dp[i][j].f){
                        dp[i][j].f = newVal;
                        dp[i][j].s = dp[i-1][j-1].s;
                    } else if(newVal == dp[i][j].f){
                        dp[i][j].s = (dp[i-1][j-1].s+dp[i][j].s)%mod;
                    }
                }
                if(j-1 >=0){
                    long newVal = dp[i][j-1].f+val;
                    if(newVal > dp[i][j].f){
                        dp[i][j].f = newVal;
                        dp[i][j].s = dp[i][j-1].s;
                    } else if(newVal == dp[i][j-1].f){
                        dp[i][j].s = (dp[i][j-1].s+dp[i][j].s)%mod;
                    }
                }
                if(i-1 >=0){
                    long newVal = dp[i-1][j].f + val;
                    if(newVal > dp[i][j].f){
                        dp[i][j].f = newVal;
                        dp[i][j].s = dp[i-1][j].s;
                    } else if(newVal == dp[i][j].f){
                        dp[i][j].s = (dp[i-1][j].s+dp[i][j].s)%mod;
                    }
                }
            }
        }
        
        int v1 = (int)(dp[n-1][m-1].f%mod);
        int v2 = (int)((dp[n-1][m-1].s)%mod);
        if(v1 == -1){
            v1 = 0;
            v2 = 0;
        }
        return new int[]{v1,v2};
    }
}