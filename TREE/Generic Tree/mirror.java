import java.util.*;

public class mirror {
      public static boolean areMirror(Node n1, Node n2) {
            if (n1.children.size() != n2.children.size())
                  return false;
            boolean res = true;

            int i = 0;
            int j = n2.children.size() - 1;

            while (i < n1.children.size() && j >= 0) {
                  Node c1 = n1.children.get(i);
                  Node c2 = n2.children.get(j);

                  res = res && areMirror(c1, c2);

                  i++;
                  j--;
            }

            return res;

      }
}
