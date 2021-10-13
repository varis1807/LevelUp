import java.util.*;

public class ExclusiveTimeFunc {

      public int[] exclusiveTime(int n, List<String> logs) {
            class logPair {
                  int id, timeStamp, sleepTime;
                  boolean isStart = false;

                  logPair(String str) {
                        String[] ar = str.split(":");
                        this.id = Integer.parseInt(ar[0]);
                        this.timeStamp = Integer.parseInt(ar[2]);
                        this.isStart = ar[1].equals("start");
                        this.sleepTime = 0;
                  }
            }

            LinkedList<logPair> st = new LinkedList<>();
            int[] ans = new int[n];

            for (String s : logs) {
                  logPair log = new logPair(s);

                  if (log.isStart)
                        st.addFirst(log);
                  else {
                        logPair rp = st.removeFirst();
                        ans[rp.id] += log.timeStamp - rp.timeStamp + 1 - rp.sleepTime;

                        if (st.size() != 0)
                              st.getFirst().sleepTime += log.timeStamp - rp.timeStamp + 1;
                  }
            }

            return ans;
      }
}
