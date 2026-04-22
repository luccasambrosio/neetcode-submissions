class Solution {
    public int climbStairs(int n) {
        if(n <= 3) return n;

        int n2 = 2;
        int n1 = 3;

        int current = 0;

        for(int i = 4; i <= n; i++){
            current = n2 + n1;
            n2 = n1;
            n1 = current;
        }

        return current;
    }
}
