class Solution {
    static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n+1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int f = e[0], s = e[1];
            adj.get(f).add(s);
            adj.get(s).add(f);
        }

        boolean[] vis = new boolean[n+ 2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        vis[1] = true;

        int mxlvl = 0;

        while (!q.isEmpty()) {
            int[] a = q.poll();
            int node = a[0];
            int level = a[1];
            mxlvl = Math.max(mxlvl, level);

            for (int nei : adj.get(node)) {
                if (!vis[nei]) {
                    vis[nei] = true;
                    q.add(new int[]{nei, level + 1});
                }
            }
        }

        int power = Math.max(mxlvl - 1, 0); 
        return modPow(2, power, MOD);
    }

    private int modPow(int base, int exp, int mod) {
        long result = 1;
        long b = base;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }

        return (int) result;
    }
}
