import java.util.*;

public class hamiltonianPath {
      public static void hamiltonian(int src, ArrayList<Edge>[] graph, boolean[] vis, String psf, int oSRC) {
            if (psf.length() == graph.length - 1)// base case
            {
                  psf += src;
                  boolean isHC = false;// is hamiltonian cycle
                  for (Edge e : graph[oSRC]) {
                        int nbr = e.nbr;
                        if (nbr == src)
                              isHC = true;
                  }
                  System.out.println(psf);
                  if (isHC == true)
                        System.out.println('*');// Hamiltonian cycle
                  else
                        System.out.println(".");// hamiltonian path
            }

            vis[src] = true;
            for (Edge e : graph[src]) {
                  if (!vis[e.nbr])
                        hamiltonian(e.nbr, graph, vis, psf + e.nbr, oSRC);
            }
            vis[src] = false;
      }
}
