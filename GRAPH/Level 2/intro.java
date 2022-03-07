import java.util.*;

public class intro {
      public static class Edge {
            int v;// vertex
            int w;// wight

            Edge(int v, int u) {
                  this.v = v;
                  this.w = w;
            }
      }

      public static void addEdge(int u, int v, int w, ArrayList<Edge>[] graph) {
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
      }

      public static void removeEdge(int u, int v, ArrayList<Edge>[] graph) {

      }
      // public static toString(){
      // return this.v+", "+this.w;
      // }

      public static void display(ArrayList<Edge>[] graph) {
            int V = graph.length;
            for (int i = 0; i < V; i++) {
                  System.out.println(i + " ->");
                  for (int j = 0; j < graph[i].size(); j++) {
                        Edge e = graph[i].get(j);

                        System.out.print("{ " + e.v + ", " + e.w + " }");
                  }
            }
      }

      public static void construct() {
            int v = 11;
            ArrayList<Edge>[] graph = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                  graph[i] = new ArrayList<>();
            }
            addEdge(0, 1, 2, graph);
            addEdge(1, 3, 4, graph);
            addEdge(1, 2, 3, graph);
            addEdge(3, 4, 5, graph);
            addEdge(3, 1, 4, graph);
            addEdge(2, 1, 3, graph);
            addEdge(2, 4, 7, graph);
            addEdge(4, 2, 7, graph);
            addEdge(4, 3, 5, graph);
            addEdge(4, 9, 8, graph);
            addEdge(4, 10, 10, graph);
            addEdge(5, 6, 2, graph);
            addEdge(5, 7, 3, graph);
            addEdge(6, 5, 2, graph);
            addEdge(6, 7, 1, graph);
            addEdge(7, 6, 1, graph);
            addEdge(7, 5, 3, graph);
            addEdge(9, 10, 8, graph);
            addEdge(9, 4, 8, graph);
            addEdge(10, 9, 8, graph);
            addEdge(10, 4, 10, graph);
      }
}