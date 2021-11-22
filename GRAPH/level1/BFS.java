import java.util.*;

public class BFS {
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
            // bfs_isCycle(graph, 0, 6);
      }

      public static void main(String[] args) {
            construct();
      }

      public static void bfs_isCycle(ArrayList<Edge>[] graph, int src, int dest) {
            LinkedList<Integer> que = new LinkedList<>();
            boolean[] vis = new boolean[graph.length];
            que.add(src);
            int level = 0;
            boolean isCyclePresent = false;
            int shortestPath = -1;
            while (que.size() != 0) {
                  int size = que.size();
                  System.out.print(level + " ->> ");
                  while (size-- > 0) {
                        int rvtx = que.removeFirst();

                        if (vis[rvtx]) {
                              isCyclePresent = true;
                              continue;
                        }

                        if (rvtx == dest)
                              shortestPath = level;

                        vis[rvtx] = true;

                        System.out.print(rvtx + " ");

                        for (Edge e : graph[rvtx]) {
                              if (!vis[e.nbr])
                                    que.addLast(e.nbr);
                        }
                  }
                  System.out.println();
                  level++;
            }
      }
}