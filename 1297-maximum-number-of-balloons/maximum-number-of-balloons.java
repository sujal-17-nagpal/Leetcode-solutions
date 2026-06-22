class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        int [] freq = new int[5];
        for(int i = 0;i<n;i++){
            char ch = text.charAt(i);
            if(ch == 'b') freq[0]++;
            else if(ch == 'a') freq[1]++;
            else if(ch == 'n') freq[2]++;
            else if(ch == 'o') freq[3]++;
            else if(ch == 'l') freq[4]++;
        }
        int mn = Integer.MAX_VALUE;
        for(int i = 0;i<5;i++){
            if(i>=3){
                mn = Math.min(mn,freq[i]/2);
            } else{
                mn = Math.min(mn,freq[i]);
            }
        }
        return mn;
    }
}