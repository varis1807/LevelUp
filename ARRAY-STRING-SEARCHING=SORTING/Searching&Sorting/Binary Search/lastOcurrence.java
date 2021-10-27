public class lastOcurrence {
      public static int last(int[] arr, int data, int si, int ei) {
            while (si <= ei) {
                  int mid = (si + ei) / 2;
                  if (arr[mid] == data) {
                        if (mid + 1 < arr.length && arr[mid + 1] == data)
                              si = mid + 1;
                        else
                              return mid;
                  } else if (arr[mid] < data)
                        si = mid + 1;
                  else
                        ei = mid - 1;
            }
            return -1;
      }

      public static void main(String[] args) {
            int[] arr = { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
            System.out.println(last(arr, 0, 0, arr.length - 1));
      }
}
