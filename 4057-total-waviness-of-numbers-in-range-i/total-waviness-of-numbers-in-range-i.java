class Solution {
    public int totalWaviness(int num1, int num2) {
        int cnt =0;
        for(int i =num1;i<=num2;i++){
            String s = Integer.toString(i);
            
            if(s.length()<3) continue;
            for(int j = 1;j<s.length()-1;j++){
                if((s.charAt(j)-'0')>(s.charAt(j-1)-'0') && (s.charAt(j)-'0')>(s.charAt(j+1)-'0')) {
                    cnt++;
                }

                else if((s.charAt(j)-'0')<(s.charAt(j-1)-'0') && (s.charAt(j)-'0')<(s.charAt(j+1)-'0')) {
                    cnt++;
                }
            }
           
        }
        return cnt;
    }
}