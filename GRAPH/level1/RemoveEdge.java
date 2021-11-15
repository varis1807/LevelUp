import java.util.*;

public class RemoveEdge {
      public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {
            ArrayList<Edge> list = graph[u];
            for (int i = 0; i < list.size(); i++) {
                  Edge e = list.get(i);
                  if (e.nbr == v)
                        return i;
            }
            return -1;
      }
}
