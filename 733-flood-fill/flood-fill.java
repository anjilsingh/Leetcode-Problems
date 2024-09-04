class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans=image;
        int iniColor=image[sr][sc];
        int[] delRow={0,0,1,-1};
        int[] delCol={1,-1,0,0};
        dfs(image,sr,sc,color,ans,iniColor,delRow,delCol);
        return ans;
    }
    
   private void dfs(int[][]image,int sr,int sc,int color,int[][]ans,int iniColor,int[]delRow,int[]delCol)
    {    ans[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){

             int r=sr+delRow[i];
             int c=sc+delCol[i];
            //check for valid condition
            
            if(r>=0 && r<n && c>=0 && c<m && image[r][c]==iniColor && ans[r][c]!=color){

             dfs(image,r,c,color,ans,iniColor,delRow,delCol);
            
            
            }
        
        
        }

    
    }
    
    
    }