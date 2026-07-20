class Solution {

    void print(int [][] arr){
        int n = arr.length;
        int m = arr[0].length;
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] ans = new int[n][m];
        while(k-- > 0){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(j == 0){
                        ans[i][j] = grid[(i-1+n)%n][m-1];
                    } else{
                        ans[i][j] = grid[i][j-1];
                    }
                }
            }
            // print(ans);
            for(int i = 0;i<n;i++){
                for(int j =0;j<m;j++){
                    grid[i][j] = ans[i][j];
                }
            }
        }
        List<List<Integer>> l = new ArrayList<>();
        for(int i =0;i<n;i++){
            List<Integer> ll = new ArrayList<>();
            for(int j = 0;j<m;j++){
                ll.add(grid[i][j]);
            }
            l.add(ll);
        }
        return l;
    }
}