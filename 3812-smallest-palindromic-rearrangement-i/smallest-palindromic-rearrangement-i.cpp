class Solution {
public:
    string smallestPalindrome(string s) {
        int n = s.size();
        vector<int> freq(26);
        for(int i = 0;i<n;i++){
            char ch = s[i];
            freq[ch-'a']++;
        }
        string ans = "";
        for(int i= 0;i<n;i++){
            if(i<n/2){
                for(int j = 0;j<26;j++){
                if(freq[j]>=2){
                    ans += (char)('a'+j);
                    freq[j]-=2;
                    break;
                }
            }
            } else if(n%2 == 1 && i == (n/2)){
                for(int j = 0;j<26;j++){
                    if(freq[j]%2 == 1){
                        ans += (char)('a'+j);
                    break;
                    }
                }
            } else{
                int sym = n-i-1;
                // cout<<ans[sym]<<"\n";
                ans+= ans[sym];
            }
            
        }
        return ans;
    }
};