public class Solution2 implements Solution {
    @Override
    public ListNode rotateRight(ListNode head, int k) {

        int len = length(head);
        if (len > 0) {
            int n = len-k % length(head);
            ListNode newlast = findNth(head, n);
            ListNode oldlast = findNth(head, len);
            oldlast.next = head;
            head = newlast.next;
            newlast.next = null;
        }
        return head;
    }

    private int length(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    private ListNode findNth(ListNode head, int n) {
        int i = 1;
        ListNode p = head;
        while (i < n) {
            i++;
            p = p.next;
        }
        return p;
    }
}
