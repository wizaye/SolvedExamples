package Searching;

public class LinearSearch {
    public static int linearSearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Your code here
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int ans=linearSearch(arr,6);
        if(ans==-1){
            System.out.println("Not found");
        }
        System.out.println("Found at Index:"+ ans);
    }
}
