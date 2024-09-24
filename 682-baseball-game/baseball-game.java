class Solution {
    public int calPoints(String[] operations) {
        int ans=0;
         Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            try {
          
                int num = Integer.parseInt(op.trim());
                stack.push(num);
            } catch (NumberFormatException e) {
                if(op.equals("C")){
                     stack.pop();
                }
                else if(op.equals("D")){
                  int x=stack.peek();
                  stack.push(2*x);
                }
                else if(op.equals("+")){
                     if (stack.size() >= 2) {
            // Peek the last (top) element
            int last = stack.peek();
            
            // Pop the last element to access the second-last
            stack.pop();
            
            // Peek the new top element (second-last)
            int s = stack.peek();
            
            // Restore the last element by pushing it back if necessary
            stack.push(last);
            
            stack.push(last+s);
               }
                }
            }
        }
        while(!stack.isEmpty()){
            int x=stack.pop();
            ans=ans+x;
        }
        return ans;
    }
}