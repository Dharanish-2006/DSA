import java.util.*;

public class DijkstraShortestPath {
    static class Edge {
        int dest, weight;
        Edge(int d, int w) {
            dest = d;
            weight = w;
        }
    }

    static class Graph {
        int V;
        LinkedList<Edge>[] adj;

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int src, int dest, int weight) {
            adj[src].add(new Edge(dest, weight));
            adj[dest].add(new Edge(src, weight));
        }

        void dijkstra(int src) {
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.add(new int[]{src, 0});

            while (!pq.isEmpty()) {
                int[] node = pq.poll();
                int u = node[0];
                int d = node[1];
                if (d > dist[u]) continue;

                for (Edge edge : adj[u]) {
                    int v = edge.dest;
                    int newDist = dist[u] + edge.weight;
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new int[]{v, newDist});
                    }
                }
            }

            System.out.println("Vertex\tDistance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 4, 3);
        g.dijkstra(0);
    }
}
