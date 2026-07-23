class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int maxSet = 0;
        for(int i = 0;i<32;i++){
            int bit = (1<<i);
            if((n&bit) != 0){
                maxSet = i;
            }
        }
        return (1<<(maxSet+1));
    }
}