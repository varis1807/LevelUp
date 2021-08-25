public class MultiplyLL {
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

      public static void addList(ListNode prev, ListNode list) {
            int carry = 0;
            while (list != null || carry != 0) {
                  int sum = carry + (list != null ? list.val : 0) + (prev.next != null ? prev.next.val : 0);
                  int digit = sum % 10;
                  carry = sum / 10;

                  if (prev.next != null)
                        prev.next.val = digit;
                  else
                        prev.next = new ListNode(digit);

                  prev = prev.next;
                  if (list != null)
                        list = list.next;
            }
      }

      public static ListNode multiplyDigit(ListNode list, int d) {
            ListNode dummy = new ListNode(-1), curr = list, prev = dummy;

            int carry = 0;
            while (curr != null || carry != 0) {
                  int ans = carry + (curr != null ? curr.val : 0) * d;
                  int digit = ans % 10;
                  carry = ans / 10;

                  prev.next = new ListNode(digit);
                  prev = prev.next;

                  if (curr != null)
                        curr = curr.next;
            }

            return dummy.next;
      }

      public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
            l1 = reverse(l1);
            l2 = reverse(l2);

            ListNode ans = new ListNode(-1), prev = ans;
            while (l2 != null) {
                  ListNode multipliedList = multiplyDigit(l1, l2.val);
                  addList(prev, multipliedList);
                  prev = prev.next;
                  l2 = l2.next;
            }

            return reverse(ans.next);
      }
}
