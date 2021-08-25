public class SubstractLL {
      public static ListNode reverse(ListNode head) {
            if (head == null || head.next == null)
                  return head;

            ListNode prev = null, curr = head;
            while (curr != null) {
                  ListNode forw = curr.next; // backup

                  curr.next = prev; // link

                  prev = curr;
                  curr = forw;
            }

            return prev;
      }

      public static int getLength(ListNode head) {
            if (head == null)
                  return 0;
            int len = 0;
            ListNode curr = head;
            while (curr != null) {
                  curr = curr.next;
                  len++;
            }

            return len;
      }

      public static boolean isBiggerList(ListNode l1, ListNode l2) {
            int len1 = getLength(l1), len2 = getLength(l2);
            if (len1 > len2)
                  return true;
            else if (len1 < len2)
                  return false;

            ListNode c1 = l1, c2 = l2;
            while (c1 != null) {
                  if (c1.val > c2.val)
                        return true;
                  else if (c1.val < c2.val)
                        return false;

                  c1 = c1.next;
                  c2 = c2.next;
            }

            return true;
      }

      public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
            ListNode c1 = null, c2 = null;
            if (isBiggerList(l1, l2)) {
                  c1 = reverse(l1);
                  c2 = reverse(l2);
            } else {
                  c1 = reverse(l2);
                  c2 = reverse(l1);
            }

            ListNode dummy = new ListNode(-1), prev = dummy;
            int borrow = 0;
            while (c1 != null || c2 != null) {
                  int diff = borrow + (c1 != null ? c1.val : 0) - (c2 != null ? c2.val : 0);
                  if (diff < 0) {
                        borrow = -1;
                        diff += 10;
                  } else {
                        borrow = 0;
                  }

                  prev.next = new ListNode(diff);
                  prev = prev.next;

                  if (c1 != null)
                        c1 = c1.next;
                  if (c2 != null)
                        c2 = c2.next;
            }

            ListNode ans = reverse(dummy.next);
            prev = dummy;
            prev.next = null;
            ListNode c = ans;
            while (c != null) {
                  if (c.val != 0) {
                        prev.next = c;
                        break;
                  }

                  ListNode forw = c.next;
                  c.next = null;
                  c = forw;
            }

            return dummy.next != null ? dummy.next : new ListNode(0);
      }

}
