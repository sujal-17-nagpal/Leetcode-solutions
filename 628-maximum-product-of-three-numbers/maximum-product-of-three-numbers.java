class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mx = nums[n-1]*nums[n-2]*nums[n-3];
        mx = Math.max(mx,nums[0]*nums[1]*nums[n-1]);
        return mx;
    }
}