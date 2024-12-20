class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] lmin=new int[n];
        int[] rmin=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<heights.length;i++){
             while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
               st.pop();
             }
            
            lmin[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        
        //rightmin
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            rmin[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        
        int mArea=0;
        for(int i=0;i<heights.length;i++){
          int area=(rmin[i]-lmin[i]-1)*heights[i];
          mArea=Math.max(mArea,area);
        }
        return mArea;
    }
}