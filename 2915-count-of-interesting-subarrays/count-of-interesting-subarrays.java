class Solution {

    void print(int [] arr){
        for(int i  =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int [] pref = new int[n+1];
        int cnt = 0;
        pref[0] = 1;
        long ans = 0;
        for(int i= 0;i<n;i++){
            if(nums.get(i)%modulo == k) {
                if(cnt-modulo >=0){
                    pref[cnt] += pref[cnt-modulo];
                }
                cnt++;
            }
            if(k == 0){
                ans += pref[cnt];
                if(cnt-modulo >= 0){
                    ans += pref[cnt-modulo];
                }
            } else{
                if(cnt-k>=0) ans += pref[cnt-k];
            }
            System.out.println(i+" "+ans);
            pref[cnt]++;
        }
        return ans;
    }
}