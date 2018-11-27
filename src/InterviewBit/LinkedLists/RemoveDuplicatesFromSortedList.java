package InterviewBit.LinkedLists;

public class RemoveDuplicatesFromSortedList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args){
        RemoveDuplicatesFromSortedList a = new RemoveDuplicatesFromSortedList();

        //1-> 1 -> 1 -> 2 -> 3 -> 3 -> null
    }

    public ListNode solution(ListNode A){

        ListNode current = A;
        ListNode next_next;
        while(current !=null){

            if (current.next !=null && current.val == current.next.val){
                next_next = current.next.next;
                current.next = null;
                current.next = next_next;

            }else {
                current = current.next;
            }

        }

        return A;
    }



}
