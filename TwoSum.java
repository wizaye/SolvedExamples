import java.util.Arrays;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i,j;
        int arr[]=new int[2];
        for(i=0;i<nums.length;i++){
            for(j=0;j<i;j++){
                if(nums[i]+nums[j]==target){
                    arr[0]=i;
                    arr[1]=j;
                    break;
                }
            }
        }
        Arrays.sort(arr);
        
        return arr;
        
    }
}
