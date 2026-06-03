class Solution {
public:
    long long f ( int i , unordered_map < int , long long > &mpp , vector <int> &arr , vector <int> &dp) {
       if ( i >= arr.size() ) return 0;
       if ( dp[i] != -1 ) return dp[i];
       long long notTake = f ( i + 1 , mpp , arr , dp );
       long long value = arr[i] * mpp [ arr[i] ];
       auto it  = lower_bound ( arr.begin() , arr.end() , arr[i] + 3);
       int nextIndexAtWhichWeJump = distance (arr.begin() , it );
        long long take = value + f ( nextIndexAtWhichWeJump , mpp , arr , dp);
       return dp[i] = max (notTake , take );
    }
    long long maximumTotalDamage(vector<int>& power) {
       unordered_map < int , long long > mpp;
       for ( int p : power ) {
           mpp [p]++;
       }
       vector <int> arr;
       for ( auto &it : mpp ) {
        arr.push_back ( it.first);
       }
       sort ( arr.begin() , arr.end());
       int n = power.size();
       vector <int> dp ( n + 1 , -1 );
       return f ( 0 , mpp , arr , dp );
    }
};