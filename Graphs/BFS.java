package Graphs;
import java.util.*;


public class BFS {
    public static void bfs(int v,ArrayList<ArrayList<Integer>> adj,int source){
        boolean visited[]=new boolean[v+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int vertex=q.poll();
            System.out.print(vertex+"-->");
            for(int adjVertex:adj.get(vertex)){
                if(visited[adjVertex]!=true){
                    visited[adjVertex]=true;
                    q.add(adjVertex);
                }
            }
        }
        System.out.println();

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
        bfs(v, adj, 3);      
    }
    
}
