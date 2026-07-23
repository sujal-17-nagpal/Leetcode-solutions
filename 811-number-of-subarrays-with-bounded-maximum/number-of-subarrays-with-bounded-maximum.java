class Solution {
    public int numSubarrayBoundedMax(int[] arr, int left, int right) {
        int n = arr.length;
        int [] prev = new int[n];
        Arrays.fill(prev,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                prev[st.pop()] = i;
            }
            st.push(i);
        }
        int [] next = new int[n];
        Arrays.fill(next,n);
        st.clear();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                next[st.pop()] = i;
            }
            st.push(i);
        }
        int ans = 0;
        for(int i =0;i<n;i++){
            if(arr[i] >= left && arr[i] <= right){
                int leftB = i-prev[i];
                int rightB = next[i]-i;
                int val = leftB*rightB;
                // System.out.println(i+" "+val);
                ans += val;
            }
        }
        return ans;
    }
}