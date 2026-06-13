class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            String s = words[i];
            int sm = 0;
            for(int j = 0;j<s.length();j++){
                char ch = s.charAt(j);
                sm = (sm+weights[ch-'a'])%26;
            }
            sm = 25-sm;
            sb.append((char)(97+sm));
        }
        return sb.toString();
    }
}