//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(even(nums[i])){
                count++;
            }
        }
        return count;
        
    }
    static boolean even(int num){
        int digitCount=0;
        while(num>0){
            num=num/10;
            digitCount+=1;
        }
        if(digitCount%2==0){
            return true;
        }
        return false;
    }
}
