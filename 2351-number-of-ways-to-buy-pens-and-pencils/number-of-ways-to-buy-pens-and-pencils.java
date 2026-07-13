class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long cnt = 0;
        for(int i = 0;cost1*i<=total;i++){
            int rem = total-cost1*i;
            cnt += 1+(rem/cost2);
        }
        return cnt;
    }
}