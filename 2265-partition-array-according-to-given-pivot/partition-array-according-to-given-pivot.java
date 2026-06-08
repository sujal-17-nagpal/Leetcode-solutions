class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int idx = 0;
        int [] ans = new int[n];
        for(int i =0;i<n;i++){
            if(nums[i] < pivot){
                ans[idx] = nums[i];
                idx++;
            }
        }
        for(int i =0;i<n;i++){
            if(nums[i] == pivot){
                ans[idx] = nums[i];
                idx++;
            }
        }
        for(int i =0;i<n;i++){
            if(nums[i] > pivot){
                ans[idx] = nums[i];
                idx++;
            }
        }
        return ans;
    }
}