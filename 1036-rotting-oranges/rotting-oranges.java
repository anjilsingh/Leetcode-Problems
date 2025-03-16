class Solution {
    public int orangesRotting(int[][] grid) {
        //first find the fresh orange count
        Queue<int[]>q=new LinkedList<>();
        int freshCount=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                   q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        if(freshCount==0) return 0;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        //now we have to apply a bfs on queue size
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int j=0;j<4;j++){
                    int newR=r+dx[j];
                    int newC=c+dy[j];
                    if(newR<0 ||newC<0 ||newR>=grid.length||newC>=grid[0].length||grid[newR][newC]==2||grid[newR][newC]==0){
                        continue;
                    }
                    else{
                        q.add(new int[]{newR,newC});
                        grid[newR][newC]=2;
                        freshCount--;
                    }
                }


            }
            time++;
            if(freshCount==0){
                break;
            }
        }

      return freshCount==0?time:-1;
    }
}