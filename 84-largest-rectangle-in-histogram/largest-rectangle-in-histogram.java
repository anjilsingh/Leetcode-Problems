class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int area=0;
        Stack<int[]>st=new Stack<>();
        
        for(int i=0;i<n;i++){
         int start=i;
         while(!st.isEmpty() && st.peek()[1]>heights[i]){
            int[] ele=st.pop();
            int index=ele[0];
            int val=ele[1];
            area=Math.max(area,(i-index)*val);
            start=index;
         }
        st.push(new int[]{start,heights[i]});
        }
        
        
        for(int[] p:st){
             int ind=p[0];
             int value=p[1];
            area=Math.max(area,(n-ind)*value);
        }
        return area;
    }
}