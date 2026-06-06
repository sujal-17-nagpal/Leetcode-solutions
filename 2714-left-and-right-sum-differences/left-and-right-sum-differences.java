class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int rsm = 0;
        for(int a : nums){
            rsm += a;
        }
        int lsm = 0;
        int [] ans = new int[n];
        for(int i =0;i<n;i++){
            rsm -= nums[i];
            ans[i] = Math.abs(lsm-rsm);
            lsm += nums[i];
        }
        return ans;
    }
}