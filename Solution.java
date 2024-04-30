import java.util.*;
class DSU{
    ArrayList<Integer> parent=new ArrayList<>();
    ArrayList<Integer> rank=new ArrayList<>();
    DSU(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
        }
    }
    int findParent(int node){
        if(node==parent.get(node)){
            return node;
        }
        int parentNode=findParent(parent.get(node));
        parent.set(node,parentNode);
        return parent.get(node);
    }

    void unionByRank(int u,int v){
        int parentU=findParent(u);
        int parentV=findParent(v);
        if(parentU==parentV){
            return;
        }else{
            if(rank.get(parentU)<rank.get(parentV)){
                parent.set(parentU,parentV);
            }else if(rank.get(parentU)>rank.get(parentV)){
                parent.set(parentV,parentU);
            }else{
                parent.set(parentV,parentU);
                rank.set(parentU,rank.get(parentU)+1);
            }
        }
    }
}
public class Solution {
    public void printNum(int i,int n){
        if(i>n){
            return;
        }
        System.out.print(i+" ");
        printNum(i+1,n);
    }
    public static void main(String[] args) {
        int i=1;
        int n=10;
        Solution s=new Solution();
        s.printNum(i,n);
        System.out.println((char)59);
    }
}