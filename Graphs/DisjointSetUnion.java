package Graphs;
import java.util.*;

class DisjointSet{
    ArrayList<Integer> parent=new ArrayList<>();
    ArrayList<Integer> rank=new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<=n;i++){
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
    void unionByRank(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);
        if (parentU == parentV) return;
        
        if (rank.get(parentU) < rank.get(parentV)) {
            parent.set(parentU, parentV);
        } else if (rank.get(parentU) > rank.get(parentV)) {
            parent.set(parentV, parentU);
        } else {
            parent.set(parentV, parentU);
            rank.set(parentU, rank.get(parentU) + 1);
        }
    }
}
public class DisjointSetUnion {
    public static void main(String[] args) {
        DisjointSet ds=new DisjointSet(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        ds.unionByRank(3,7);
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    
    
}
