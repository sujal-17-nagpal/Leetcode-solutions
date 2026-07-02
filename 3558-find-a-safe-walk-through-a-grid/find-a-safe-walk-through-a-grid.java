class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        if(grid.get(0).get(0) == 1) health--;
        if(health == 0) return false;
        PriorityQueue<int []> q = new PriorityQueue<>((a,b)-> b[2]-a[2]);
        int [][] dis = new int[n][m];
        for(int [] a : dis){
            Arrays.fill(a,-1);
        }
        dis[0][0] = health;
        q.add(new int[]{0,0,health});
        int [][] dir = {{-1,0},{+1,0},{0,+1},{0,-1}};
        while(!q.isEmpty()){
            int [] a = q.poll();
            int i = a[0];
            int j = a[1];
            int h = a[2];
            // if(h == 0) continue;
            if(i == n-1 && j == m-1) return true;
            if(h < dis[i][j]) continue;
            for(int k = 0;k<4;k++){
                int x = i+dir[k][0];
                int y = j+dir[k][1];
                if(x >=0 && x<n && y>=0 && y<m){
                    int nh = (grid.get(x).get(y) == 1 ? h-1 : h);
                    // System.out.println(nh);
                    if(nh > dis[x][y] && nh > 0){
                        dis[x][y] = nh;
                        q.add(new int[]{x,y,nh});
                    }
                }
            }
            
        }
        return false;
    }
}