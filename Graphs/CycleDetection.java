package Graphs;
import java.util.*;
public class CycleDetection {
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj,int[] inDegree){
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);
            for(int i:adj.get(node)){
                inDegree[i]--;
                if(inDegree[i]==0){
                    q.offer(i);
                }
            }

        }
        return res.size()!=adj.size();
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        int v=5;
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(4);
        adj.get(2).add(3);
        adj.get(3).add(1);
        int inDegree[]=new int[v];
        for(int i=0;i<v;i++){
            for(int adjVertex:adj.get(i)){
                inDegree[adjVertex]++;
            }
        }
        for(int i:inDegree){
            System.out.print(i+" ");
        }
        System.out.println(isCycle(adj, inDegree));
        
        
    }
    
}
