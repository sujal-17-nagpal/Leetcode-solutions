class Solution {

    int [][] dp,grid;
    int n,m;

    void print(int [][] dp){
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    int f(int i,int j){
        if(i == n-1 && j == m-1){
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(i+1 < n && grid[i+1][j] == 1){
            ans = ans | f(i+1,j);
        }
        if(j+1 < m && grid[i][j+1] == 1){
            ans = ans | f(i,j+1);
        }
        return dp[i][j] =  ans;
    }

    public boolean isPossibleToCutPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        if(n == 1 && m == 1) return false;
        if(n == 1){
            if(m == 2) return false;
        }
        if(m == 1){
            if(n == 2) return false;
        }
        this.grid = grid;
        dp = new int[n][m];
        for(int [] a : dp){
            Arrays.fill(a,-1);
        }
        f(0,0);
        dp[n-1][m-1] = 1;
        // print(dp);
        for(int i = 0;i<n;i++){
            int cnt = 0;
            for(int j =0;j<m;j++){
                if(dp[i][j] == 1) cnt++;
            }
            if(cnt <= 1) return true;
        }
        for(int j = 0;j<m;j++){
            int cnt = 0;
            for(int i =0;i<n;i++){
                if(dp[i][j] == 1) cnt++;
            }
            if(cnt <= 1) return true;
        }
        for(int jj = 1;jj<m;jj++){
            int i = 0;
            int j = jj;
            int cnt = 0;
            while(i<n && j>=0){
                if(dp[i][j] == 1){
                    cnt++;
                }
                i++;
                j--;
            }
            if(cnt <= 1) return true;
        }
        return false;
    }
}