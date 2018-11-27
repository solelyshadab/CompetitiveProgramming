package InterviewBit.LinkedLists;

public class AddTwoNumbersAsLists {
    public static void main(String[] args){
        AddTwoNumbersAsLists a = new AddTwoNumbersAsLists();
        ListNode A = new ListNode(3);
        A.next = new ListNode(4);
        A.next.next = new ListNode(2);

        ListNode B = new ListNode(4);
        B.next = new ListNode(6);
        B.next.next = new ListNode(5);

        printList(a.solve(A,B));
    }

    public ListNode solve(ListNode A, ListNode B){
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry =0; int sum;

        while(A !=null || B !=null){

            sum = (A == null ? 0 : A.val) + (B ==null ? 0 : B.val) + carry;

            carry = sum >=10 ? 1 : 0;

            sum = sum % 10;

            current.next = new ListNode(sum);
            current = current.next;

            if(A !=null)
                A = A.next;

            if(B !=null)
                B = B.next;

        }

        if(carry > 0)
            current.next = new ListNode(carry);


        return result.next;
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
