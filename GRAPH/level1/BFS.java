import java.util.*;

public class BFS {
      public static void bfs(ArrayList<Edge>[] graph, int src, int dest) {
            LinkedList<Integer> que = new LinkedList<>();
            boolean[] vis = new boolean[graph.length];
            que.add(src);
            int level = 0;
            boolean isCyclePresent = false;
            int shortestPath = -1;
            while (que.size() != 0) {
                  int size = que.size();
                  while (size-- > 0) {
                        int rvtx = que.removeFirst();
                        if (vis[rvtx]) {
                              isCyclePresent = true;
                              continue;
                        }
                        if (rvtx == dest)
                              shortestPath = level;
                        vis[rvtx] = true;
                        System.out.println(level + " ->> " + rvtx);

                        for (Edge e : graph[rvtx]) {
                              if (!vis[e.nbr])
                                    que.addLast(e.nbr);
                        }
                  }
            }
      }
}