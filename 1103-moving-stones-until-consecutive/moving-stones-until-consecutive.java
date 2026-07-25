class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int [] ans = new int[2];
        ArrayList<Integer> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        l.add(c);
        Collections.sort(l);
        int gaps = 0;
        int gap1 = l.get(1)-l.get(0)-1;
        if(gap1 > 0) gaps++;
        int gap2 = l.get(2)-l.get(1)-1;
        if(gap2 > 0) gaps++;
        if(gaps == 0){
            ans[0] = 0;
            ans[1] = 0;
        } else if(gaps == 1){
            ans[0] = 1;
            ans[1] = gap1+gap2;
        } else{
            if(gap1 == 1 || gap2 == 1){
                ans[0] = 1;
            } else{
                ans[0] = 2; 
            }
            ans[1] = gap1+gap2;
        }
        return ans;
    }
}