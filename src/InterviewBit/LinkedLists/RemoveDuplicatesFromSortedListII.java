package InterviewBit.LinkedLists;


public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args){
        RemoveDuplicatesFromSortedListII a = new RemoveDuplicatesFromSortedListII();
        ListNode A = a.new ListNode(1);
        A.next = a.new ListNode(2);
        A.next.next = a.new ListNode(1);
        A.next.next.next = a.new ListNode(2);
        A.next.next.next.next = a.new ListNode(2);
        A.next.next.next.next.next = a.new ListNode(5);
        A.next.next.next.next.next.next = a.new ListNode(5);
        printList(a.solve(A));
    }
    // 1->1->1->2->5
    public ListNode solve(ListNode A){
        ListNode head = new ListNode(0);
        ListNode prev = head;
        ListNode current =A;

        while(current!=null){
            if(current.next !=null && current.val == current.next.val){
                while(current.next !=null && current.val == current.next.val){
                    current = current.next;
                }
            }else {
                prev.next = current;
                prev = prev.next;
            }
            current = current.next;
        }
        prev.next = null;
        return head.next;
    }

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static void printList(ListNode root){
        while(root !=null){
            System.out.print(root.val +" -> ");
            root = root.next;
        }
        System.out.print("NULL");
    }
}
