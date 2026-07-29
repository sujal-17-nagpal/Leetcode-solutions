class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int a : nums){
            mp.put(a,mp.getOrDefault(a,0)+1);
        }
        PriorityQueue<int []> q = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int e : mp.keySet()){
            q.add(new int[]{e,mp.get(e)});
        }
        int [] ans = new int[k];
        for(int i = 0;i<k;i++){
            ans[i] = q.poll()[0];
        }
        return ans;
    }
}