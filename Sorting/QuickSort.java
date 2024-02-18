package Sorting;
public class QuickSort {
    public static int partition(int arr[],int l,int r){
        int pvt=arr[l];
        int i=l;
        int j=r;
        while(i<j){
            while(arr[i]<=pvt){
                i++;
            }
            while(arr[j]>pvt){
                j--;
            }
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[j];
        arr[j]=pvt;
        arr[l]=temp;
        return j;
    }
    public static void quickSort(int arr[],int l,int r){
        if(l<=r){
            int p=partition(arr,l,r);
            quickSort(arr,l,p-1);
            quickSort(arr,p+1,r);
        }
    }
    public static void main(String[] args) {
        int arr[]={10,7,6,12,3,8};
        quickSort(arr, 0, arr.length-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
