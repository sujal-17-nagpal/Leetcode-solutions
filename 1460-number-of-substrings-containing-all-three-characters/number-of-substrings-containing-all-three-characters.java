class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int [][] suff = new int[n][3];
        for(int [] a : suff){
            Arrays.fill(a,n);
        }
        for(int i = n-1;i>=0;i--){
            if(i!=n-1){
                for(int j = 0;j<3;j++){
                    suff[i][j] = suff[i+1][j];
                }
            }
            suff[i][s.charAt(i)-'a'] = i;
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            int end = Math.max(suff[i][0],Math.max(suff[i][1],suff[i][2]));
            ans += (n-end);
        }
        return ans;
    }
}