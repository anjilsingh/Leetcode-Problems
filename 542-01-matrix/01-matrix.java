class Pair{
    int r;
    int c;
    int dis;
    Pair(int r,int c,int dis){
        this.r=r;
        this.c=c;
        this.dis=dis;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans=new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        // for(int i=0;i<mat.length;i++){
        //     for(int j=0;j<mat[0].length;j++){
        //         ans[i][j]=mat[i][j];
        //     }
        // }

        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=true;
                }
            }
        }

        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                Pair pair=q.poll();
                int row=pair.r;
                int col=pair.c;
                int distance=pair.dis;

                for(int j=0;j<4;j++){
                    int newR=row+dx[j];
                    int newC=col+dy[j];

                    if(newR<0 ||newR>=mat.length||newC<0 ||newC>=mat[0].length||visited[newR][newC]==true) continue;

                    else{
                        ans[newR][newC]=distance+1;
                        q.add(new Pair(newR,newC,distance+1));
                        visited[newR][newC]=true;
                    }
                }

            }
        }
        return ans;

    }
}