import java.util.*;
public class DiagonalTraverse {
        // 1424
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
      HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

      int maxDiag = 0;
      int len = 0;
      for (int i = 0; i < nums.size(); i++) {
          for (int j = 0; j < nums.get(i).size(); j++) {
              int idx = i + j;
              map.putIfAbsent(idx, new LinkedList<>());
              map.get(idx).addFirst(nums.get(i).get(j)); // map[idx].push_front(ele);

              maxDiag = Math.max(maxDiag, idx);
              len++;
          }
      }

      int[] ans = new int[len];
      int idx = 0;
      for (int i = 0; i <= maxDiag; i++) {
          LinkedList<Integer> list = map.get(i);
          while (list.size() != 0) {
              ans[idx++] = list.removeFirst();
          }
      }

      return ans;

  }
}
