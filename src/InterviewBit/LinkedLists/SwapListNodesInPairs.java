package InterviewBit.LinkedLists;

public class SwapListNodesInPairs {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args){
        SwapListNodesInPairs a = new SwapListNodesInPairs();
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        ListNode result = a.swap(A);

    }
    // Solution1: Accepted answer, does not use recursion
    public ListNode swapPairs(ListNode A) {
        if(A==null || A.next == null)
            return A;
        ListNode current = A;
        ListNode next;
        ListNode nextPair;
        ListNode newRoot = A.next;
        ListNode prevTail = null;

        while(current !=null && current.next !=null){
            next = current.next;
            nextPair = current.next.next;

            next.next = current;
            current.next = null;
            if(prevTail !=null)
                prevTail.next = next;

            prevTail = current;
            current = nextPair;
        }
        if(current !=null)
            prevTail.next = current;

        return newRoot;
    }
    // Solution2: Interviewbit solution
    //1 -> 2 -> 3 -> 4 -> 5 ->NULL
    public ListNode swapPairs1(ListNode A) {
        if(A == null || A.next == null)
            return A;
        ListNode current = A;
        ListNode head = A.next;
        ListNode prev = null;
        while(current != null && current.next != null) {
            ListNode next = current.next;
            current.next = current.next.next;
            next.next = current;
            if(prev != null)
                prev.next = next;
            prev = current;
            current = current.next;

        }
        return head;
    }

    //Solution3: Partially accepted since uses recursion
    //1 -> 2 -> 3 -> 4 -> NULL
    public ListNode swap(ListNode A){
        if(A == null || A.next == null)
            return A;
        ListNode next = A.next;
        ListNode nextPair = A.next.next;
        next.next = A;
        A.next = swap(nextPair);

        return next;

    }

}
