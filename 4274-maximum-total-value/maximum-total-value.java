class Solution {

    long pos(int [] arr,int [] decay,int m,long mid){
        int n = arr.length;
        long cnt =  0;
        long tsm  =0;
        int exactM = 0;
        for(int i = 0;i<n;i++){
            if(arr[i]<mid){
                continue;
            }
            long val = 1 + (arr[i]-mid)/decay[i];
            if((arr[i]-mid)%decay[i] == 0) exactM++;
            long last = arr[i]-(val-1)*decay[i];
            long sm = (arr[i]+last)*val/2;
            tsm += sm;
            cnt += val;
        }
        if(cnt > m){
            long remove = cnt-m;
            if(remove > exactM) return -1;
            return (tsm-remove*mid);
        }
        return tsm;
    }
    
    public int maxTotalValue(int[] value, int[] decay, int m) {
        int n = value.length;
        long st = 0;
        long end = (long)(1e9);
        long ans = -1;
        long mod = (long)(1e9)+7;
        while(st <= end){
            long mid = (st)+(end-st)/2;

            long cnt = 0;
            long p = pos(value,decay,m,mid);
            if(p != -1){
                ans = p;
                end = mid-1;
            } else{
                st = mid+1;
            }
        }
        return (int)(ans%mod);
    }
}