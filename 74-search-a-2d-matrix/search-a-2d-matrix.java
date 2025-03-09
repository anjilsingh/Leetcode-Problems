class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start=0;
        int end=matrix.length-1;
        while(start<=end){
            int row=start+(end-start)/2;
            if(target<matrix[row][0]){
                end=row-1;
            }
            else if(target>matrix[row][matrix[0].length-1]){
                start=row+1;
            }
            else{
                break;
            }
        }

        int row=(start+end)/2;

        int left=0;
        int right=matrix[0].length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(matrix[row][mid]==target){
                return true;
                
            }
            else if(matrix[row][mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }

        }
        return false;
    }
}