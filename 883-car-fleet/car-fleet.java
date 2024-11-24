class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr=new int[position.length][2];
        for(int i=0;i<position.length;i++){
               arr[i][0]=position[i];
               arr[i][1]=speed[i];
        }
        Arrays.sort(arr,(a,b)->Integer.compare(b[0],a[0]));
        Stack<Double>st=new Stack<>();
        for(int[] p:arr){
           st.push((double)(target-p[0])/p[1]);
           if(st.size()>=2 && st.peek()<=st.get(st.size()-2)){
             st.pop();
           }
        }
        return st.size();
    }
}