class Solution {

    boolean [] pure;
    ArrayList<ArrayList<Integer>> adj;

    void dfs(int node){
        for(int ele : adj.get(node)){
            if(pure[ele]){
                pure[ele] = false;
                dfs(ele);
            }
        }
    }

    void dfs2(int node){
        for(int ele : adj.get(node)){
            if(!pure[ele]){
                pure[ele] = true;
                dfs2(ele); 
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] i : invocations){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
        }
        pure = new boolean[n];
        Arrays.fill(pure,true);
        pure[k] = false;
        dfs(k);
        boolean saare = false;
        for(int i = 0;i<n;i++){
            if(pure[i]){
                for(int ele : adj.get(i)){
                    if(!pure[ele]){
                        saare = true;
                        break;
                    }
                }
            }
        }
        List<Integer> l = new ArrayList<>();
        if(saare){
            for(int i = 0;i<n;i++) l.add(i);
            return l;
        }
        for(int i = 0;i<n;i++){
            if(pure[i]) l.add(i);
        }
        return l;
    }
}