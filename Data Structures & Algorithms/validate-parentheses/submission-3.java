class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        int l = 0, r = s.length() - 1;
        Map<Character, Character> closeToOpen = Map.of(')', '(', '}', '{', ']', '[');
        Stack<Character> chars = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(closeToOpen.containsValue(c)){
                chars.push(c);
            }else if(closeToOpen.containsKey(c)){
                if(!chars.isEmpty() && chars.peek() == closeToOpen.get(c)){
                    chars.pop();
                }else{
                    return false;
                }
            }
        }
        return chars.isEmpty();
    }
}
