package Graphs;


import java.util.*;

class Tuple{
    int weight;
    int node;
    int parent;
    Tuple(int weight,int node,int parent){
        this.weight=weight;
        this.node=node;
        this.parent=parent;
    }
}
class Pair{
    int weight;
    int node;
    int parent;
    Pair(int weight,int node){
        this.weight=weight;
        this.node=node;
    }
}
public class PrimsAlgorithm{
	static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    for(int arr[]:edges){
	        adj.get(arr[0]).add(new Pair(arr[2],arr[1]));
	        adj.get(arr[1]).add(new Pair(arr[2],arr[0]));
	    }
	    // Code Here. 
	    int sum=0;
	    PriorityQueue<Tuple> pq=new PriorityQueue<Tuple>((x,y)-> x.weight-y.weight);
	    int visited[]=new int[V];
	    pq.add(new Tuple(0,0,-1));
	    while(!pq.isEmpty()){
	        int weight=pq.peek().weight;
	        int node=pq.peek().node;
	        int parent=pq.peek().parent;
	        pq.remove();
	        if(visited[node]==1) continue;
	        visited[node]=1;
	        sum+=weight;
	        for(Pair adjNode:adj.get(node)){
	            int vertex=adjNode.node;
	            int cost=adjNode.weight;
	            if(visited[vertex]==0){
	                pq.add(new Tuple(cost,vertex,node));
	            }
	        }
	    }
	    return sum;
	}
}