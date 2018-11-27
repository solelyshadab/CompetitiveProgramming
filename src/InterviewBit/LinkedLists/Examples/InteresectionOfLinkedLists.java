package InterviewBit.LinkedLists.Examples;

public class InteresectionOfLinkedLists {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

        public ListNode getIntersectionNode(ListNode a, ListNode b) {
            int len1 = length(a);
            int len2 = length(b);
            int d = 0;

            if (len1 > len2) {
                d = len1 - len2;
                return intersection(a, b, d);
            } else {
                d = len2 - len1;
                return intersection(b, a, d);
            }
        }

        private static ListNode intersection(ListNode a, ListNode b, int d) {
            ListNode current1 = a;
            ListNode current2 = b;
            for (int i = 0; i < d; i++) {
                if (current1 == null)
                    return null;
                current1 = current1.next;
            }

            while (current1 != null && current2 != null) {

                if (current1 == current2)
                    return current1;

                current1 = current1.next;
                current2 = current2.next;

            }
            return null;

        }

        private static int length(ListNode a) {
            int length = 0;
            ListNode current = a;
            while (current != null) {
                length++;
                current = current.next;
            }
            return length;
        }
    }
