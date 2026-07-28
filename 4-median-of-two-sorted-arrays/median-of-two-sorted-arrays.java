class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int total = n+m;
        if(total == 1){
            if(n>0) return (double)nums1[0];
            return (double)nums2[0];
        }
        if(total == 2){
            if(n == 2) return (nums1[0]+nums1[1])/2.0;
            if(m == 2) return (nums2[0]+nums2[1])/2.0;
            if(n == 1) return (nums1[0]+nums2[0])/2.0;
        }
        int mid = (total-1)/2;
        int i =0;
        int j = 0;
        int idx = 0;
        int val = -1;
        while(i<n || j<m){
            int v1 = (i<n ? nums1[i] : Integer.MAX_VALUE);
            int v2 = (j<m ? nums2[j] : Integer.MAX_VALUE);
            if(v1<v2){
                i++;
                
                if(idx == mid){
                    val = v1;
                    break;
                }
                idx++;
            } else{
                j++;
                
                if(idx == mid){
                    val = v2;
                    break;
                }
                idx++;
            }
        }
        if(total%2 == 1) return (double)(val);
        int nv1 = (i<n ? nums1[i] : (int)(1e9));
        int nv2 = (j<m ? nums2[j] : (int)(1e9));
        double ans = (val + Math.min(nv1,nv2))/2.0;
        return ans;
    }
}