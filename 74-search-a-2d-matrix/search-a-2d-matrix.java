class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //one way is to change 2d matrix in 1d and apply  binary search
        
       int[] oneD = new int[matrix.length * matrix[0].length];

// Fill the 1D array
int index = 0;
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[0].length; j++) {
        oneD[index++] = matrix[i][j];
    }
}

        int l=0;
        int r=oneD.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(oneD[mid]==target) return true;
            else if(oneD[mid]<target) l=mid+1;
            else r=mid-1;

        }
        return false;
    }
}