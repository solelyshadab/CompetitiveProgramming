package InterviewBit.LinkedLists;


public class PartitioningList {
    public static void main(String[] args){
        PartitioningList a = new PartitioningList();
        ListNode node = a.new ListNode(10);
        node.next = a.new ListNode(8);
        node.next.next = a.new ListNode(7);
        node.next.next.next = a.new ListNode(3);
        node.next.next.next.next = a.new ListNode(5);
        node.next.next.next.next.next = a.new ListNode(2);
        node.next.next.next.next.next.next = a.new ListNode(3);
        a.printList(node);
        System.out.println();
        ListNode ans = a.partition(node,5);
        a.printList(ans);
    }

    public ListNode partition(ListNode A, int x){
        ListNode sorted = null;
        ListNode current = A;
        ListNode next;

        while(current !=null){
            next = current.next;
            sorted = place1(sorted, current, x);
            current = next;
        }

        return sorted;
    }
    //1->4->3->2->5->2->3->NULL , x = 3
    //1->2->2->3->3->4->5

    //Solution1: TLE exception (I guess because it is O(n^2) solution)
    private ListNode place1(ListNode sorted, ListNode node, int x){
        if(sorted == null || (node.val < x &&  sorted.val >=x) ) {
            node.next = sorted;
            sorted = node;
            return sorted;
        }
        ListNode current = sorted;

        if(node.val < x) {
            while ( current.next !=null && (current.next.val < x || current.next.val <= node.val) ) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;

        }else{
            while (current != null &&  current.next !=null ) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }


        return sorted;
    }

    public void printList(ListNode root){
        while(root !=null){
            String a = root.toString();
            System.out.print(root.val + " " +a.substring(a.length()-10) +" -> ");
            root = root.next;
        }
        System.out.print("NULL");
    }

    //Solution2: Interviewbit solution...
    public ListNode partition2(ListNode A, int B) {

        if(A == null) return null;
        ListNode head = new ListNode(0);
        ListNode secondHead = new ListNode(0);
        head.next = A;

        ListNode current = A;
        ListNode prev = head;
        ListNode secondCurrent = secondHead;

        while(current != null){
            if(current.val < B){
                current = current.next;
                prev = prev.next;
            }else{

                secondCurrent.next = current;
                prev.next = current.next;

                current = prev.next;
                secondCurrent = secondCurrent.next;
            }
        }

        // close the list
        secondCurrent.next = null;

        prev.next = secondHead.next;

        return head.next;
    }

    //This solution is for the usecase where all nodes < x first, then all nodes with x values
    // and then all nodes greater than x...
    private ListNode place(ListNode sorted, ListNode node, int x){
        if(sorted == null || (node.val <x &&  sorted.val >=x) || (node.val == x && sorted.val > x) ) {
            node.next = sorted;
            sorted = node;
            return sorted;
        }
        ListNode current = sorted;
        if(node.val==x){
            while ( current.next !=null && current.next.val <= x  ) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
        else if(node.val < x) {
            while ( current.next !=null && current.next.val < x  ) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;

        }else{
            while (current != null &&  current.next !=null ) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }


        return sorted;
    }


    class ListNode{
        ListNode next;
        int val;

        public ListNode(int val){
            this.val = val;
        }
    }

}

