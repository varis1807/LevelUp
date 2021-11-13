public class firstLastOccureence {
      public static int firstIndex(int[] arr, int data) {
            if (arr[0] == data)
                  return 0;

            int si = 0, ei = arr.length - 1;
            while (si <= ei) {
                  int mid = (si + ei) / 2;
                  if (arr[mid] == data) {
                        if (arr[mid - 1] == data)
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

      public static int lastIndex(int[] arr, int data) {
            if (arr[arr.length - 1] == data)
                  return arr.length - 1;

            int si = 0, ei = arr.length - 1;
            while (si <= ei) {
                  int mid = (si + ei) / 2;
                  if (arr[mid] == data) {
                        if (arr[mid + 1] == data)
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

      public static int[] searchRange(int[] arr, int target) {
            if (arr.length == 0)
                  return new int[] { -1, -1 }; // new int[]{-1,-1};
            return new int[] { firstIndex(arr, target), lastIndex(arr, target) }; // new int[]{};
      }
}
