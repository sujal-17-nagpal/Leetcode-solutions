class Solution {

    ArrayList<ArrayList<int []>> adj;
    int n;
    long k;

    public boolean pos(int mid){
        PriorityQueue<long []> q = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        q.add(new long[]{0,0});
        // node , cost
        long [] dis = new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0] = 0;
        while(!q.isEmpty()){
            long [] a = q.poll();
            int node = (int)a[0];
            long cost = a[1];
            
            if(node == n-1) return true;
            if(cost > dis[node]) continue;
            for(int [] e : adj.get(node)){
                int nei = e[0];
                int wt = e[1];
                if(wt < mid) break;
                long newCost = cost+wt;
                if(newCost <= k && newCost < dis[nei]){
                    q.add(new long[]{nei,newCost});
                    dis[nei] = newCost;
                }
            }
        }
        return false;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n = online.length;
        adj = new ArrayList<>();
        this.k = k;
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            if(!online[u] || !online[v]) continue;
            adj.get(u).add(new int[]{v,w});
        }
        for(ArrayList<int []> l : adj){
            Collections.sort(l,(a,b)-> b[1]-a[1]);
        }
        int st = 0;
        int end = (int)(1e9);
        int ans = -1;
        while(st <= end){
            int mid = (st)+(end-st)/2;
            if(pos(mid)){
                ans = mid;
                st = mid+1;
            } else{
                end = mid-1;
            }
        }
        return ans;
    }
}