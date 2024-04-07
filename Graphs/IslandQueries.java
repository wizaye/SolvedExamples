package Graphs;



import java.util.*;

public class IslandQueries {
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        List<Integer> result = new ArrayList<>();
        int[][] grid = new int[n][m];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int islandCount = 0;
        UnionFind uf = new UnionFind(n * m);
        for (int[] operator : operators) {
            int x = operator[0];
            int y = operator[1];
            if (grid[x][y] == 1) {
                result.add(islandCount);
                continue;
            }
            grid[x][y] = 1;
            islandCount++;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                    if (!uf.find(x * m + y, nx * m + ny)) {
                        islandCount--;
                        uf.union(x * m + y, nx * m + ny);
                    }
                }
            }
            result.add(islandCount);
        }
        return result;
    }
    public static void main(String[] args) {
        IslandQueries solution = new IslandQueries();
        int[][] operators = {{1, 1}, {0, 1}, {3, 3}, {3, 4}};
        List<Integer> result = solution.numOfIslands(4, 5, operators);
        System.out.println(result);
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean find(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
