//https://leetcode.com/problems/find-in-mountain-array/
class Solution {
    int peakIndex(MountainArray mountainArr){
        int start=0;
        int end=mountainArr.length()-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
    int binarySearch(int target,MountainArray mountainArr,int start,int end,boolean agnostic){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(!agnostic){
                if(mountainArr.get(mid)>target){
                    end=mid-1;
                }else if(mountainArr.get(mid)<target){
                    start=mid+1;
                }else{
                    return mid;
                }

            }else{
                if(mountainArr.get(mid)>target){
                    start=mid+1;
                }else if(mountainArr.get(mid)<target){
                    end=mid-1;
                }else{
                    return mid;
                }

            }

        }
        return -1;

    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak=peakIndex(mountainArr);
        int leftIndex=binarySearch(target,mountainArr,0,peak,false);
        int end=mountainArr.length();
        int rightIndex=binarySearch(target,mountainArr,peak,end-1,true);
        
        if(leftIndex==-1){
            return rightIndex;
        }else{
            return leftIndex;
        } 
        
    }
}
