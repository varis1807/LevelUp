public class SegregeteOverLastIdx {
      public static ListNode segregateOnLastIndex(ListNode head) {
            if (head == null || head.next == null)
                  return head;

            ListNode small = new ListNode(-1); // all Nodes smaller or equal to given data.
            ListNode sp = small; // smaller previous

            ListNode greater = new ListNode(-1); // all Nodes greater than given data.
            ListNode gp = greater; // greater previous

            ListNode tail = head;
            while (tail.next != null)
                  tail = tail.next;

            ListNode curr = head;
            while (curr != null) {
                  if (curr.val <= tail.val) {
                        sp.next = curr;
                        sp = sp.next;
                  } else {
                        gp.next = curr;
                        gp = gp.next;
                  }

                  curr = curr.next;
            }

            gp.next = null;
            sp.next = greater.next;

            small.next = null;
            greater.next = null;

            return sp;
      }
}
