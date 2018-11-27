package InterviewBit.LinkedLists;

public class RotateList {
    public static void main(String[] args){
        RotateList a = new RotateList();
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        printList(a.rotate(A,5));
    }
    //1->2->3->4->5->NULL, K=2
    public ListNode rotate(ListNode A, int B){

        if(A==null || B==0)
            return A;

        int size = 0;
        ListNode current = A;
        ListNode prev=null;
        while(current !=null){
            size++;
            prev = current;
            current = current.next;
        }
        if(B ==size || size == 1)
            return A;

        B = B % (size);
        if(B ==size || B == 0)
            return A;

        current = A;
        while(size-B > 1){
            size--;
            current = current.next;
        }

        ListNode head = current.next;
        current.next = null;
        if(prev !=null)
            prev.next = A;

        return head;
    }

    static class ListNode {
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
