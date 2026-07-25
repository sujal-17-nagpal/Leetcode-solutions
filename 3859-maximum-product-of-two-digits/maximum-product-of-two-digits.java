class Solution {
    public int maxProduct(int n) {
        int [] freq = new int[10];
        while(n>0){
            freq[n%10]++;
            n/=10;
        }
        int ans = 1;
        int cnt = 2;
        for(int i = 9;i>=0;i--){
            if(freq[i]>1){
                ans = ans*i;
                cnt--;
                if(cnt == 0) return ans;
                return ans*i;
            } 
            if(freq[i] == 1){
                ans = ans*i;
                cnt--;
                if(cnt == 0) return ans;
            }
        }
        return ans;
    }
}