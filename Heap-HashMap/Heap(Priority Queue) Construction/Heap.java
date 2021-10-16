import java.util.ArrayList;

public class Heap {
      private ArrayList<Integer> arr;

      public Heap() {
            this.arr = new ArrayList<>();
      }

      // O(n + nLog(n)) -> O(n)
      public Heap(int[] arr) {
            this();
            for (int ele : arr)
                  this.arr.add(ele);

            for (int i = this.arr.size() - 1; i >= 0; i--)
                  downHeapify(i);
      }

      // O(1)
      public boolean compareTo(int x, int y) {
            return this.arr.get(x) > this.arr.get(y);
      }

      // O(1)
      private void swap(int x, int y) {
            int v1 = this.arr.get(x);
            int v2 = this.arr.get(y);

            this.arr.set(x, v2);
            this.arr.set(y, v1);
      }

      // Log(n)
      private void downHeapify(int pi) {
            int lci = 2 * pi + 1;
            int rci = 2 * pi + 2;
            int maxIdx = pi;

            if (lci < arr.size() && compareTo(lci, maxIdx))
                  maxIdx = lci;

            if (rci < arr.size() && compareTo(rci, maxIdx))
                  maxIdx = rci;

            if (pi != maxIdx) {
                  swap(maxIdx, pi);
                  downHeapify(maxIdx);
            }
      }

      // Log(n)
      private void upHeapify(int ci) {
            int pi = (ci - 1) / 2;
            if (pi >= 0 && compareTo(ci, pi)) {
                  swap(ci, pi);
                  upHeapify(pi);
            }
      }

      public int size() {
            return this.arr.size();
      }

      // Log(n)
      public int remove() {
            int re = this.arr.get(0);
            swap(0, this.arr.size() - 1);
            this.arr.remove(this.arr.size() - 1);
            downHeapify(0);
            return re;
      }

      // Log(n)
      public void add(int data) {
            this.arr.add(data);
            upHeapify(this.arr.size() - 1);
      }

      // O(1)
      public int peek() {
            return this.arr.get(0);
      }

      public static void main(String[] args) {
            int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13, 14 };
            Heap hp = new Heap(arr); // true -> max, false -> min

            while (hp.size() != 0) {
                  System.out.print(hp.remove() + " ");
            }

      }
}