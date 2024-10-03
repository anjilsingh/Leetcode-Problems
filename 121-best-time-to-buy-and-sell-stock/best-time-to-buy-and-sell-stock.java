class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int mP=0;
        for(int i=1;i<prices.length;i++){
            mP=Math.max(prices[i]-buy,mP);
            if(prices[i]<buy){
              buy=prices[i];
            }
        }
        return mP;
    }
}