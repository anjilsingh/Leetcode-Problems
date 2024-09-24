class Solution {
    public int[][] imageSmoother(int[][] img) {
        int row=img.length;
        int col=img[0].length;
        int[][] ans=new int[row][col];
        
         for(int i=0;i<row;i++){
              for(int j=0;j<col;j++){
                   int sum=0;
                    int count=0;
                  for(int x=i-1;x<=i+1;x++ ){
                     for(int y=j-1;y<=j+1;y++){
                        if(x>=0 && x<row && y>=0 && y<col){
                                sum=sum+img[x][y];
                               count++;
                        }
                     }
                  }
                  ans[i][j]=sum/count;
              }
         }
        return ans;
    }
}