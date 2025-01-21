class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] mat=new int[image.length][image[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                mat[i][j]=image[i][j];
            }
        }

        int iniCol=image[sr][sc];
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        mat[sr][sc]=color;
        while(!q.isEmpty()){
             int[] node=q.poll();
             int r=node[0];
             int c=node[1];

             for(int i=0;i<4;i++){
                int newR=r+dx[i];
                int newC=c+dy[i];

                if(newR<0|| newR>=image.length||newC<0 ||newC>=image[0].length||image[newR][newC]!=iniCol ||mat[newR][newC]==color){
                    continue;

                }
                else{
                    mat[newR][newC]=color;
                    q.add(new int[]{newR,newC});
                }
             }
        }
        return mat;
    }
}