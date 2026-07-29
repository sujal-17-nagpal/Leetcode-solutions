class Solution {

    ArrayList<ArrayList<Integer>> adj;
    ArrayList<ArrayList<Integer>> ulta;
    int [] dp;

    boolean [] vis;

    int dfs(int node,int par){
        int cnt = 0;
        for(int ele : adj.get(node)){
            if(vis[ele]) continue;
            vis[ele] = true;
            cnt += dfs(ele,node);
        }
        for(int ele : ulta.get(node)){
            if(vis[ele]) continue;
            vis[ele] = true;
            cnt += 1+dfs(ele,par);
        }
        return cnt;
    }

    void dfs2(int node,int par,int cnt){
        dp[node] = cnt;
        for(int ele : adj.get(node)){
            if(ele == par) continue;
            dfs2(ele,node,cnt+1);
        }
        for(int ele : ulta.get(node)){
            if(ele == par) continue;
            dfs2(ele,node,cnt-1);
        }
    }

    public int[] minEdgeReversals(int n, int[][] edges) {
        adj = new ArrayList<>();
        ulta = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
            ulta.add(new ArrayList<>());
        }
        for(int [] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            ulta.get(v).add(u);
        }
        vis = new boolean[n];
        vis[0] = true;
        dp = new int[n];
        int cnt  = dfs(0,-1);
        dfs2(0,-1,cnt);
        return dp;
    }
}