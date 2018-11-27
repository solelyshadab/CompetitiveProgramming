package InterviewBit.Hashing;
import java.util.*;

public class CopyList {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode current = head;
        RandomListNode copyNode = null;
        while(current !=null){
            copyNode = new RandomListNode(current.label);
            map.put(current, copyNode);
            current = current.next;
        }

        current = head;
        while(current !=null){
            copyNode = map.get(current);

            copyNode.next = map.get(current.next);
            copyNode.random = map.get(current.random);

            current = current.next;
        }

        return map.get(head);
    }

    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }
}
