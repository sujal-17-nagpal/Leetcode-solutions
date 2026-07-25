class Solution {

    int findIn(int a,int b,int [] l){
        int n = l.length;
        int st = 0;
        int end = n-1;
        int left = -1;
        while(st <= end){
            int mid = (st)+(end-st)/2;
            if(l[mid] >=a){
                left = mid;
                end = mid-1;
            } else{
                st = mid+1;
            }
        }

        st = 0;
        end = n-1;
        int right = -1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(l[mid]<=b){
                right = mid;
                st = mid+1;
            } else{
                end = mid-1;
            }
        }
        return right-left+1;
    }

    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        HashSet<Integer> set = new HashSet<>();
        for(int a : stones){
            set.add(a);
        }
        int n = stones.length;
        int [] ans = new int[2];
        int gapSm = 0;
        for(int i = 0;i<n-1;i++){
            gapSm += stones[i+1]-stones[i]-1;
        }
        int gap1 = stones[1]-stones[0]-1;
        int gap2 = stones[n-1]-stones[n-2]-1;
        ans[1] = Math.max(gapSm-gap1,gapSm-gap2);
        int minAns = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            int st = stones[i];
            int ele = findIn(st,st+n-1,stones);
            if(ele == n-1){
                if(set.contains(st) && set.contains(st+n-1)){
                    minAns = Math.min(minAns,1);
                } else{
                    minAns = Math.min(minAns,2);
                }
            } else{
                minAns = Math.min(minAns,n-ele);
            }
        }
        ans[0] = minAns;
        return ans;
    }
}