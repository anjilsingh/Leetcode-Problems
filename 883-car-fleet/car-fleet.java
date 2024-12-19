class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]>arr=new ArrayList<>();
        for(int i=0;i<position.length;i++){
           arr.add(new int[]{position[i],speed[i]});
        }
        arr.sort((a,b)->b[0]-a[0]);
        
        
        Stack<Double>st=new Stack<>();
        for(int[] p:arr){
           double dis=(double) (target-p[0])/p[1];
           if(!st.isEmpty() && dis<=st.peek()){
             //means they will collide and dont need to put further 
               continue;
           }
            st.push(dis);
        }
      return st.size();  
    }
}