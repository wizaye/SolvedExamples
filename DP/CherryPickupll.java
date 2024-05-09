package DP;
import java.util.* ;
import java.io.*;
public class CherryPickupll {

	public static int helper(int i,int j1,int j2,int[][] grid,int r,int c){
		if(j1<0 || j1>=c || j2<0 || j2>=c) return Integer.MIN_VALUE;
		if(i==r-1){
			if(j1==j2){
				return grid[i][j1];
			}else{
				return grid[i][j1]+grid[i][j2];
			}
		}
		int maxi=0;
		//9 combinations
		int next[]={-1,0,1};
		for(int d1=0;d1<next.length;d1++){
			for(int d2=0;d2<next.length;d2++){
				if(j1==j2){
					maxi=Math.max(maxi,grid[i][j1]+helper(i+1,j1+next[d1],j2+next[d2],grid,r,c));
				}else{
					maxi=Math.max(maxi,grid[i][j1]+grid[i][j2]+helper(i+1,j1+next[d1],j2+next[d2],grid,r,c));
				}
			
			}

		}
		return maxi;
	}
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		// return helper(0,0,c-1,grid,r,c);
		int dp[][][]=new int[r][c][c];
		for(int j1=0;j1<c;j1++){
			for(int j2=0;j2<c;j2++){
				if(j1==j2){
					dp[r-1][j1][j2]=grid[r-1][j1];
				}else{
					dp[r-1][j1][j2]=grid[r-1][j1]+grid[r-1][j2];

				}
			}
		}
		for(int i=r-2;i>=0;i--){
			for(int j1=0;j1<c;j1++){
				for(int j2=0;j2<c;j2++){
					int maxi=Integer.MIN_VALUE;;
					//9 combinations

					for(int d1=-1;d1<=1;d1++){
						for(int d2= -1;d2<=1;d2++){
							int value=0;

							if(j1==j2){
								value=grid[i][j1];
							}else{
								value=grid[i][j1]+grid[i][j2];
							}
							if(j1+d1>=0 && j1+d1<c && j2+d2>=0 && j2+d2<c){
								value+=dp[i+1][j1+d1][j2+d2];
							}else{
								value+=(int)-1e8;

							}
							maxi=Math.max(maxi,value);
						
						}

					}
					dp[i][j1][j2]=maxi;
				}
			}
			
		}
		return dp[0][0][c-1];

		


		
	}
}