class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            need.merge(t.charAt(i), 1, Integer::sum);
        }

        int l = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;
        for(int r = 0; r < s.length(); r++){
            char key = s.charAt(r);
            have.merge(key, 1, Integer::sum);
            if(need.containsKey(key) && have.get(key) <= need.get(key)){
                count++;
            }

            while(count == t.length()){
                int currentLength = r - l + 1;
                if(currentLength < minLength){
                    minLength = currentLength;
                    start = l;            
                } 
                key = s.charAt(l);
                have.merge(key, -1, Integer::sum);
                if(need.containsKey(key) && have.get(key) < need.get(key)){
                    count--;
                }
                l++;
            }    
        }
        if(minLength > s.length()) return "";
        return s.substring(start, start+minLength);
    }
}
