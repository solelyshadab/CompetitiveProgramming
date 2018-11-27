package DataStructures;

import java.util.Comparator;

public class PriorityQueueImpl<P> {

    public static void main(String[] arg) {
        PriorityQueueImpl<Node> priorityQueue = new PriorityQueueImpl<>();
        Comparator<Node> comparator = priorityQueue.new MyComparator();
        // Below is Lambda implementation.
        //Comparator<Node> comparator1 = (a, b) -> {if(a.key > b.key) return 1; if(a.key < b.key) return  -1; return 0;};
        java.util.PriorityQueue pq = new java.util.PriorityQueue<>(comparator);
        Node n1 = new Node(12);
        Node n2 = new Node(10);
        Node n3 = new Node(7);
        Node n4 = new Node(11);

        pq.add(n1);
        pq.add(n2);
        pq.add(n3);
        // poll() plucks out the hed of priority queue.
        System.out.println(((Node) pq.poll()).key);
        System.out.println(((Node) pq.poll()).key);
    }

    static class Node {
        int key;
        public Node(int key){
            this.key = key;
        }
    }

    class MyComparator implements Comparator<Node> {

        public int compare(Node a, Node b) {
            // TODO
            if (a.key > b.key) return 1;
            if (a.key < b.key) return -1;
            return 0;
        }
    }

}

