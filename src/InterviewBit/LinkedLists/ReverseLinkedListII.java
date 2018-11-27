package InterviewBit.LinkedLists;

public class ReverseLinkedListII {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args){
        ReverseLinkedListII a = new ReverseLinkedListII();
        ListNode A = a.new ListNode(1);
        A.next = a.new ListNode(2);
        A.next.next = a.new ListNode(3);
        A.next.next.next = a.new ListNode(4);
        A.next.next.next.next = a.new ListNode(5);
        A.next.next.next.next.next = a.new ListNode(6);
        a.solution(A,0,4);
    }

//    Input: 1->  2->3->4->  5->NULL, m = 2, n = 4
//    Output: 1->4->3->2->5->NULL
    public ListNode solution(ListNode A, int B, int C){
        // divide the list into 3 parts
        ListNode current = A;
        ListNode firstPartEnd = null;
        ListNode reversePartHead = null;
        ListNode SecondPartHead = null;
        int count = 1;

        while(current !=null){
            if(count == B-1){
                firstPartEnd = current;
            }
            if(count == C){
                SecondPartHead = current.next;
                current.next = null;
            }
            count++;
            current = current.next;
        }

        if(firstPartEnd !=null){
            reversePartHead = firstPartEnd.next;
            current = firstPartEnd.next;
        }
        else{
            reversePartHead = A;
            current = A;
        }
        // reverse the middle part
        ListNode next = null;
        ListNode previous = null;
        while(current !=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // Join back the parts
        if(firstPartEnd !=null){
            firstPartEnd.next = previous;
        }
        else{
            A = previous;
        }
        if(reversePartHead !=null){
            reversePartHead.next = SecondPartHead;
        }
        return A;
    }
}
