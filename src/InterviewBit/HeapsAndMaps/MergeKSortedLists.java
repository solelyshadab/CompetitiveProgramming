package InterviewBit.HeapsAndMaps;

import java.util.*;

public class MergeKSortedLists {
    public static void main(String[] args){
        MergeKSortedLists a = new MergeKSortedLists();
        ListNode A = a.new ListNode(1);
        A.next = a.new ListNode(3);A.next.next = a.new ListNode(5);A.next.next.next = a.new ListNode(7);
        ListNode B = a.new ListNode(2);
        B.next = a.new ListNode(4);B.next.next = a.new ListNode(6);B.next.next.next = a.new ListNode(8);
        ListNode C = a.new ListNode(0);
        C.next = a.new ListNode(9);C.next.next = a.new ListNode(10);C.next.next.next = a.new ListNode(11);
        ListNode ans = a.merge(new ArrayList<>(Arrays.asList(A,B,C)));
        while(ans.next !=null) {
            System.out.print(ans.val + " ");
            ans = ans.next;

        }
    }

    public ListNode merge(ArrayList<ListNode> A){
        if (A ==null || A.size()==0)
            return null;

        ListNode head = new ListNode(0);
        ListNode current = head;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for(int i = 0; i < A.size(); i++){
        if(A.get(i) !=null)
            priorityQueue.add(A.get(i));
        }

        while(!priorityQueue.isEmpty()){
            ListNode top = priorityQueue.poll();
            current.next = top;
            current = current.next;

            if(top.next !=null){
                priorityQueue.add(top.next);
            }
        }

        return head.next;
    }

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

}
