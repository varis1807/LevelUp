public class minMaxProd {
      public boolean check(int mid, int n, int[] q) {
            for (int e : q) {
                  int stores = e / mid;
                  if (e % mid != 0)
                        stores++;
                  n -= stores;
            }
            return n >= 0;
      }

      public int minimizedMaximum(int n, int[] quantities) {
            int si = 1;
            int ei = 1;
            for (int e : quantities)
                  ei = Math.max(ei, e);
            while (si < ei) {
                  int mid = (si + ei) / 2;
                  if (!check(mid, n, quantities))
                        si = mid + 1;
                  else
                        ei = mid;
            }
            return si;
      }
}
