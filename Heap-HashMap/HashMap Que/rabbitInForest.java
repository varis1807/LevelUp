import java.util.*;
public class rabbitInForest {
       // 781
    public int numRabbits(int[] arr) {
      HashMap<Integer, Integer> map = new HashMap<>();
      int n = arr.length, ans = 0;

      for (int ele : arr) {
          if (!map.containsKey(ele)) {
              ans += 1 + ele;
              map.put(ele, 1);
          } else {
              map.put(ele, map.get(ele) + 1);
          }

          if (map.get(ele) == ele + 1)
              map.remove(ele);
      }

      return ans;

  }
}
