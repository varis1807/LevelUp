import java.util.*;
public class NoOfBoomrangs {
      // 447
    public int numberOfBoomerangs(int[][] points) {
      HashMap<Integer, Integer> map = new HashMap<>();
      int ans = 0, n = points.length;
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              if (i == j)
                  continue;
              int dis = distance(points, i, j);
              map.put(dis, map.getOrDefault(dis, 0) + 1);
          }

          for (int ele : map.values()) {
              ans += ele * (ele - 1);
          }

          map.clear();
      }

      return ans;
  }

  public int distance(int[][] points, int i, int j) {
      int x = (points[j][0] - points[i][0]);
      int y = (points[j][1] - points[i][1]);

      return x * x + y * y;
  }

}
