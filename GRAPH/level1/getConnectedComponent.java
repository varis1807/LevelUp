import java.util.*;

public class getConnectedComponent {
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
            // addEdge(graph, 3, 4, 2);
            addEdge(graph, 4, 5, 2);
            addEdge(graph, 4, 6, 8);
            addEdge(graph, 5, 6, 3);
            display(graph, N);
            System.out.println(getConnectedComp(graph));
      }

      public static void main(String[] args) {
            construct();
      }

      public static ArrayList<ArrayList<Integer>> getConnectedComp(ArrayList<Edge>[] graph) {
            ArrayList<ArrayList<Integer>> connectComp = new ArrayList<>();
            int n = graph.length, compCount = 0;
            boolean[] vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                  if (!vis[i]) {
                        ArrayList<Integer> scc = new ArrayList<>();// singleConnectComp
                        dfs_singleConnectComp(i, graph, scc, vis);
                        connectComp.add(scc);
                        compCount++;
                  }
            }
            System.out.println(compCount);
            return connectComp;
      }

      public static void dfs_singleConnectComp(int src, ArrayList<Edge>[] graph, ArrayList<Integer> comp,
                  boolean[] vis) {
            vis[src] = true;
            comp.add(src);
            for (Edge e : graph[src]) {
                  if (!vis[e.nbr])
                        dfs_singleConnectComp(e.nbr, graph, comp, vis);
            }
      }
}
