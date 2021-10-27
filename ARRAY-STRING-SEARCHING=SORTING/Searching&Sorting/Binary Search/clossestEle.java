public class clossestEle {
      public static int closesetElement(int[] arr, int data) {
            int si = 0, ei = arr.length - 1;
            if (data < arr[si])
                  return si;
            else if (data > arr[ei])
                  return ei;

            while (si <= ei) {
                  int mid = (si + ei) / 2;
                  if (arr[mid] == data)
                        return mid;
                  else if (arr[mid] < data)
                        si = mid + 1;
                  else
                        ei = mid - 1;
            }

            return data - arr[ei] < arr[si] - data ? ei : si;
      }
}
