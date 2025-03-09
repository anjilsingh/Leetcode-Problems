class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        Stack<int[]>st=new Stack<>();
        for(int i=0;i<heights.length;i++){
            int start=i;
            while(!st.isEmpty() && st.peek()[1]>heights[i]){
                int ele[] =st.pop();
                int index=ele[0];
                int val=ele[1];
                int area=(i-index)*val;
                maxArea=Math.max(maxArea,area);
                start=index;
            }
            st.push(new int[]{start,heights[i]});
        }


        while(!st.isEmpty()){
                int ele[] =st.pop();
                int index=ele[0];
                int val=ele[1];
                int area=(heights.length-index)*val;
                maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}