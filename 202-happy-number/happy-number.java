class Solution {
    public int getSquareSum(int n){
        int res=0;
        while(n>0){
            int curr=(n%10);
            res+=curr*curr;
            n=n/10;
        }
        return res;
    }
    public boolean isHappy(int n) {
        
        HashSet<Integer>seen=new HashSet<>();
        while(true){
            if(n==1) return true;
        if(seen.contains(n)){
            return false;
        }
        seen.add(n);
        n=getSquareSum(n);

        }

    }
}