class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int l = 0;
        int r = matrix.length - 1;
        
        while(l <= r){
            int mid = l + (r-l) / 2;
            if(target >= matrix[mid][0] && target <= matrix[mid][n-1]){
                for(int num : matrix[mid]){
                    if(num == target) return true;
                }
                return false;
            }else if(target < matrix[mid][0]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}
