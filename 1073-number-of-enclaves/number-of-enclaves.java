class Solution {
    public int numEnclaves(int[][] grid) {
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        Queue<int[]>q=new LinkedList<>();
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!q.isEmpty()){
             int node[]=q.poll();
             int r=node[0];
             int c=node[1];

             for(int j=0;j<4;j++){
                int newR=r+dx[j];
                int newC=c+dy[j];

                if(newR<0 ||newR>=grid.length||newC<0 ||newC>=grid[0].length||grid[newR][newC]==0 ||vis[newR][newC]){
                    continue;
                }
                else{
                    q.add(new int[]{newR,newC});
                    vis[newR][newC]=true;
                }
             }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                 count++;

                }
            }
        }
        return count;
    }
}