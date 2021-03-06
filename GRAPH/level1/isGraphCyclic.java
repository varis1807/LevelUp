import java.util.*;

public class isGraphCyclic {
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
            //addEdge(graph, 3, 4, 2);
            //addEdge(graph, 4, 5, 2);
            //addEdge(graph, 4, 6, 8);
           // addEdge(graph, 5, 6, 3);
            // display(graph, N);
            System.out.println(isCyclic(graph, 0));
      }

      public static void main(String[] args) {
            construct();
      }

      public static boolean isCyclic(ArrayList<Edge>[] graph, int src) {
            LinkedList<Integer> que = new LinkedList<>();
            int n = graph.length;
            boolean[] vis = new boolean[n];
            que.addLast(src);
            int level = 0;
            boolean isCycle = false;

            while (que.size() != 0) {
                  int size = que.size();
                  while (size-- > 0) {
                        int rvtx = que.removeFirst();
                        if (vis[rvtx]) {
                              isCycle = true;
                              continue;
                        }
                        vis[rvtx] = true;
                        for (Edge e : graph[rvtx]) {
                              if (!vis[e.nbr])
                                    que.addLast(e.nbr);
                        }
                  }
                  level++;
            }
            return isCycle;
      }
}
