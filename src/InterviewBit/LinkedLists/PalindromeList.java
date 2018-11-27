package InterviewBit.LinkedLists;

public class PalindromeList {

      class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
      }

        public int lPalin(ListNode A) {
            if(A.next == null)
                return 1;
            ListNode slow_ptr = A;
            ListNode fast_ptr = A;
            ListNode prev_to_slow_ptr = A;
            ListNode midNode = null;
            ListNode secondHalfHead = null;

            while(fast_ptr !=null && fast_ptr.next !=null){
                prev_to_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
                fast_ptr = fast_ptr.next.next;
            }
            // 1 -> 2 -> 3 -> 4
            if(fast_ptr !=null){
                midNode = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
            secondHalfHead = slow_ptr;
            prev_to_slow_ptr.next = null;

            secondHalfHead = reverse(secondHalfHead);
            return isPalindrome(A, secondHalfHead );

        }

        private static int isPalindrome(ListNode first, ListNode second){

            ListNode temp1 = first;
            ListNode temp2 = second;

            while(temp1 !=null && temp2 !=null){
                if(temp1.val == temp2.val){
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }else{
                    return 0;
                }
            }

            if(temp1 ==null && temp2 ==null){
                return 1;
            }

            return 0;
        }

        private static ListNode reverse(ListNode head){
            ListNode previous = null;
            ListNode current = head;
            ListNode next = null;

            while(current !=null){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            return previous;
        }
    }

