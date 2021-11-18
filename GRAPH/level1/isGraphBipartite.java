import java.util.*;

public class isGraphBipartite {
      static class Pair {
            int vtx;
            int sn;// set no.
            Pair() {
            }
            Pair(int vtx, int sn) {
                  this.vtx = vtx;
                  this.sn = sn;
            }
      }
      public static boolean singleCompBipart(ArrayList<Edge>[] graph, int src, int[] vis) {
            ArrayDeque<Pair> que = new ArrayDeque<>();
            que.add(new Pair(src, 1));
            while (que.size() > 0) {
                  // remove
                  Pair rvtx = que.remove();
                  // mark*
                  if (vis[rvtx.vtx] != 0) {
                        // check
                        int osn = vis[rvtx.vtx];// old Set no.
                        int psn = rvtx.sn;// present set no.
                        if (osn != psn) {
                              return false;
                        } else
                              continue;
                  }
                  vis[rvtx.vtx] = rvtx.sn;
                  // add unvisited nbr
                  for (Edge e : graph[rvtx.vtx]) {
                        int nbr = e.nbr;
                        if (vis[nbr] == 0) {
                              int nsn = (rvtx.sn == 1) ? 2 : 1;// nsns=nbr set no.
                              que.add(new Pair(nbr, nsn));
                        }

                  }
            }
            return true;
      }

      public static boolean isBipartite(ArrayList<Edge>[] graph) {
            int[] vis = new int[graph.length];
            for (int i = 0; i < graph.length; i++) {
                  if (vis[i] == 0) {
                        boolean sca = singleCompBipart(graph, i, vis);// single componant ans
                        if (sca == false)
                              return false;
                  }
            }
            return true;
      }
}
