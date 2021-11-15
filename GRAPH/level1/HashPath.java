import java.util.*;

public class HashPath {
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
            addEdge(graph, 0, 1, 10);
            addEdge(graph, 0, 3, 10);
            addEdge(graph, 1, 2, 10);
            addEdge(graph, 2, 3, 40);
            addEdge(graph, 3, 4, 2);
            addEdge(graph, 4, 5, 2);
            addEdge(graph, 4, 6, 8);
            addEdge(graph, 5, 6, 3);
            /// display(graph, N)
            display(graph, N);
            boolean[] vis = new boolean[N];
            System.out.println(hashPath(graph, 2, 5, vis));

      }

      public static void main(String[] args) {
            construct();
      }

      public static boolean hashPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
            if (src == dest)
                  return true;
            vis[src] = true;
            boolean res = false;
            for (Edge e : graph[src]) {
                  if (!vis[e.nbr])
                        res = res || hashPath(graph, e.nbr, dest, vis);
            }
            return res;
      }
}
