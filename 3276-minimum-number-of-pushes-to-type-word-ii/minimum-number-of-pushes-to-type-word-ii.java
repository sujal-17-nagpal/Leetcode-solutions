class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int [] arr = new int[26];
        for(int i =0;i<n;i++){
            int ch = word.charAt(i)-'a';
            arr[ch]++;
        }
        int ans = 0;
        int val = 1;
        int cnt = 8;
        Arrays.sort(arr);
        for(int i = 25;i>=0;i--){
            if(arr[i] == 0) break;
            ans += arr[i]*val;
            cnt--;
            if(cnt == 0) {
                val++;
                cnt = 8;
            }
        }
        return ans;
    }
}