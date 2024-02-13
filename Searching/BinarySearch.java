package Searching;

public class BinarySearch {
    public static int binarySearchrecursive(int arr[],int key,int l,int r){
        if(l<=r){
                int mid=l+(r-l)/2;
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]>key){
                return binarySearchrecursive(arr,key,l,r-1);
            }else{
                return binarySearchrecursive(arr, key, l+1, r);
            }
        }else{
            return -1;
        }
    }
    public static int binarySearchriterativer(int arr[],int key){
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]<key){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearchrecursive(arr, 6, 0, arr.length-1));
        System.out.println(binarySearchriterativer(arr, 6));
        
    }
    
}
