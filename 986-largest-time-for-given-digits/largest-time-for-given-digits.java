class Solution {

    boolean greater(String s1,String s2){
        if(s2.length() == 0) return true;
        for(int i =0;i<s1.length();i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 > c2) return true;
            if(c2 > c1) return false;
        }
        return false;
    }

    void f(int idx,int [] freq,String s){
        if(idx == 4){
            if(greater(s,ans)){
                ans = s;
            }
            return;
        }
        int tight = 9;
        if(idx == 0){
            tight = 2;
        } else if(idx == 1){
            if(s.charAt(0) == '2'){
                tight = 3;
            } 
        } else if(idx == 2){
            tight = 5;
        }
        for(int i = tight;i>=0;i--){
            if(freq[i]>0){
                freq[i]--;
                f(idx+1,freq,s+i);
                freq[i]++;
            }
        }
    }

    String ans;
    int [] freq;

    public String largestTimeFromDigits(int[] arr) {
        ans = "";
        freq = new int[10];
        for(int a : arr){
            freq[a]++;
        }
        f(0,freq,"");
        if(ans.length() == 0) return ans;
        return ans.substring(0,2)+":"+ans.substring(2);
    }
}