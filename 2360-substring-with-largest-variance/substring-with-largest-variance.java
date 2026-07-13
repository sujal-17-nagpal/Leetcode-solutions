class Solution {
    public int largestVariance(String s) {
        int n = s.length();
        int mx = 0;
        for(int a = 0;a<26;a++){
            for(int b = 0;b<26;b++){
                if(a == b) continue;
                int sm = 0;
                boolean mila = false;
                for(int i = 0;i<n;i++){
                    int treat = 0;
                    if(s.charAt(i)-'a' == a) treat = 1;
                    if(s.charAt(i)-'a' == b) {
                        treat = -1;
                        mila = true;
                    }
                    sm += treat;
                    if(mila) mx = Math.max(mx,sm);
                    if(sm < 0) {
                        sm = 0;
                        mila = false;
                    }
                }
                sm = 0;
                mila = false;
                for(int i = n-1;i>=0;i--){
                    int treat = 0;
                    if(s.charAt(i)-'a' == a) treat = 1;
                    if(s.charAt(i)-'a' == b) {
                        treat = -1;
                        mila = true;
                    }
                    sm += treat;
                    if(mila) mx = Math.max(mx,sm);
                    if(sm < 0) {
                        sm = 0;
                        mila = false;
                    }
                }
            }
        }
        return mx;
    }
}