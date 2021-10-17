import java.util.*;

public class KthSmallinMat {
    // My method
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k)
                    pq.remove();
            }
        }
        return pq.peek();
    }

    // Sir code
    // 378
    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int i1 = a / m, j1 = a % m;
            int i2 = b / m, j2 = b % m;

            return matrix[i1][j1] - matrix[i2][j2];
        });

        for (int i = 0; i < n; i++)
            pq.add(i * m + 0);

        int r = 0, c = 0;
        while (k-- > 0) {
            int idx = pq.remove();
            r = idx / m;
            c = idx % m;
            if (c + 1 < m)
                pq.add(r * m + c + 1);
        }

        return matrix[r][c];
    }
}
