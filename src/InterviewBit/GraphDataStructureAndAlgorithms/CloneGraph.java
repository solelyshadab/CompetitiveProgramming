package InterviewBit.GraphDataStructureAndAlgorithms;
import java.util.*;

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();

        queue.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        while(!queue.isEmpty()){
            UndirectedGraphNode nextNode = queue.poll();

            List<UndirectedGraphNode> neighbors = nextNode.neighbors;


            for(UndirectedGraphNode tempNode : neighbors){

                if(map.get(tempNode) == null){
                    UndirectedGraphNode newCloneNode = new UndirectedGraphNode(tempNode.label);

                    queue.add(tempNode);
                    map.put(tempNode, newCloneNode);
                }

                map.get(nextNode).neighbors.add(map.get(tempNode));
            }

        }

        return map.get(node);

    }
    class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) {
         label = x;
         neighbors = new ArrayList<>();
     }
  }
}
