package DP;


import java.util.* ;
import java.io.*; 

public class SubsetSumEqualsK {

    //recursive code
    public static boolean helper(int arr[],int k,int i){
        if(i<0) return false;

        if(arr[i]==k) return true;
        boolean take=helper(arr,k-arr[i],i-1);
        boolean leave=helper(arr,k,i-1);
        return take|| leave;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        // return helper(arr,k,n-1);
        boolean dp[][]=new boolean[n+1][k+1]; // increase array size by 1
        dp[0][0]=true;
        for(int i=1;i<=n;i++){ // start from 1, include the 0th element
            for(int j=0;j<=k;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]|| dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
}

