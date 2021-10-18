import java.util.*;

public class GrayCode {
      public List<String> gray(int n) {
            if (n == 1) {
                  List<String> BaseRes = new ArrayList<>();
                  BaseRes.add("0");
                  BaseRes.add("1");
                  return BaseRes;
            }
            List<String> RecRes = gray(n - 1);
            List<String> MyRes = new ArrayList<>();
            for (int i = 0; i < RecRes.size(); i++) {
                  String RecInt = RecRes.get(i);
                  MyRes.add("0" + RecInt);
            }
            for (int i = RecRes.size() - 1; i >= 0; i--) {
                  String RecInt = RecRes.get(i);
                  MyRes.add("1" + RecInt);
            }
            return MyRes;
      }

      public List<Integer> grayCode(int n) {
            List<String> res = gray(n);
            List<Integer> ans = new ArrayList<>();
            for (String i : res) {
                  ans.add(Integer.parseInt(i, 2));
            }
            return ans;
      }
}
