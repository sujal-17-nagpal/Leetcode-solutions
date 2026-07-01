class Solution {

    int [][] dir = {{-1,0},{+1,0},{0,-1},{0,+1}};

    int find(int i,int j){
        return dp[i][j];
    }

    int [][] dp;
    void precompute(List<List<Integer>> grid){
        int n = grid.size();
        dp = new int[n][n];
        for(int [] a : dp) Arrays.fill(a,-1);
        Queue<int []> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(grid.get(i).get(j) == 1){
                    q.add(new int[]{i,j,0});
                    dp[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            int [] a = q.poll();
            int i = a[0];
            int j = a[1];
            int dis = a[2];
            for(int k = 0;k<4;k++){
                int x = i+dir[k][0];
                int y = j+dir[k][1];
                if(x>=0 && y>=0 && x<n && y<n && dp[x][y] == -1){
                    dp[x][y] = dis+1;
                    q.add(new int[]{x,y,dis+1});
                }
            }
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        precompute(grid);
        
        PriorityQueue<int []> q = new PriorityQueue<>((a,b)->{
            return b[2]-a[2];
        });
        int init = find(0,0);
        q.add(new int[]{0,0,init});
        int [][] dis = new int[n][n];
        for(int [] a : dis){
            Arrays.fill(a,-1);
        }
        dis[0][0] = init;
        
        while(!q.isEmpty()){
            int [] a = q.poll();
            int i = a[0];
            int j = a[1];
            int safe = a[2];
            if(i == n-1 && j == n-1) return safe;
            for(int k = 0;k<4;k++){
                int newi = i+dir[k][0];
                int newj = j+dir[k][1];
                if(newi >=0 && newj>=0 && newi<n && newj<n){
                    int newSafe = Math.min(safe,find(newi,newj));
                    if(newSafe > dis[newi][newj]){
                        dis[newi][newj] = newSafe;
                        q.add(new int[]{newi,newj,newSafe});
                    }
                }
            }
        }
        return -1;
    }
}