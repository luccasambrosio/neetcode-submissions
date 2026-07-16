class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        int n = s.length();
        int[] s1 = new int[26];
        int[] s2 = new int[26];

        for(int i = 0; i < n; i++){
            s1[s.charAt(i) - 'a']++;
            s2[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(s1, s2);
    }
}
