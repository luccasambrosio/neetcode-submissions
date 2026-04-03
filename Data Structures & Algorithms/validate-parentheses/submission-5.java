class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Map<Character, Character> closeToOpen = Map.of(')', '(', '}', '{', ']', '[');
        Deque<Character> chars = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(closeToOpen.containsKey(c)){
                if(!chars.isEmpty() && chars.peek() == closeToOpen.get(c)){
                    chars.pop();
                }else{
                    return false;
                }
            }else{
                chars.push(c);
            }
        }
        return chars.isEmpty();
    }
}
