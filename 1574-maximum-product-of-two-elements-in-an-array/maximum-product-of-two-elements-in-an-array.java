class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int mx1=1;
        int mx2 = 1;
        for(int i = 0;i<n;i++){
            if(nums[i]>mx1){
                mx2 = mx1;
                mx1 = nums[i];
            } else if(nums[i] > mx2){
                mx2 = nums[i];
            }
        }
        return (mx1-1)*(mx2-1);
    }
}