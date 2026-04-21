class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int fresh = 0, minutes = 0;
        Deque<int[]> rotten = new ArrayDeque<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    fresh++;
                } else if(grid[r][c] == 2){
                    rotten.add(new int[]{r, c});
                }
            }
        }

        while(!rotten.isEmpty() && fresh > 0){
            int size = rotten.size();
            for(int i = 0; i < size; i++){            
                int[] dirRotten = rotten.poll();
                for(int[] dir : directions){
                    int dr = dir[0] + dirRotten[0];
                    int dc = dir[1] + dirRotten[1];
                    if(dr < 0 || dr >= rows || dc < 0 || dc >= cols) continue;
                    if(grid[dr][dc] == 1){
                        grid[dr][dc] = 2;
                        fresh--;
                        rotten.add(new int[]{dr, dc});
                    }
                }
            }
            minutes++;
        }

        return (fresh == 0) ? minutes : -1;
    }
}
