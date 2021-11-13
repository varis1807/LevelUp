public class containerWithMaxWater {
      public int maxArea(int[] height) {
            int n = height.length;
            int p1 = 0, p2 = n - 1;
            int maxArea = 0;
            while (p1 < p2) {
                  int width = p2 - p1;
                  int len = Math.min(height[p1], height[p2]);
                  int cArea = len * width;
                  maxArea = Math.max(cArea, maxArea);
                  if (height[p1] <= height[p2])
                        p1++;
                  else
                        p2--;
            }
            return maxArea;
      }
}
