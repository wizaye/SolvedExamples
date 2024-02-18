package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[]={10,7,6,12,3,8};
        selectionSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    private static void selectionSort(int[] arr) {
        // TODO Auto-generated method stub
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    
}
