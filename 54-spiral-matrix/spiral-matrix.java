class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
                List<Integer>ans=new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return ans;

        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int bottom=matrix.length-1;

        while(left<=right && top<=bottom){
            //first print from left to right

          for(int i=left;i<=right;i++){
            ans.add(matrix[top][i]);
          }
          top++;

          //top to bottom
          for(int i=top;i<=bottom;i++){
            ans.add(matrix[i][right]);
          }
          right--;

          if(top<=bottom){
            for(int i=right;i>=left;i--){
                ans.add(matrix[bottom][i]);
            }
            bottom--;
          }

          if(left<=right){
            for(int i=bottom;i>=top;i--){
                ans.add(matrix[i][left]);
            }

            left++;
          }
        }
        return ans;
    }
}