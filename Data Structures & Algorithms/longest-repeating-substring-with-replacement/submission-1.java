class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;
        int l = 0;
        int maxF = 0;
        for(int r = 0; r < s.length(); r++){
            count.merge(s.charAt(r), 1, Integer::sum);
            maxF = Math.max(maxF, count.get(s.charAt(r)));
            while(r - l+1 - maxF > k){
                count.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }
            res = Math.max(res, r-l+1);
        }

        return res;
    }
}
