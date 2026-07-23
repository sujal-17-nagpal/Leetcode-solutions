class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        int n = a.length();
        int st;
        int end;
        if(n%2 == 1){
            st = n/2;
            end = st;
        } else{
            st = (n/2)-1;
            end = st+1;
        }
        while(st >= 0 && end < n && a.charAt(st) == a.charAt(end)){
            st--;
            end++;
        }
        int j = n-1;
        boolean ans1 = true;
        for(int i = 0;i<=st;i++){
            if(a.charAt(i) != b.charAt(j)){
                ans1 = false;
                break;
            }
            j--;
        }
        if(ans1) return true;

        j = 0;
        boolean ans3 = true;
        for(int i = n-1;i>=end;i--){
            if(a.charAt(i) != b.charAt(j)){
                ans3 = false;
                break;
            }
            j++;
        }
        if(ans3) return true;

        if(n%2 == 1){
            st = n/2;
            end = st;
        } else{
            st = (n/2)-1;
            end = st+1;
        }
        while(st >= 0 && end < n && b.charAt(st) == b.charAt(end)){
            st--;
            end++;
        }
        // System.out.println(st);
        j = n-1;
        boolean ans2 = true;
        for(int i = 0;i<=st;i++){
            if(b.charAt(i) != a.charAt(j)){
                ans2 = false;
                break;
            }
            j--;
        }
        if(ans2) return true;

        boolean ans4 = true;
        j = 0;
        for(int i = n-1;i>=end;i--){
            if(b.charAt(i) != a.charAt(j)){
                ans4 = false;
                break;
            }
            j++;
        }
        if(ans4) return true;
        return false;
    }
}