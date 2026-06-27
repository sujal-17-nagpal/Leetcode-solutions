class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int a : nums){
            mp.put(a,mp.getOrDefault(a,0)+1);
        }
        Arrays.sort(nums);
        HashMap<Long,Long> dp = new HashMap<>();
        long mx = 1;
        for(int i = n-1;i>=0;i--){
            if(nums[i] == 1){
                int v = mp.get(1);
                if(v%2 == 0) v--;
                mx = Math.max(mx,v);
                break;
            }
            long req = 1l*nums[i]*nums[i];
            long v = 1;
            if(dp.containsKey(req)){
                if(mp.get(nums[i]) >= 2){
                    v = 2+dp.get(req);
                }
            }
            dp.put((long)nums[i],v);
            mx = Math.max(mx,v);
        }
        return (int)mx;
    }
}