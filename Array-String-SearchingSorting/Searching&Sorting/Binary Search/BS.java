public class BS {
      public static int binarySearch(int[] arr, int si, int ei, int data) {
            while (si <= ei) {
                  int mid = (si + ei) / 2;
                  if (arr[mid] == data)
                        return mid;
                  else if (arr[mid] < data)
                        si = mid + 1;
                  else
                        ei = mid - 1;
            }
            return -1;
      }

      public static void main(String[] args) {
            int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 98 };
            System.out.println(binarySearch(arr, 0, 8, 5));
      }
}