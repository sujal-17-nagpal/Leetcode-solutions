class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> l = new ArrayList<>();
        HashMap<String,ArrayList<String>> mp = new HashMap<>();
        for(int i =0;i<n;i++){
            String s = strs[i];
            char [] a = s.toCharArray();
            Arrays.sort(a);
            String sorted = new String(a);
            mp.putIfAbsent(sorted,new ArrayList<>());
            mp.get(sorted).add(s); 
        }
        for(List<String> ll : mp.values()){
            l.add(ll);
        }
        return l;
    }
}