package InterviewBit.HeapsAndMaps;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache a = new LRUCache(1);
        a.set(2,1); a.printCache();
        System.out.println(a.get(2)); a.printCache();
        a.set(3,2); a.printCache();
        System.out.println(a.get(2)); a.printCache();
        System.out.println(a.get(3)); a.printCache();
        //a.set(1,1); a.printCache();
        //a.set(4,1); a.printCache();
        //System.out.println(a.get(2)); a.printCache();

    }

    int capacity;
    Node head;
    Node end;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        end = null;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            removeNode(temp);
            setHead(temp);
            return temp.val;

        }else
            return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            removeNode(oldNode);
            oldNode.val = value;
            setHead(oldNode);
        }else{
            Node newNode = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                removeNode(end);
            }

            setHead(newNode);
            map.put(key, newNode);
        }
    }

    private void setHead(Node node){
        node.next = head;
        node.prev = null;

        if(head !=null)
            head.prev = node;

        head = node;

        if(end ==null)
            end = head;
    }


    private void removeNode(Node node){
        if(node.prev !=null){
            node.prev.next = node.next;
        }else{
            head = node.next;
            //head.prev = null;
        }

        if(node.next !=null){
            node.next.prev = node.prev;
        }else{
            end = node.prev;
            //end.next = null;
        }

    }


    class Node{
        Node prev;
        Node next;
        int key;
        int val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            prev = next = null;
        }
    }

    private void printCache(){
        Node current = head;
        while(current !=null){
            System.out.print(current.val + " ->");
            current = current.next;
        }
        System.out.println();
    }
}
