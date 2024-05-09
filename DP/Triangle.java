package DP;
import java.util.* ;
import java.io.*; 
public class Triangle {
    public static int helper(int[][] triangle,int i,int j,int col,int n){
        if(i==n-1) return triangle[n-1][j];
        if(j<col){
            int down=triangle[i][j]+helper(triangle,i+1, j+1,col+1, n);
            int right=triangle[i][j]+helper(triangle, i+1, j,col ,n);
            return Math.min(down,right);
        }

        return (int)1e8;
       
    }
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        // return helper(triangle,0,0,1,n);

        int dp[][]=new int[n][n];
        for(int j=0;j<n;j++){
            dp[n-1][j]=triangle[n-1][j];

        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down=triangle[i][j]+dp[i+1][j];
                int diagonal=triangle[i][j]+dp[i+1][j+1];
                dp[i][j]=Math.min(down,diagonal);
            }
            
        }
        return dp[0][0];


    }
}