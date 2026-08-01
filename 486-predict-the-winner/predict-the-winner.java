class Solution {

    int [] nums;

    int f(int i,int j,int turn,int score){
        if(i>j){
            return (score >= 0 ? 1 : 0);
        }
        int nt = 1-turn;
        if(turn == 1){
            return f(i+1,j,nt,score+nums[i])|f(i,j-1,nt,score+nums[j]);
        }
        return f(i+1,j,nt,score-nums[i]) & f(i,j-1,nt,score-nums[j]);
    }

    public boolean predictTheWinner(int[] nums) {
        this.nums = nums;
        int ans = f(0,nums.length-1,1,0);
        return (ans == 1 ? true : false);
    }
}