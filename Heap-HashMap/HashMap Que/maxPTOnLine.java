import java.util.*;

public class maxPTOnLine {
    // 149
    public int maxPoints(int[][] points) {
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            int overlap = 0, max = 0;
            for (int j = i + 1; j < n; j++) {
                int xdiff = points[j][0] - points[i][0];
                int ydiff = points[j][1] - points[i][1];

                int gcd = gcd(xdiff, ydiff);

                xdiff /= gcd;
                ydiff /= gcd;

                String s = xdiff + "@" + ydiff;
                map.put(s, map.getOrDefault(s, 0) + 1);
                max = Math.max(map.get(s), max);
            }

            ans = Math.max(max + 1, ans);
            map.clear();
        }

        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
