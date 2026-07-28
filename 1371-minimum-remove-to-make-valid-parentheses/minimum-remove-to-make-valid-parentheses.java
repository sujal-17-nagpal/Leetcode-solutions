class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        int cnt = 0;
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        int total = 0;
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                cnt++;
                total++;
            } else if(ch == ')') {
                cnt--;
                if(cnt<0) cnt = 0;
            }
        }
        int extra = cnt;
        cnt = 0;
        int talkable = total-extra; 
        // System.out.println(talkable);
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(talkable>0){
                    sb.append(ch);
                    talkable--;
                    cnt++;
                }
            } else if(ch == ')'){
                cnt--;
                if(cnt < 0){
                    cnt = 0;
                } else{
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}