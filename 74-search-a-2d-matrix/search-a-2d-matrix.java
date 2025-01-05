class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //can use the concept of first decide the row and find the ele in that row 
        int row=matrix.length-1;
        int col=matrix[0].length-1;

        int low=0;
        int high=row;
        while(low<=high){
            int mid=(high+low)/2;
            if(target<matrix[mid][0]){
                high=mid-1;
            }
            else if(target>matrix[mid][col]){
                low=mid+1;
            }
            else{
                break;
            }
        }
        if(low>high) return false;
        int r=(high+low)/2;

        int left=0;
        int right=col;

        while(left<=right){
            int mid=(right+left)/2;
            if(matrix[r][mid]==target) return true;
            else if(matrix[r][mid]<target) left=mid+1;
            else right=mid-1;
        }
        return false;
    }
}