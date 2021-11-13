public class firstOcurrence {
      public static int first(int[] arr, int data, int si, int ei) {
            while (si <= ei) {
                  int mid = (si + ei) / 2;
                  if (arr[mid] == data) {
                        if (mid - 1 >= 0 && arr[mid - 1] == data)
                              ei = mid - 1;
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
            int[] arr={0,0,0,0,1,1,1,1,1,1,1,1,1,1,1};
            System.out.println(first(arr, 1,0, arr.length-1));
      }
}
