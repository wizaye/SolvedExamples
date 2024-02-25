package Graphs;
import java.util.*;

public class DFS {
    public static void dfs(boolean visited[],int v,ArrayList<ArrayList<Integer>> adj,int source){
        visited[source]=true;
        System.out.print(source+"-->");
        for(int i:adj.get(source)){
            if(visited[i]!=true){
                dfs(visited,v,adj,i);
            }
        }

    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(3).add(2);
        for(int i=0;i<v;i++){
            System.out.println(i+"-->"+adj.get(i));
        } 
        boolean visited[]=new boolean[v+1];
        dfs(visited,v, adj, 0); 
        System.out.println();     
    }
    
}
