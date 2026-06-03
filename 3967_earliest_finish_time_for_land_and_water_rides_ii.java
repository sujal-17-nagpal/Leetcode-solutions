class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int mnEnd = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            int st = landStartTime[i];
            int dur = landDuration[i];
            int end = st+dur;
            mnEnd = Math.min(mnEnd,st+dur);
        }
        int m = waterStartTime.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<m;i++){
            int st = Math.max(mnEnd,waterStartTime[i]);
            int dur = waterDuration[i];
            ans = Math.min(ans,st+dur);
        }
        mnEnd = Integer.MAX_VALUE;
        for(int i = 0;i<m;i++){
            int st = waterStartTime[i];
            int dur = waterDuration[i];
            int end = st+dur;
            mnEnd = Math.min(mnEnd,st+dur);
        }
        for(int i = 0;i<n;i++){
            int st = Math.max(mnEnd,landStartTime[i]);
            int dur = landDuration[i];
            ans = Math.min(ans,st+dur);
        }
        return ans;
    }
}