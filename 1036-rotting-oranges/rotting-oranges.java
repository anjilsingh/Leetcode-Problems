class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>q=new LinkedList<>();
        int row=grid.length-1;
        int col=grid[0].length-1;
        int fresh=0;
        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
              if(grid[i][j]==1) fresh++;

              if(grid[i][j]==2){
                q.add(new int[]{i,j});
              }
            }
        }
        int time=0;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        while(fresh>0 && !q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                int[] node=q.poll();
                int r=node[0];
                int c=node[1];

                for(int j=0;j<4;j++){
                   int  newR=r+dx[j];
                   int  newC=c+dy[j];

                    if(newR<0 ||newR>row||newC<0||newC>col||grid[newR][newC]==0||grid[newR][newC]==2){
                        continue;
                    }
                    else{
                        grid[newR][newC]=2;
                        q.add(new int[]{newR, newC});

                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh==0?time:-1;
    }
}