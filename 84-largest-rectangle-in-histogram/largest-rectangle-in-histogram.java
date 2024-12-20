class Solution {
    public int largestRectangleArea(int[] heights) {
        //second way is to use 
        //stack
        //for any index we push it till we can and when we remove it 
        
        int n=heights.length;
        Stack<int[]>st=new Stack<>();
        int marea=0;
        for(int i=0;i<n;i++){
            int start=i;
            while(!st.isEmpty() && st.peek()[1]>heights[i]){
                int ele[]=st.pop();
                int index=ele[0];
                int val=ele[1];
                marea=Math.max(marea,(i-index)*val);
                start=index;
            }
            st.push(new int[]{start,heights[i]});
        }
       
        while(!st.isEmpty()){
           int rem[]=st.pop();
           int ind=rem[0];
           int value=rem[1];
            marea=Math.max(marea,(n-ind)*value);
        }
        return marea;
    }
}