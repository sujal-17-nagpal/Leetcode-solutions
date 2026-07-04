class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] a : roads){
            int u = a[0];
            int v = a[1];
            int d = a[2];
            adj.get(u-1).add(new int[]{v-1,d});
            adj.get(v-1).add(new int[]{u-1,d});
        }
        PriorityQueue<int []> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int [] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        // dis[0] = 0;
        q.add(new int[]{0,Integer.MAX_VALUE});
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int [] a = q.poll();
            // System.out.println(a[0]+" "+a[1]);
            int node = a[0];
            int mn = a[1];
            
            // if(node == n-1) {
            //     ans = Math.min(ans,mn);
            //     continue;
            // }
            for(int [] e : adj.get(node)){
                int nei = e[0];
                int cost = e[1];
                int newMn = Math.min(mn,cost);
                if(newMn < dis[nei]){
                    dis[nei] = newMn;
                    q.add(new int[]{nei,newMn});
                }
            }
        }
        return dis[n-1];
    }
}