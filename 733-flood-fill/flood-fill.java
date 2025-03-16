class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor=image[sr][sc];

        //can use the concept of bfs 
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc]=color;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int j=0;j<4;j++){
                int newR=r+dx[j];
                int newC=c+dy[j];
                if(newR<0 ||newR>=image.length||newC<0 ||newC>=image[0].length||image[newR][newC]!=orgColor ||image[newR][newC]==color){
                    continue;
                }
                else{
                    image[newR][newC]=color;
                    q.add(new int[]{newR,newC});
                }

            }
        }
        return image;
    }
}