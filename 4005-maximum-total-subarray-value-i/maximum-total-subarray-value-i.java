class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            mn = Math.min(mn,nums[i]);
            mx = Math.max(mx,nums[i]);
        }
        return (1l*k*(mx-mn));
    }
}