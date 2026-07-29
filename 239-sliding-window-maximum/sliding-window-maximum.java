class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i =0;i<k-1;i++){
            int e = nums[i];
            mp.put(e,mp.getOrDefault(e,0)+1);
        }
        int [] ans = new int[n-k+1];
        int idx = 0;
        for(int i =k-1;i<n;i++){
            int e = nums[i];
            if(i-k>=0) {
                e = nums[i-k];
                mp.put(e,mp.get(e)-1);
                if(mp.get(e) == 0) mp.remove(e);
            }
            e = nums[i];
            mp.put(e,mp.getOrDefault(e,0)+1);
            ans[idx] = mp.lastKey();
            idx++;
            
        }
        return ans;
    }
}