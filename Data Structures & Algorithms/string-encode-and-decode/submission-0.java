class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String s : strs){
            result += s.length() + "#" + s;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j+1;
            j = i+length;
            String s = str.substring(i, j);
            strs.add(s);
            i = j;
        }

        return strs;
    }
}
