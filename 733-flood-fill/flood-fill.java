class Solution {
    private int[][] dfs(int[][] image,int[][] ans,int sr,int sc,int[] dx, int[] dy,int color,int iniColor){
         int n=image.length;
         int m=image[0].length;
        ans[sr][sc]=color;
        for(int i=0;i<4;i++){
           int  newSr=sr+dx[i];
           int  newSc=sc+dy[i];
            
            
            if(newSr>=0 && newSr<n && newSc>=0 && newSc<m && ans[newSr][newSc]!=color && image[newSr][newSc]==iniColor){
                ans[newSr][newSc]=color;
                dfs(image,ans,newSr,newSc,dx,dy,color,iniColor);

            }
        }
        return ans;
        
   }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //using recursion can be done using bfs or dfs
        
        int iniColor=image[sr][sc];
        int[][] ans=image;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        ans=dfs(image,ans,sr,sc,dx,dy,color,iniColor);
        return ans;
    }
}