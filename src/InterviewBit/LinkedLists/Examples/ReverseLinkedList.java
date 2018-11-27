package InterviewBit.LinkedLists.Examples;

public class ReverseLinkedList {

     class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }

      }

        public ListNode reverseList(ListNode A) {
            ListNode previous = null;
            ListNode current = A;
            ListNode next = null;

            while(current !=null){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;

        }
}


