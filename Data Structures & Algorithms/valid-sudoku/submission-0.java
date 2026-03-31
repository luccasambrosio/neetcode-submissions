class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i = 0; i < 9; i++){
            cols[i] = new HashSet<>();
            rows[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char c = board[row][col];
                int boxIndex = (row/3) * 3 + (col/3);
                if(c == '.') continue;
                if(!cols[col].add(c) || !rows[row].add(c) || !boxes[boxIndex].add(c)){
                    return false;
                }
            }
        }
        return true;
    }
}
