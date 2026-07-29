class Solution {

    boolean pos(int i1,int j1,int i2,int j2){
        int sm = pref[i2][j2];
        if(i1 -1 >=0){
            sm -= pref[i1-1][j2];
        }
        if(j1 -1 >=0){
            sm -= pref[i2][j1-1];
        }
        if(i1-1 >=0 && j1-1>=0){
            sm += pref[i1-1][j1-1];
        }
        int area = (j2-j1+1)*(i2-i1+1);
        return (sm == area);
    }

    int [][] pref;
    int n,m;
    void build(char [][] matrix){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                int sm = (matrix[i][j]-'0');
                if(i-1 >=0){
                    sm += pref[i-1][j];
                }
                if(j-1 >=0){
                    sm += pref[i][j-1];
                }
                if(i-1 >=0 && j-1 >=0){
                    sm -= pref[i-1][j-1];
                }
                pref[i][j] = sm;
                // System.out.print(pref[i][j]+" ");
            }
            // System.out.println();
        }
    }

    public int maximalRectangle(char[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        pref = new int[n][m];
        build(matrix);
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j1 = 0;j1<m;j1++){
                for(int j2 = j1;j2<m;j2++){
                    if(pos(i,j1,i,j2)){
                        int st = 0;
                        int end = i-1;
                        int idx = i;
                        while(st <= end){
                            int mid = st+(end-st)/2;
                            if(pos(mid,j1,i,j2)){
                                idx = mid;
                                end = mid-1;
                            } else{
                                st = mid+1;
                            }
                        }
                        int area = (i-idx+1)*(j2-j1+1);
                        ans = Math.max(ans,area);
                    }
                }
            }
        }
        return ans;
    }
}