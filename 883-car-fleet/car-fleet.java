class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]>al=new ArrayList<>();
        for(int i=0;i<position.length;i++){
            al.add(new int[]{position[i],speed[i]});
        }
        al.sort((a,b)->b[0]-a[0]);

        Stack<Double>st=new Stack<>();

        for(int i=0;i<al.size();i++){
            int[] curr=al.get(i);

            double time=(double)(target-curr[0])/curr[1];

            if(!st.isEmpty() && st.peek()>=time){
                continue;
            }

            st.push(time);
        }
        return st.size();
    }
}