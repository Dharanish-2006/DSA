import java.util.*;

public class GraphTraversal {
    private int V;
    private LinkedList<Integer>[] adj;

    GraphTraversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // for undirected graph
    }

    void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        System.out.print("BFS: ");
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int n : adj[node]) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
        System.out.println();
    }

    void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v])
            if (!visited[n])
                dfsUtil(n, visited);
    }

    void dfs(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS: ");
        dfsUtil(start, visited);
        System.out.println();
    }

    public static void main(String[] args) {
        GraphTraversal g = new GraphTraversal(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        g.bfs(0);
        g.dfs(0);
    }
}
