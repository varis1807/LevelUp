import java.util.*;

public class segregatePositiveInteger {
      public static void segPosNeg(int[] arr) {
            int neg_ptr = -1;
            int ptr = 0;
            int size = arr.length;

            while (ptr < size) {
                  if (arr[ptr] < 0) {
                        swap(arr[++neg_ptr], arr[ptr]);
                  }
                  ptr++;
            }
      }
}
