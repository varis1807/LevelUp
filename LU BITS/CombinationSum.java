import java.util.*;
public class CombinationSum {
   // questions.

    // 39
    public void combinationSum(int[] arr, int tar, int idx, List<List<Integer>> ans, List<Integer> smallAns) {

      if (tar == 0) {
          List<Integer> base = new ArrayList<>(smallAns); // deep copy
          ans.add(base); // shallow copy
          return;
      }

      for (int i = idx; i < arr.length; i++) {
          if (tar - arr[i] >= 0) {
              smallAns.add(arr[i]);
              combinationSum(arr, tar - arr[i], i, ans, smallAns);
              smallAns.remove(smallAns.size() - 1);
          }
      }

  }

  public List<List<Integer>> combinationSum(int[] arr, int tar) {
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> smallAns = new ArrayList<>();

      combinationSum(arr, tar, 0, ans, smallAns);
      return ans;
  }
 
}
