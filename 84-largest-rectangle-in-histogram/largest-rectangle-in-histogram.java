class Solution {
    public int largestRectangleArea(int[] heights) {
        int mArea=0;
        Stack<int[]>st=new Stack<>();
        
        for(int i=0;i<heights.length;i++){
            int start=i;
            while(!st.isEmpty() && st.peek()[1]>heights[i]){
               int[] top=st.pop();
               int ht=top[1];
               int index=top[0];
              
               mArea=Math.max(mArea,ht*(i-index));
                start=index;
            }
            st.push(new int[]{start,heights[i]});
        
        }
        
        while(!st.isEmpty()){
           int curr[]=st.pop();
            int index=curr[0];
            int val=curr[1];
            mArea=Math.max(mArea,val*(heights.length-index));
        
        
        
        }
        return mArea;
    }
}