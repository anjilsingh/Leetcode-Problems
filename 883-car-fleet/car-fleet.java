class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]>arr=new ArrayList<>();
        for(int i=0;i<position.length;i++){
            arr.add(new int[]{position[i],speed[i]});
        }
        arr.sort((a,b)->b[0]-a[0]);
        Stack<Double>st=new Stack<>();
        for(int i=0;i<position.length;i++){
             double time=(double)(target-arr.get(i)[0])/arr.get(i)[1];
             if(!st.isEmpty() && st.peek()>=time){
                continue;
             }
             st.push(time);
        }
        return st.size();
    }
}