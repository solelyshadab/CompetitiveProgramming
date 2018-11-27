package InterviewBit.LinkedLists;

public class InsertionSortList {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args){
        InsertionSortList a = new InsertionSortList();
        ListNode A = a.new ListNode(3);
        A.next = a.new ListNode(4);
        A.next.next = a.new ListNode(1);
        A.next.next.next = a.new ListNode(2);
        A.next.next.next.next = a.new ListNode(5);
        //A.next.next.next.next.next = a.new ListNode(6);
    }

    // 3 -> 4 -> 1 ->2 -> 5
    public ListNode insertionSortList(ListNode A) {
        ListNode current = A;
        ListNode next;
        ListNode sorted = null;

        while(current !=null){
            next = current.next;
            sorted = insertNode(sorted, current);
            current = next;

        }
        return sorted;
    }
    // 3 -> 4 -> 1 ->2 -> 5
    private static ListNode insertNode(ListNode sorted, ListNode node){

        if(sorted == null || node.val <= sorted.val  ){
            node.next = sorted;
            sorted = node;
        }
        else{
            ListNode current = sorted;
            while(current.next !=null && current.next.val < node.val){
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }


        return sorted;

    }
}
