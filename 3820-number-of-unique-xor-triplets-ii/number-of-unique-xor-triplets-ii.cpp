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
        unordered_set<int> s1;
        for (auto i : s) {
            for (int a = 0; a < nums.size(); a++) {
                int xo = i ^ nums[a];
                s1.insert(xo);
            }
        }
        return s1.size();
            
    }
};