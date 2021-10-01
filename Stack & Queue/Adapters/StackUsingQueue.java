
import java.util.LinkedList;

public class StackUsingQueue {

      // Push Efficient
      // O(1)
      LinkedList<Integer> queue = new LinkedList<>();
      LinkedList<Integer> temp = new LinkedList<>();
      public int topEle = 0;

      public StackUsingQueue() {
      }

      public void push(int x) {
            queue.addLast(x);
            this.topEle = x;
      }

      public void swapData(LinkedList<Integer> q1, LinkedList<Integer> q2) {
            while (q1.size() != 1) {
                  q2.addLast(q1.removeFirst());
            }
      }

      public int pop() {
            swapData(queue, temp);
            int rv = queue.removeFirst();
            if (temp.size() != 0) {
                  swapData(temp, queue);
                  this.topEle = temp.getFirst();
                  queue.addLast(temp.removeFirst());
            }

            return rv;
      }

      public int top() {
            return this.topEle;
      }

      public boolean empty() {
            return this.queue.size() == 0;
      }

      // Pop Efficient
      // O(1)
      LinkedList<Integer> que = new LinkedList<>();
      private void transfer(LinkedList<Integer> st1, LinkedList<Integer> st2) {
            while (st1.size() != 0) {
                  st2.addLast(st1.removeFirst());
            }
      }

      public void push1(int x) {
            temp.addLast(x);
            transfer(que, temp);

            LinkedList<Integer> temp1 = que;
            que = temp;
            temp = temp1;
      }

      // O(1)
      public int pop1() {
            return que.removeFirst();
      }

      public int top1() {
            return que.getFirst();
      }

      public boolean empty1() {
            return que.size() == 0;
      }
}
