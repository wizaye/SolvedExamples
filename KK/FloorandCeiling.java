class Solution {
    int indexfinder(int[] nums,int target,boolean startindex){
        int ans=-1;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int middle=start+(end-start)/2;
            if(nums[middle]>target){
                end=middle-1;
            }else if(nums[middle]<target){
                start=middle+1;
            }else{
                ans=middle;
                if(startindex){
                    end=middle-1;
                }else{
                    start=middle+1;
                }
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[]={-1,-1};
        int start=indexfinder(nums,target,true);
        int end=indexfinder(nums,target,false);
        ans[0]=start;
        ans[1]=end;
        return ans;

        
    }
}