class Tuple{
    int distance;
    int row;
    int col;
    public Tuple(int distance,int row, int col){
        this.row = row;
        this.distance = distance;
        this.col = col; 
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        //1 declare a priority queue ({diff,row,col})
 PriorityQueue<Tuple> pq = 
        new PriorityQueue<Tuple>((x,y) -> x.distance - y.distance);
    //2 size
        int n=heights.length;
        int m=heights[0].length;
        
    //diff array and mark as infi
        int[][] diff=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                diff[i][j]=(int)1e9;
            }
        }
        
        diff[0][0]=0;
        pq.add(new Tuple(0,0,0));  
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        
        while(pq.size()!=0){
            Tuple it=pq.peek();
            pq.remove();
            int dif=it.distance;
            int row=it.row;
            int col=it.col;
            
            if(row==n-1 && col==m-1)   return dif;
            
            for(int i=0;i<4;i++){
                   int newr=row+dr[i];
                   int newc=col+dc[i];
                if(newr>=0 && newr<n && newc>=0 && newc<m){
 int newEffort=Math.max(Math.abs(heights[row][col]-heights[newr][newc]),dif);
            if(newEffort<diff[newr][newc])   {
              diff[newr][newc]=newEffort;
              pq.add(new Tuple(diff[newr][newc],newr,newc));
            } 
                }
                }
        }
    return 0;
            
        
    }
}