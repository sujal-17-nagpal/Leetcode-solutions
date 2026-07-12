class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int a : arr){
            q.add(a);
        }
        int prev = Integer.MAX_VALUE;
        int rank = 1;
        while(!q.isEmpty()){
            int e = q.poll();
            if(e == prev){
                continue;
            } else{
                mp.put(e,rank);
                rank++;
                prev = e;
            }
        }
        for(int i = 0;i<n;i++){
            arr[i] = mp.get(arr[i]);
        }
        return arr;
    }
}