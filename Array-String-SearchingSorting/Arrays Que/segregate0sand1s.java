import java.util.*;

public class segregate0sand1s {
      public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
      }

      public static void segPosNeg(int[] arr) {
            int zero_ptr = -1;
            int ptr = 0;
            int size = arr.length;

            while (ptr < size) {
                  if (arr[ptr] == 0) {
                        swap(arr, ++zero_ptr, ptr);
                  }
                  ptr++;
            }
      }
}
