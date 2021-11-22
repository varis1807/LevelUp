import java.util.*;

public class preOrder {
      public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
      }

      public static void display(ArrayList<Edge>[] graph, int N) {
            for (int i = 0; i < N; i++) {
                  System.out.print(i + " -> ");
                  for (Edge e : graph[i]) {
                        System.out.print("(" + e.nbr + ", " + e.wt + ") ");
                  }
                  System.out.println();
            }
      }

      public static void construct() {
            int N = 7;// vertex
            ArrayList<Edge>[] graph = new ArrayList[N];
            for (int i = 0; i < N; i++)
                  graph[i] = new ArrayList<>();
            // addEdge(graph, 0, 1, 10);
            // addEdge(graph, 0, 3, 10);
            // addEdge(graph, 1, 2, 10);
            // addEdge(graph, 2, 3, 40);
            // addEdge(graph, 3, 4, 2);
            // addEdge(graph, 4, 5, 2);
            // addEdge(graph, 4, 6, 8);
            // addEdge(graph, 5, 6, 3);
            addEdge(graph, 1, 2, 10);
            addEdge(graph, 1, 3, 10);
            addEdge(graph, 1, 4, 10);
            addEdge(graph, 2, 1, 40);
            addEdge(graph, 2, 3, 2);
            addEdge(graph, 2, 5, 2);
            addEdge(graph, 3, 1, 10);
            addEdge(graph, 3, 2, 10);
            addEdge(graph, 3, 4, 10);
            addEdge(graph, 3, 5, 40);
            addEdge(graph, 3, 6, 2);
            addEdge(graph, 4, 1, 2);
            addEdge(graph, 4, 3, 8);
            addEdge(graph, 4, 6, 3);
            addEdge(graph, 5, 2, 40);
            addEdge(graph, 5, 3, 2);
            addEdge(graph, 5, 6, 2);
            addEdge(graph, 6, 3, 8);
            addEdge(graph, 6, 4, 3);
            addEdge(graph, 6, 5, 3);
            display(graph, N);
            boolean[] vis = new boolean[N];
            pre(graph, 0, vis, 0, "");

      }

      public static void main(String[] args) {
            construct();
      }

      public static void pre(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf) {
            System.out.println(src + " -> " + (psf + src) + " @ " + wsf);
            vis[src] = true;
            for (Edge e : graph[src]) {
                  if (!vis[e.nbr])
                        pre(graph, e.nbr, vis, e.wt + wsf, psf + src);
            }
            vis[src] = false;
      }
}
