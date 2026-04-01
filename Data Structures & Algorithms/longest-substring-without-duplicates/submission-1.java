class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int l = 0, maxLength = 0;
        for(int r = 0; r < s.length(); r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }

            maxLength = Math.max(maxLength, r-l+1);
            set.add(s.charAt(r));
        }

        return maxLength;
    }
}
