package Sorting;

public class BubbleSort {
    public static void bubbleSort(int arr[]){
        int n=arr.length;
        while(n-->0){
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }
        
    }
    public static void main(String[] args) {
        int arr[]={10,7,6,12,3,8};
        bubbleSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    
}
