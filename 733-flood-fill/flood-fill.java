class Solution {
    public  void dfs(int[]dx, int[] dy,int inicolor,int color,int[][] image,int sr,int sc,int r,int c){
        
        image[sr][sc]=color;
        for(int j=0;j<4;j++){

              int newR=sr+dx[j];
              int newC=sc+dy[j];
               
               if(newR<0 ||newR>=r ||newC<0 ||newC>=c||image[newR][newC]!=inicolor){
                 continue;
               }
              dfs(dx,dy,inicolor,color,image,newR,newC,r,c);
        
        }
    
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r=image.length;
        int c=image[0].length;
        int inicolor=image[sr][sc];
         if (inicolor == color) {
            return image;
        }
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        dfs(dx,dy,inicolor,color,image,sr,sc,r,c);
        return image;
        
        
    }
}