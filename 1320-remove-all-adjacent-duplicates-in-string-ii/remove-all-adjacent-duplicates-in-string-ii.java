class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<int []> st = new Stack<>();
        int cnt = 0;
        int prev = s.charAt(0);
        for(int i = 0;i<n;i++){
            int ch = s.charAt(i)-'a';
            if(ch == prev){
                cnt++;
                if(cnt == k){
                    cnt = 0;
                }
            } else {
                if(cnt > 0){
                    st.push(new int[]{prev,cnt});
                }
                cnt = 1;
                prev = ch;
            }
            if(!st.isEmpty()){
                int [] a = st.peek();
                int c = a[0];
                if(c == ch){
                    if(cnt+a[1] == k){
                        st.pop();
                        cnt = 0;
                    } else{
                        st.pop();
                        int newCnt = cnt+a[1];
                        st.push(new int[]{c,newCnt});
                        cnt = 0;
                    }
                }
            }
        }
        if(cnt > 0){
            st.push(new int[]{prev,cnt});
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            int [] e = st.pop();
            char ch = (char)('a'+e[0]);
            cnt = e[1];
            for(int i =0;i<cnt;i++){
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
}