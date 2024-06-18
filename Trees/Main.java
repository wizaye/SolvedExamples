// "static void main" must be defined in a public class.
public class Main {
    public static void buildTree(int idx,int l,int r,int[] arr,int[] seg){
      if(l==r){
        seg[idx]=arr[l]; 
        return;
      }
      int mid=l+(r-l)/2;
      buildTree(2*idx+1,l,mid,arr,seg);
      buildTree(2*idx+2,mid+1,r,arr,seg);
      seg[idx]=seg[2*idx+1]+seg[2*idx+2];
      
    }
    public static void updateTree(int idx,int val,int i,int l,int r,int[] seg){
      if(l==r){
        seg[i]=val;
        return;
      }
      int mid=l+(r-l)/2;
      if(idx<=mid){
        updateTree(idx,val,2*i+1,l,mid,seg);
      }else{
        updateTree(idx,val,2*i+2,mid+1,r,seg);
      }
      seg[i]=seg[2*i+1]+seg[2*i+2];
    }
    public static int Query(int start,int end,int i,int l,int r,int seg[]){
      if(l>end || r<start) return 0;
      if(l>=start && r<=end) return seg[i];
      int mid=l+(r-l)/2;
      return Query(start,end,2*i+1,l,mid,seg)+Query(start,end,2*i+2,mid+1,r,seg);
    
    }
    public static void main(String[] args) {
        int n=8;
        int arr[]={3,1,2,7,2,1,2,3};
        int seg[]=new int[2*n];
        buildTree(0,0,n-1,arr,seg);
        for(int i:seg) System.out.print(i+" ");
        System.out.println();
        updateTree(7,4,0,0,n-1,seg);
        for(int i:seg) System.out.print(i+" ");
        System.out.println();
        System.out.println(Query(2,6,0,0,n-1,seg));
        
    }
}