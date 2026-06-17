class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long l = 0;
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                l++;
            } else if(ch == '*'){
                l = Math.max(0,l-1);
            } else if(ch == '#'){
                l *= 2;
            } 
        }
        if(k >= l) return '.';
        for(int i = n-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch == '*'){
                l++;
            } else if(ch == '#'){
                l = l/2;
                if(k >= l) k -= l;
            } else if(ch == '%'){
                k = l-1-k;
            } else {
                l--;
            }
            if(l == k) return s.charAt(i);
        }
        return '.';
    }
}