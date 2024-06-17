package Trees;
public class SegmentTree{
    public static void buildTree(int idx,int left,int right,int[] seg,int[] arr){
        if(left==right){
            seg[idx]=arr[left];
            return;
        }
        int mid=left+(right-left)/2;
        buildTree(2*idx+1,left,mid,seg,arr);
        buildTree(2*idx+2,mid+1,right,seg,arr);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
        
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int arr[]={3,1,2,7};
        int seg[]=new int[2*arr.length];
        buildTree(0,0,arr.length-1,seg,arr);
        for(int a:seg) System.out.print(a+" ");
        
    }
}