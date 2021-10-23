import java.util.*;
public class ArrayDoublePair {
      // 954
      public boolean canReorderDoubled(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();

            int N = arr.length;
            Integer[] ARR = new Integer[N];
            for (int i = 0; i < N; i++) {
                  map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                  ARR[i] = arr[i];
            }

            Arrays.sort(ARR, (a, b) -> {
                  return Math.abs(a) - Math.abs(b);
            });

            for (Integer ele : ARR) {
                  if (map.get(ele) == 0)
                        continue;
                  if (map.getOrDefault(2 * ele, 0) <= 0)
                        return false;

                  map.put(ele, map.get(ele) - 1);
                  map.put(2 * ele, map.get(2 * ele) - 1);
            }

            return true;
      }

}
