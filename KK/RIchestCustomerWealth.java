//https://leetcode.com/problems/richest-customer-wealth/
class Solution {
    public int maximumWealth(int[][] accounts) {
        int n=accounts.length;
        int[] wealth=new int[n];
        for(int i=0;i<accounts.length;i++){
            for(int j=0;j<accounts[0].length;j++){
                wealth[i]+=accounts[i][j];
            }
        }
        int max_wealth=Integer.MIN_VALUE;
        for(int i=0;i<wealth.length;i++){
            if(max_wealth<wealth[i]){
                max_wealth=wealth[i];
            }
        }
        return max_wealth;

        
    }
}
