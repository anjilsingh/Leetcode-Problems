class Solution {
    public int largestRectangleArea(int[] heights) {
        //lets do by best appraoch
        Stack<int[]>st=new Stack<>();
        int n=heights.length;
        int area=0;
        for(int i=0;i<n;i++){
            int start=i;
            while(!st.isEmpty() && st.peek()[1]>heights[i]){
                int[] curr=st.pop();
                int ind=curr[0];
                int ele=curr[1];
                area=Math.max(area,(i-ind)*ele);
                start=ind;
            }
            st.push(new int[]{start,heights[i]});
        }
        
        while(!st.isEmpty()){
           int[] curr=st.pop();
            int ind=curr[0];
            int ele=curr[1];
            area=Math.max(area,(n-ind)*ele);
        }
        return area;
    }
}