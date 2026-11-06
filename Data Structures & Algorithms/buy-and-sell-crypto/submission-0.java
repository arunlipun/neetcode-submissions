class Solution {
    public int maxProfit(int[] prices) {
      
         if (prices == null || prices.length == 0) return 0;
        int n=prices.length;
        int minprice=prices[0];
        int maxprofit=0;
        for(int i=0;i<n;i++){
            minprice=Math.min(minprice,prices[i]);
            int profit=prices[i]-minprice;
            maxprofit=Math.max(maxprofit,profit);
            
        }
        return maxprofit;
        
    }
}
