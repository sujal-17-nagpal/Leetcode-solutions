class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> l = new ArrayList<>();
        for(int st = 1;st<=8;st++){
            int num = st;
            int next = st+1;
            while(num <= high){
                num = num*10+next;
                next++;
                if(num >= low && num <= high) l.add(num);
                if(next == 10) break;
            }
        }
        Collections.sort(l);
        return l;
    }
}