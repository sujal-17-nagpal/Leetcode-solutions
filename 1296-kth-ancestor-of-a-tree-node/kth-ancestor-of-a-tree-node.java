class TreeAncestor {

    int [][] dp;
    int [] parent;

    public int f(int node,int pow){
        if(pow == 0){
            return parent[node];
        }
        if(dp[node][pow] != -1) return dp[node][pow];
        int halfWay = f(node,pow-1);
        if(halfWay == -1) return dp[node][pow] = -1;
        int anc = f(halfWay,pow-1);
        return dp[node][pow] = anc;
    }

    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        dp = new int[n][30];
        for(int [] a : dp){
            Arrays.fill(a,-1);
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int anc = node;
        for(int i = 0;i<30;i++){
            int bit = 1<<i;
            if((k&bit) != 0){
                int newAnc = f(anc,i);
                if(newAnc == -1) return -1;
                anc = newAnc;
            }
        }
        return anc;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */