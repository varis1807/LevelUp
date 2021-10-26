import java.util.*;

public class uniqueNoOccurence {
      public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                  map.put(num, map.getOrDefault(num, 0) + 1);
            }
            System.out.print(map.values());
            Set<Integer> set = new HashSet<>(map.values());
            System.out.println(set.size());
            System.out.print(map.size());
            return map.size() == set.size();
      }
}
