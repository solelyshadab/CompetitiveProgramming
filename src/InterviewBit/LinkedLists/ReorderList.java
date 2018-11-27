package InterviewBit.LinkedLists;

public class ReorderList {
    public static void main(String[] args){
        ReorderList a = new ReorderList();
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        //A.next.next.next.next = new ListNode(5);
        a.printList(a.reorder(A));
    }
    //Input:  1 -> 2 -> 3 -> 4 -> 5
    // 1 -> 2 -> 3 -> NULL
    // 5 -> 4 -> NULL
    //Output: 1 -> 5 -> 2 -> 4 -> 3
    public ListNode reorder(ListNode A){
        ListNode slow = A;
        ListNode fast = A;

        while(fast !=null && fast.next !=null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        secondHalf = reverse(secondHalf);

        ListNode currFirst = A;
        ListNode currSecond = secondHalf;
        ListNode nextFirst;
        ListNode nextSecond;
        while(currFirst !=null && currSecond !=null){
            nextFirst = currFirst.next;
            nextSecond = currSecond.next;
            currFirst.next = currSecond;
            currSecond.next = nextFirst;

            currFirst = currFirst.next.next;
            currSecond = nextSecond;
        }

        return A;
    }

    private ListNode reverse(ListNode head){
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while(current !=null){
            next = current.next;
            current.next = previous;
            previous = current;

            current = next;
        }

        return previous;
    }


    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    private void printList(ListNode A){
        ListNode current = A;

        while(current !=null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("NULL");

    }
}
