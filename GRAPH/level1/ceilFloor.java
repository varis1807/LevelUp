import java.util.*;

public class ceilFloor {
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
            display(graph, N);
            boolean[] vis = new boolean[N];
            CFpair pair = new CFpair();
            ceilANDfloor(graph, 0, 20, vis, 0, pair);
            System.out.println(pair.ceil);
            System.out.println(pair.floor);
      }

      public static void main(String[] args) {
            construct();
      }

      public static class CFpair {
            int ceil = (int) 1e9;
            int floor = -(int) 1e9;
      }

      public static void ceilANDfloor(ArrayList<Edge>[] graph, int src, int data, boolean[] vis, int wsf, CFpair pair) {
            if (wsf > data)
                  pair.ceil = Math.min(pair.ceil, wsf);
            if (wsf < data)
                  pair.floor = Math.max(pair.floor, wsf);
            vis[src] = true;
            for (Edge e : graph[src]) {
                  if (!vis[e.nbr])
                        ceilANDfloor(graph, e.nbr, data, vis, wsf + e.wt, pair);
            }
            vis[src] = false;
      }
}
