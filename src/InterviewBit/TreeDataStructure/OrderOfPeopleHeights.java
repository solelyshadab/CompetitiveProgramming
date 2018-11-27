package InterviewBit.TreeDataStructure;
import java.util.*;

class OrderOfPeopleHeights{
    public static void main(String[] args){
        OrderOfPeopleHeights a = new OrderOfPeopleHeights();
        ArrayList<Integer> heights = new ArrayList<>(Arrays.asList(5,3,2,6,1,4));
        ArrayList<Integer> infronts = new ArrayList<>(Arrays.asList(0,1,2,0,3,2));
        System.out.println(a.correctOrder(heights,infronts));
    }

public ArrayList<Integer> correctOrder(ArrayList<Integer> heights, ArrayList<Integer> infronts){
    PriorityQueue<People> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> a.height));
    Integer[] ansArray = new Integer[heights.size()];
    Arrays.fill(ansArray,-1);

    for(int i =0; i < heights.size(); i++){
    People people = new People(heights.get(i), infronts.get(i));
    priorityQueue.add(people);
    }

    while(!priorityQueue.isEmpty()){
        int count =0;
        People people = priorityQueue.poll();
        int i =0;
        while(i < ansArray.length) {
            if (count == people.infronts) {
                while (ansArray[i] != -1 && i < ansArray.length) {
                    i++;
                }
                ansArray[i] = people.height;
                break;
            }
            if (ansArray[i] == -1) {
                count++;
            }
            i++;
        }
    }

    return new ArrayList<>(Arrays.asList(ansArray));
}
    class People{
    int height;
    int infronts;
    public People(int height, int infronts){
    this.height = height;
    this.infronts = infronts;
    }
    }
}