public class perfectPosition {
      public static int perfectLocation(int[] arr, int data) {
            int si = 0, ei = arr.length;

            while (si < ei) {
                  int mid = (si + ei) / 2;
                  if (arr[mid] <= data)
                        si = mid + 1;
                  else
                        ei = mid;
            }
            return ei; // si
      }
}
