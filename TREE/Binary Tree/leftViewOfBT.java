import java.util.*;

public class leftViewOfBT {
      public static List<Integer> leftview(Node root) {
            LinkedList<Node> que = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();
            que.addLast(root);
            while (que.isEmpty()) {
                int size=que.size();
                boolean first=true;
                while(size--){
                      Node top=que.getFirst();
                      que.removeFirst();
                      if(first){
                            ans.add(top.val);
                            first=false;
                      }
                      if(top.left!=null)
                      que.add
                }
            }
      }

      public static void main(String[] args) {

      }
}
