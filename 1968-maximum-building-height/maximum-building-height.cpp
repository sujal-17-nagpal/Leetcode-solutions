class Solution {
public:

    void print(vector<vector<int>> &arr){
        int n = arr.size();
        for(int i =0;i<n;i++){
            cout<<arr[i][0]<<" "<<arr[i][1]<<"\n";
        }
    }

    int maxBuilding(int n, vector<vector<int>>& restrictions) {

        restrictions.push_back({1, 0});

        sort(restrictions.begin(), restrictions.end(),
             [](vector<int>& a, vector<int>& b) {
                 return a[0] < b[0];
             });

        int m = restrictions.size();

        for(int i = 1;i<m;i++){
            restrictions[i][1] = min(restrictions[i][1],restrictions[i][0]-restrictions[i-1][0]+restrictions[i-1][1]);
        }
        for(int i = m-2;i>=0;i--){
            restrictions[i][1] = min(restrictions[i][1],restrictions[i+1][0]-restrictions[i][0]+restrictions[i+1][1]);
        }

        // print(restrictions);

        int globalMax =
            (n - restrictions[m - 1][0]) + restrictions[m - 1][1];
        // cout<<globalMax;
        for (int i = 1; i < m; i++) {

            int u = restrictions[i][1];
            int v = restrictions[i - 1][1];

            int mx = max(u, v);

            int diff = abs(u - v);

            int dis = restrictions[i][0] - restrictions[i - 1][0] - 1;

            dis -= diff;

            globalMax = max(globalMax, mx);

            int val = (dis + 1) / 2;

            globalMax = max(globalMax, val + mx);
        }

        return globalMax;
    }
};