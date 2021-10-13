import java.util.*;
public class carFleet1 {
       // 853
    public int carFleet(int target, int[] position, int[] speed) {
      int n = speed.length;

      // {position, time}
      double[][] disTimeData = new double[n][2];
      for (int i = 0; i < n; i++) {
          disTimeData[i][0] = position[i] * 1.0;
          disTimeData[i][1] = ((target - position[i]) * 1.0) / speed[i];
      }

      Arrays.sort(disTimeData, (a, b) -> {
          return (int) (a[0] - b[0]);
      });

      int carFleet = 1;
      double prevTime = disTimeData[n - 1][1];
      for (int i = n - 2; i >= 0; i--) {
          if (disTimeData[i][1] > prevTime) {
              prevTime = disTimeData[i][1];
              carFleet++;
          } else {
              // fleet will be same;
          }
      }

      return carFleet;
  }
}
