public class ReverseInRange {
    private static ListNode th = null, tt = null;

    private static void addFirstNode(ListNode node) {
        if (th == null) {
            th = tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public static int length(ListNode head) {
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

    public static ListNode reverseInRange(ListNode head, int n, int m) {
        if (head == null || head.next == null || n == m)
            return head;

        ListNode dummy = new ListNode(-1), prev = dummy, curr = head;
        prev.next = head;
        int i = 1;
        while (i <= m) {
            while (i >= n && i <= m) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
                i++;
            }

            if (i > m) {
                prev.next = th;
                tt.next = curr;
                break;
            }

            i++;
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}