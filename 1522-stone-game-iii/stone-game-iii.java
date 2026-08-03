class Solution {

    long min = -(int)(1e9);
    long max = (int)(1e9);

    int n;
    int [] arr;

    long [][] dp;

    long f(int idx,int turn){
        if(idx == n){
            // System.out.println("r");
            return 0;
        }
        if(dp[idx][turn] != -1) return dp[idx][turn];
        long val;
        if(turn == 0){
            // alice;
            long mx = min;
            long sm = 0;
            for(int i = idx;i<=Math.min(n-1,idx+2);i++){
                sm += arr[i];
                mx = Math.max(mx,sm+f(i+1,1));
            }
            val = mx;
        } else{
            // bob
            long mn = max;
            long sm = 0;
            for(int i = idx;i<=Math.min(n-1,idx+2);i++){
                sm += arr[i];
                mn = Math.min(mn,-sm+f(i+1,0));
            }
            val = mn;
        }
        // System.out.println(idx+" "+turn+" "+val);
        return dp[idx][turn] = val;
    }

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        arr = stoneValue;
        dp = new long[n][2];
        for(long [] a : dp) Arrays.fill(a,-1);
        long ans = f(0,0);
        // for(int i =0;i<n;i++) System.out.println(arr[i]);
        if(ans > 0) return "Alice";
        if(ans < 0) return "Bob";
        return "Tie";
    }
}