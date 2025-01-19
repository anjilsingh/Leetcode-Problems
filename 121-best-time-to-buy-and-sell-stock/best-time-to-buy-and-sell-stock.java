class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int profit=0;
        for(int r=1;r<prices.length;r++){
            if(prices[r]>prices[l]){
               profit=Math.max(profit,prices[r]-prices[l]);
            }
            else{
                l=r;
            }
        }
        return profit;
    }
}