class Solution {

    int ans;
    ArrayList<ArrayList<int[]>> adj;
    boolean[] vis;

    void dfs(int node, int id, int mn) {
        ans = Math.min(ans, mn);

        if (id != -1) {
            vis[id] = true;
        }

        for (int[] e : adj.get(node)) {
            int nei = e[0];
            int wt = e[1];
            int edgeId = e[2];

            if (vis[edgeId]) {
                continue;
            }

            dfs(nei, edgeId, Math.min(mn, wt));
        }
    }

    public int minScore(int n, int[][] roads) {

        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int id = 0;

        for (int[] a : roads) {
            int u = a[0] - 1;
            int v = a[1] - 1;
            int d = a[2];

            adj.get(u).add(new int[]{v, d, id});
            adj.get(v).add(new int[]{u, d, id});

            id++;
        }

        vis = new boolean[id];
        ans = Integer.MAX_VALUE;

        dfs(0, -1, Integer.MAX_VALUE);

        return ans;
    }
}