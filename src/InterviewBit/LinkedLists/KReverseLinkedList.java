package InterviewBit.LinkedLists;

public class KReverseLinkedList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    //Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
    //Output:  3->2->1->6->5->4->8->7->NULL.
    private static ListNode reverseList(ListNode A, int B){
        ListNode current = A;
        ListNode previous = null;
        ListNode next = null;
        int count = 0;

        while(count < B && current!=null){
            count++;
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }

        if(next !=null){
            A.next = reverseList(next,B);
        }

        return previous;
    }

}
