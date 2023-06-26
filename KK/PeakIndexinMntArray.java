//https://leetcode.com/problems/peak-index-in-a-mountain-array/
class Solution {
    // public int peakIndexInMountainArray(int[] arr) {
    //     int max=Integer.MIN_VALUE;
    //     int max_index=0;
    //     for(int i=0;i<arr.length;i++){
    //         if(max<arr[i]){
    //             max=arr[i];
    //             max_index=i;
    //         }

    //     }
    //     return max_index;
        
    // }
    public int peakIndexInMountainArray(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }else {
                start=mid+1;
            }
        }
        return start;
    }
}
