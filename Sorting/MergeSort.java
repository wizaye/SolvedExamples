package Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int arr[]={10,7,6,12,3,8};
        mergeSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    private static void mergeSort(int[] arr,int lo,int hi) {
        // TODO Auto-generated method stub
        if(lo<hi){
            int mid=lo+(hi-lo)/2;
            mergeSort(arr,lo,mid);
            mergeSort(arr, mid+1, hi);
            merge(arr,lo,mid,hi);
        }else{
            return;
        }
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        // TODO Auto-generated method stub
        int merged[]=new int[hi-lo+1];
        int idx1=lo;
        int idx2=mid+1;
        int x=0;
        while(idx1<=mid && idx2<=hi){
            if(arr[idx1]<=arr[idx2]){
                merged[x++]=arr[idx1++];
            } else {
                merged[x++]=arr[idx2++];
            }
        }
        while(idx1<=mid){
            merged[x++]=arr[idx1++];
        }
        while(idx2<=hi){
            merged[x++]=arr[idx2++];
        }
        for(int i=0,j=lo;i<merged.length;i++,j++){
            arr[j]=merged[i];
        }
    }
    
}
