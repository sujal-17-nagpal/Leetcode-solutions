class Solution {

    HashMap<Integer,Integer> compute(int n){
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 2;i*i<=n;i++){
            int cnt = 0;
            while(n>1 && n%i == 0){
                cnt++;
                n /= i;
            }
            if(cnt >= 1) mp.put(i,cnt);
        }
        if(n>1) mp.put(n,1);
        mp.put(1,1);
        return mp;
    }

    ArrayList<Integer> compute2(int n){
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = 1;i*i<=n;i++){
            if(n%i == 0){
                l.add(i);
                if(n != i*i){
                    l.add(n/i);
                }
            }
        }
        return l;
    }

    public int comp(HashMap<Integer,Integer> chotta,HashMap<Integer,Integer> bada){
        int req = 1;
        for(int k : bada.keySet()){
            int need = bada.get(k);
            if(chotta.containsKey(k)){
                need -= chotta.get(k);
            }
            for(int i = 1;i<=need;i++){
                req *= k;
            }
        }
        return req;
    }

    public long countPairs(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> org = compute(k);
        HashMap<Integer,Integer> freq = new HashMap<>();
        
        long ans = 0;
        for(int i = 0;i<n;i++){

            int ele = nums[i];
            HashMap<Integer,Integer> inner = compute(ele);
            // System.out.println(inner);
        
            int req = comp(inner,org);
            
            if(freq.containsKey(req)) ans += freq.get(req);
            // System.out.println(i+" "+ans);

            ArrayList<Integer> st = compute2(ele);
            for(int key : st){
                freq.put(key,freq.getOrDefault(key,0)+1);
            }
        }
        return ans;
    }
}