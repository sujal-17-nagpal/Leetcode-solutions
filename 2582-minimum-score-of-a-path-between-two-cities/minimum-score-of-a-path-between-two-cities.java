class Solution {

    int ans;
    ArrayList<ArrayList<int[]>> adj;
    boolean[] vis;

    void dfs(int node, int mn) {

        vis[node] = true;
        for (int[] e : adj.get(node)) {
            int nei = e[0];
            int wt = e[1];
            ans = Math.min(ans,wt);
            if (vis[nei]) {
                continue;
            }

            dfs(nei, Math.min(mn, wt));
        }
    }

    public int minScore(int n, int[][] roads) {

        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] a : roads) {
            int u = a[0] - 1;
            int v = a[1] - 1;
            int d = a[2];

            adj.get(u).add(new int[]{v, d});
            adj.get(v).add(new int[]{u, d});

        }

        vis = new boolean[n];
        ans = Integer.MAX_VALUE;

        dfs(0, Integer.MAX_VALUE);

        return ans;
    }
}