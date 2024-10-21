class Solution {
    public int orangesRotting(int[][] grid) {
        //first check if grid is null or empty
        if(grid==null || grid.length==0){
           return 0;
        }
        Queue<int[]>q=new LinkedList<>();
        int r=grid.length;
        int c=grid[0].length;
        int checkCount=0;
        for(int i=0;i<r;i++){
         for(int j=0;j<c;j++){
             if(grid[i][j]==2){
               q.add(new int[]{i,j});
             }
             if(grid[i][j]!=0){
                 checkCount++;
             }
         }
        }
        
        if(checkCount==0) return 0;
        int count=0;
        int minCount=0;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!q.isEmpty()){
            int size=q.size();
            count+=size;
            for(int i=0;i<size;i++){
               int[] node=q.poll();
               int row=node[0];
               int col=node[1];
                for(int j=0;j<4;j++){
                   int newRow=row+dx[j];
                   int newCol=col+dy[j];
                   if(newRow<0 ||newRow>=r ||newCol<0||newCol>=c||grid[newRow][newCol]==2||grid[newRow][newCol]==0) continue;
                    
                    grid[newRow][newCol]=2;
                    q.add(new int[]{newRow,newCol});
                }
            
            
            }
            if(q.size()!=0){
              minCount++;
            }
        
        }
        return count==checkCount?minCount:-1;
        
    }
}