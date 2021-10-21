import java.util.*;
public class longArithSubSeqInDiff {
       // 1218
    public int longestSubsequence(int[] arr, int d) {
      HashMap<Integer, Integer> map = new HashMap<>();
      int maxLen = 0;
      for (int ele : arr) {
          map.put(ele, map.getOrDefault(ele - d, 0) + 1);
          maxLen = Math.max(maxLen, map.get(ele));
      }

      return maxLen;

  }
}
