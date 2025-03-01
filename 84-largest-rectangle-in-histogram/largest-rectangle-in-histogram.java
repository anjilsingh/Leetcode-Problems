class Solution {
    public int largestRectangleArea(int[] heights) {
        int mArea=0;
        Stack<int[]>st=new Stack<>();
        for(int i=0;i<heights.length;i++){
            int start=i;
            while(!st.isEmpty() && heights[i]<st.peek()[1]){
                int[] ele=st.pop();
                int index=ele[0];
                int elem=ele[1];
                mArea=Math.max((i-index)*elem,mArea);
                start=index;
            }
            st.push(new int[]{start,heights[i]});
        }

        while(!st.isEmpty()){
               int[] ele=st.pop();
                int index=ele[0];
                int elem=ele[1];
                mArea=Math.max((heights.length-index)*elem,mArea);
        }
        return mArea;
    }
}