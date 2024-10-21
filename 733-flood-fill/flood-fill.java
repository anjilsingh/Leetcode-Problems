class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r=image.length;
        int c=image[0].length;
        int inicolor=image[sr][sc];
         if (inicolor == color) {
            return image;
        }
        Queue<int[]>q=new LinkedList<>();
        image[sr][sc]=color;
        q.add(new int[]{sr,sc});
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!q.isEmpty()){
           int[] node=q.poll();
           int row=node[0];
           int col=node[1];
           for(int j=0;j<4;j++){
              int newR=row+dx[j];
              int newC=col+dy[j];
               
               if(newR<0 ||newR>=r ||newC<0 ||newC>=c||image[newR][newC]!=inicolor){
                 continue;
               }
               image[newR][newC]=color;
               q.add(new int[]{newR,newC});
               
           }
            
        }
        return image;
    }
}