import java.util.*;

public class segregatePositiveInteger {
      public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
      }

      public static void segPosNeg(int[] arr) {
            int neg_ptr = -1;
            int ptr = 0;
            int size = arr.length;

            while (ptr < size) {
                  if (arr[ptr] < 0) {
                        swap(arr, ++neg_ptr, ptr);
                  }
                  ptr++;
            }
      }

      public static void main(String[] args) {
            int[] arr = { 10, 20, 30, -45, -95, 50, -8, 65, -9, -69 };
            segPosNeg(arr);
            for (int ele : arr)
                  System.out.print(ele+" ");
      }
}
