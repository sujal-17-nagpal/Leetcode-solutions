class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int mx = 0;
        for(int i = 0;i<n;i++){
            while(left < i && nums[i]-nums[left] > 2*k){
                left++;
            }
            mx = Math.max(mx,i-left+1);
        }
        return mx;
    }
}