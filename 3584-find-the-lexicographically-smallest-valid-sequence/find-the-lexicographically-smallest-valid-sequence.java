class Solution {

    void print(int [] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [] dp = new int[n];
        dp[n-1] = m;
        int idx = m-1;
        for(int i = n-1;i>=0;i--){
            if(i!=n-1) dp[i] = dp[i+1];
            if(idx>=0 && word1.charAt(i) == word2.charAt(idx)){
                dp[i] = idx;
                idx--;
            }
        }
        // print(dp);
        // if(dp[0] > 1) return new int[0];
        int [] ans = new int[m];
        idx = 0;
        boolean hogya = false;
        for(int i = 0;i<n;i++){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(idx);
            if(c1 == c2){
                ans[idx] = i;
                idx++;
            } else {
                if(hogya) continue;
                int matched = idx-1;
                if(i == n-1){
                    if(idx!=m-1) return new int[0];
                    ans[idx] = i;
                    return ans;
                } else{
                    int aage = dp[i+1];
                    if(aage-matched <= 2){
                        ans[idx] = i;
                        idx++;
                        hogya = true;
                    }
                }
            }
            if(idx == m){
                return ans;
            }
        }
        if(idx < m) return new int[0];
        return ans;
    }
}