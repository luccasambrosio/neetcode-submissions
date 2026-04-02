class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            count.merge(s.charAt(r), 1, Integer::sum);

            while(r - l+1 - Collections.max(count.values()) > k){
                count.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }
            res = Math.max(res, r-l+1);
        }

        return res;
    }
}
