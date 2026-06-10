class SegTree{
    int [] min;
    int [] max;
    int [] arr;
    int n;
    SegTree(int [] arr){
        n = arr.length;
        this.arr = arr;
        max = new int[4*n];
        min = new int[4*n];
        build(0,0,n-1);
    }
    void build(int i,int l,int r){
        if(l == r){
            max[i] = arr[l];
            min[i] = arr[l];
            return;
        }
        int mid = (l+r)>>1;
        build(2*i+1,l,mid);
        build(2*i+2,mid+1,r);
        max[i] = Math.max(max[2*i+1],max[2*i+2]);
        min[i] = Math.min(min[2*i+1],min[2*i+2]);
    }

    int maxQuery(int l,int r){
        return maxQuery(0,0,n-1,l,r);
    }

    int maxQuery(int i,int l,int r,int ql,int qr){
        if(l>qr || r<ql) return -1;
        if(l>=ql && r<=qr) return max[i];
        int mid = (l+r)>>1;
        int left = maxQuery(2*i+1,l,mid,ql,qr);
        int right = maxQuery(2*i+2,mid+1,r,ql,qr);
        return Math.max(left,right);
    }

    int minQuery(int ql,int qr){
        return minQuery(0,0,n-1,ql,qr);
    }

    int minQuery(int i,int l,int r,int ql,int qr){
        if(l>qr || r<ql) return (int)(1e9)+1;
        if(l >= ql && r <= qr) return min[i];
        int mid = (l+r)>>1;
        int left = minQuery(2*i+1,l,mid,ql,qr);
        int right = minQuery(2*i+2,mid+1,r,ql,qr);
        return Math.min(left,right);
    }
}

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SegTree sg = new SegTree(nums);
        PriorityQueue<int []> q = new PriorityQueue<>((a,b)->{
            return b[0]-a[0];
        });
        for(int l = 0;l<n;l++){
            int max = sg.maxQuery(l,n-1);
            int min = sg.minQuery(l,n-1);
            q.add(new int[]{max-min,l,n-1});
        }
        long ans = 0;
        while(k > 0){
            int [] a = q.poll();
            ans += a[0];
            int l = a[1];
            int r = a[2];
            if(r-1 >= l){
                int max = sg.maxQuery(l,r-1);
                int min = sg.minQuery(l,r-1);
                q.add(new int[]{max-min,l,r-1});
            }
            k--;
        }
        return ans;
    }
}