import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>fans=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer>ans=new ArrayList<>();
            for(int j=0;j<=i;j++){
                 if(j==0||j==i){
                   ans.add(1);
                 }
                  else{
                    ans.add(fans.get(i-1).get(j-1)+fans.get(i-1).get(j));
                  }

            }
            fans.add(ans);
            
        }
        return fans;
    }
}