package InterviewBit.LinkedLists;

public class SortedList {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args){
        SortedList a = new SortedList();
        ListNode A = new ListNode(3);
        A.next = new ListNode(4);
        A.next.next = new ListNode(1);
        A.next.next.next = new ListNode(2);
        ListNode result = a.mergeSort(A);
        System.out.println(a);
    }


    public ListNode mergeSort(ListNode A){
        if(A==null || A.next == null)
            return A;

        ListNode prevSlowPointer = null;
        ListNode slowPointer = A;
        ListNode fastPointer = A;

        while (fastPointer !=null && fastPointer.next !=null){
            prevSlowPointer = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        prevSlowPointer.next = null;

        ListNode firstHalf = mergeSort(A);
        ListNode secondHalf = mergeSort(slowPointer);

        return sortedMerge(firstHalf, secondHalf);
    }

    private static ListNode sortedMerge(ListNode first, ListNode second){
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        ListNode current = temp;
        while(first !=null && second !=null) {

            if (first.val < second.val) {
                current.next = first;
                current = first;
                first = first.next;
            } else {
                current.next = second;
                current = second;
                second = second.next;
            }

        }

        if(first ==null){
            current.next = second;
        }else {
            current.next = first;
        }

        return head.next;
    }
    
}
