class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] sub = new int[26];
        int[] str = new int[26];

        for(int i = 0; i < s1.length(); i++){
            sub[s1.charAt(i) - 'a']++;
        }

        int l = 0;
        for(int r = 0; r < s2.length(); r++){
            str[s2.charAt(r) - 'a']++;

            if(r < s1.length() - 1) continue;

            if(Arrays.equals(str, sub)){
                return true;
            }else{
                str[s2.charAt(l) - 'a']--;
                l++;
            }
        }
        return false;
    }
}
