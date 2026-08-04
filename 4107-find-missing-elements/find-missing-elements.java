class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        TreeSet<Integer> st = new TreeSet<>();
        for(int i = 0;i<n;i++){
            st.add(nums[i]);
        }
        int mn = st.first();
        int mx = st.last();
        List<Integer> l = new ArrayList<>();
        for(int i = mn;i<=mx;i++){
            if(!st.contains(i)){
                l.add(i);
            }
        }
        return l;
    }
}