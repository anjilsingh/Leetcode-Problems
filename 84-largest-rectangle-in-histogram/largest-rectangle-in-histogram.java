class Solution {
    public int largestRectangleArea(int[] heights) {
        int area=Integer.MIN_VALUE;

        Stack<int[]>st=new Stack<>();
        
        for(int i=0;i<heights.length;i++){
            int start=i;

            while(!st.isEmpty() && st.peek()[1]>heights[i]){
               int[] curr=st.pop();
               area=Math.max(area,(i-curr[0])*curr[1]);
               start=curr[0];
            }
            st.push(new int[]{start,heights[i]});
        }
        while(!st.isEmpty()){
            int[] curr=st.pop();
            area=Math.max(area,(heights.length-curr[0])*curr[1]);
        }
        return area;
    }
}