class Solution {

    long min = -(long)(1e18);

    long div(int a,int b){
        if(a >=0) return a/b;
        return -(Math.abs(a)/b);
    }

    long opr(int val,int opr,int k){
        if(opr == 0) return 1l*val*k;
        return div(val,k);
    }

    public long solve(int [] nums,int k,int o){
        int n = nums.length;
        long [] dp1 = new long[n];
        long [] dp2 = new long[n];
        long [] dp3 = new long[n];
        /*  
            dp1 -> not started
            dp2 -> running wle me
            dp3 -> ended
        */ 
        dp1[0] = nums[0];
        dp2[0] = opr(nums[0],o,k);
        dp3[0] = min;
        long mx = dp2[0];
        for(int i = 1;i<n;i++){
            long newVal = opr(nums[i],o,k);
            dp1[i] = Math.max(nums[i],dp1[i-1]+nums[i]);
            dp2[i] = Math.max(newVal,Math.max(dp1[i-1]+newVal,dp2[i-1]+newVal));
            dp3[i] = Math.max(dp2[i],Math.max(dp2[i-1]+nums[i],dp3[i-1]+nums[i]));
            mx = Math.max(mx,dp3[i]);
        }
        return mx;
    }

    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        return Math.max(solve(nums,k,0),solve(nums,k,1));
    }
}