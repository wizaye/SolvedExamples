package Graphs;

import java.util.*;

class Pair {
    int wt;
    int node;

    Pair(int wt, int node) {
        this.wt = wt;
        this.node = node;
    }

}

public class DijkstrasAlgorithm {
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x, y) -> x.wt - y.wt);
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        q.add(new Pair(0, S));
        while (!q.isEmpty()) {
            int node = q.peek().node;
            int wt = q.peek().wt;
            q.remove();
            for (ArrayList<Integer> arr : adj.get(node)) {
                int currentDist = arr.get(1);
                int currentNode = arr.get(0);
                if (wt + currentDist < distance[currentNode]) {
                    distance[currentNode] = wt + currentDist;
                    q.add(new Pair(distance[currentNode], currentNode));
                }

            }

        }
        return distance;
    }
    public static int[] dijkstraQueue(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        Queue<Pair> q = new LinkedList<>();
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        q.add(new Pair(0, S));
        while (!q.isEmpty()) {
            int node = q.peek().node;
            int wt = q.peek().wt;
            q.remove();
            for (ArrayList<Integer> arr : adj.get(node)) {
                int currentDist = arr.get(1);
                int currentNode = arr.get(0);
                if (wt + currentDist < distance[currentNode]) {
                    distance[currentNode] = wt + currentDist;
                    q.add(new Pair(distance[currentNode], currentNode));
                }
            }
        }
        return distance;
    }

}
