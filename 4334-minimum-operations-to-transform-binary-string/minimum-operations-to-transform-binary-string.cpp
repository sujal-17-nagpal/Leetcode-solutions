class Solution {
public:
    int minOperations(string s1, string s2) {
        int n = s1.size();
        if(n == 1 && s1[0] == '1' && s2[0] == '0') return -1;
        int opr = 0;
        for(int i = 0;i<n;i++){
            if(s1[i] == s2[i]){
                continue;
            }
            if(s1[i] == '0'){
                opr++;
                s1[i] = 1;
                continue;
            }
            if(i+1 < n){
                if(s1[i+1] == s2[i+1]){
                    opr+=2;
                } else{
                    if(s1[i+1] == '1'){
                        opr++;
                    } else{
                        opr+=3;
                    }
                    s1[i+1] = s2[i+1];
                }
            } else{
                opr+=2;
            }
        }
        return opr;
    }
};