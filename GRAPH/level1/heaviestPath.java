import java.util.*;

public class heaviestPath {
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
            pathPair ans = hp(graph, 0, 6, vis);
            System.out.println("hp: " + ans.psf + " of wt: " + ans.wsf);
      }

      public static void main(String[] args) {
            construct();
      }

      public static class pathPair {
            String psf = "";
            int wsf = -1;
      }

      public static pathPair hp(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
            if (src == dest) {
                  pathPair base = new pathPair();
                  base.psf = base.psf + src;
                  base.wsf = 0;
                  return base;
            }
            vis[src] = true;
            pathPair myAns = new pathPair();
            for (Edge e : graph[src]) {
                  if (!vis[e.nbr]) {
                        pathPair recAns = hp(graph, e.nbr, dest, vis);
                        if (recAns.wsf != -1 && recAns.wsf + e.wt > myAns.wsf) {
                              myAns.psf = src + recAns.psf;
                              myAns.wsf = recAns.wsf + e.wt;
                        }
                  }
            }
            vis[src] = false;
            return myAns;
      }
}
