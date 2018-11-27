package InterviewBit.LinkedLists;

public class ListCycle {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args){
        ListCycle a = new ListCycle();
        ListNode A = a.new ListNode(3);
        A.next = a.new ListNode(4);
        A.next.next = a.new ListNode(1);
        A.next.next.next = a.new ListNode(2);
        A.next.next.next.next = a.new ListNode(5);
        //A.next.next.next.next.next = a.new ListNode(6);
        //A.next.next.next.next.next.next = A;
        //System.out.println(a.detectCycle(A).val);
    }
    public ListNode detectCycle(ListNode a) {
        if(a==null)
            return null;

        ListNode slowPointer = a;
        ListNode fastPointer = a;

        while(fastPointer !=null && fastPointer.next !=null ){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                fastPointer = a;
                while(fastPointer != slowPointer){
                    fastPointer = fastPointer.next;
                    slowPointer = slowPointer.next;
                }

                return slowPointer;
            }
        }
        return null;


    }


}



