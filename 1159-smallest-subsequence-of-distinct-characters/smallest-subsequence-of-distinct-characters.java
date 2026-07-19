class Solution {
    public String smallestSubsequence(String s) {
        int [] freq = new int[26];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        Stack<Character> st = new Stack<>();
        boolean [] vis = new boolean[26];
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            freq[ch-'a']--;
            if(vis[ch-'a'])continue;
            while(!st.isEmpty() && ch<st.peek() && !vis[ch-'a']){
                if(freq[st.peek()-'a'] > 0){
                    vis[st.pop()-'a'] = false;
                } else {
                    break;
                }
            }
            vis[ch-'a'] = true;
            st.push(ch);
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}