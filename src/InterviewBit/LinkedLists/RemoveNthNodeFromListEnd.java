package InterviewBit.LinkedLists;

public class RemoveNthNodeFromListEnd {
    public static void main(String[] args){
        RemoveNthNodeFromListEnd a = new RemoveNthNodeFromListEnd();
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        ListNode ans = a.solve(A,0);
        printList(ans);

    }
    // 1-> 2-> 3-> 4-> 5 -> NULL, 2
    public ListNode solve(ListNode A, int B){
        if(A==null)
            return A;

        int size = 0;
        ListNode current = A;
        while(current !=null){
            current = current.next;
            size++;
        }

        int rem = size - B;

        if(rem <=0)
            return A.next;

        current = A;
        while(rem>1){
            current = current.next;
            rem--;
        }

        current.next = current.next.next;

        return A;
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
