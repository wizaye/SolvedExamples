package Graphs;

import java.util.*;
public class TopologicalSort {
    public static void topoDfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],Stack<Integer> st,int src){
        visited[src]=true;
        for(int adjVertex:adj.get(src)){
            if(!visited[adjVertex]){
                topoDfs(adj, visited, st, adjVertex);

            }
        }
        st.push(src);
    }
    public static void topoBfs(ArrayList<ArrayList<Integer>> adj,int[] inDegree ,Queue<Integer> q,int src){
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int vertex=q.poll();
            System.out.print(vertex+" ");
            for(int adjVertex:adj.get(vertex)){
                inDegree[adjVertex]--;
                if(inDegree[adjVertex]==0){
                    q.add(adjVertex);
                }
            }
        }
    
    } 
    public static void main(String[] args) {
        int v=6;
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i=0;i<6;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(5).add(2);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        boolean visited[]=new boolean[v];
        Stack<Integer> st=new Stack<>();
        System.out.println("Using DFS");
        for(int i=0;i<v;i++){
            if(!visited[i]){
                topoDfs(adj, visited, st, i);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
        System.out.println();
        System.out.println("Using BFS");
        System.out.print("InDegree: ");
        Queue<Integer> q=new LinkedList<>();
        int[] inDegree=new int[v];
        for(int i=0;i<v;i++){
            for(int j:adj.get(i)){
                inDegree[j]++;

            }
        }
        for(int i:inDegree){
            System.out.print(i+" ");
        }
        System.out.println();
        topoBfs(adj, inDegree, q, v);
    }
    
}
