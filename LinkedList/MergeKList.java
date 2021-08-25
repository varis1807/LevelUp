public class MergeKList {
      public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null)
                  return l1 != null ? l1 : l2;

            ListNode dummy = new ListNode(-1), p = dummy, c1 = l1, c2 = l2;

            while (c1 != null && c2 != null) {
                  if (c1.val < c2.val) {
                        p.next = c1;
                        c1 = c1.next;
                  } else {
                        p.next = c2;
                        c2 = c2.next;
                  }

                  p = p.next;
            }

            p.next = c1 != null ? c1 : c2;
            return dummy.next;
      }

      public static ListNode mergeKLists(ListNode[] lists, int si, int ei) {
            if (si == ei)
                  return lists[si];

            int mid = (si + ei) / 2;
            ListNode leftList = mergeKLists(lists, si, mid);
            ListNode rightList = mergeKLists(lists, mid + 1, ei);

            return mergeTwoLists(leftList, rightList);
      }

      public static ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0)
                  return null;

            return mergeKLists(lists, 0, lists.length - 1);
      }

}
