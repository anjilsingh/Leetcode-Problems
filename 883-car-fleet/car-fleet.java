class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]>al=new ArrayList<>();
        int n=position.length;
        for(int i=0;i<n;i++){
            al.add(new int[]{position[i],speed[i]});
        }
        al.sort((a,b)->b[0]-a[0]);
        Stack<Double>st=new Stack<>();
        for(int i=0;i<n;i++){
            double time=((double)target-al.get(i)[0])
            /(double)al.get(i)[1];
            if(!st.isEmpty() && time<=st.peek()){
                continue;
            }
            st.push(time);
        }
        return st.size();
    }
}