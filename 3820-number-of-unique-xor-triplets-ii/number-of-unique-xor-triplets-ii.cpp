class Solution {
public:
    int uniqueXorTriplets(vector<int>& nums) {
        unordered_set<int> s;
        if(nums.size() == 1 ) return 1;
        for (int a = 0; a < nums.size(); a++) {
            for (int b = a+1; b < nums.size(); b++) {
                int xo = nums[a] ^ nums[b];
                s.insert(xo);
            }
        }
        bool arr[2048] = {};
        for (auto i : s) {
            for (int a = 0; a < nums.size(); a++) {
                int xo = i ^ nums[a];
                arr[xo] = true;
            }
        }
        int cnt = 0;
        for(int i = 0;i<2048;i++){
            if(arr[i]) cnt++;
        }
        return cnt;
            
    }
};