import java.util.*;

public class KPartition {
      public static int count = 1;

      public static void kPartition(int num, int TotalNum, ArrayList<ArrayList<Integer>> ans) {
            if (num > TotalNum) {
                  if (ans.get(ans.size() - 1).size() == 0)
                        return;
      
                  System.out.print(count++ + ") ");
                  for (ArrayList<Integer> a : ans)
                        System.out.print(a + " ");
                  System.out.println();
                  return;
            }
            for (ArrayList<Integer> a : ans) {
                  a.add(num);
                  kPartition(num + 1, TotalNum, ans);
                  a.remove(a.size() - 1);
                  if (a.size() == 0)
                        break;
            }
      }

      public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int k = scn.nextInt();
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                  ans.add(new ArrayList<>());
            }
            kPartition(1, n, ans);

      }

}
