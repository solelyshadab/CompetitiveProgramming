package InterviewBit.Arrays;

import java.util.*;

public class MergeOverlappingIntervals {

    public static void main(String[] args){
        ArrayList<Interval> intervals = new ArrayList<>();
        MergeOverlappingIntervals a = new MergeOverlappingIntervals();
        Interval interval1 = new Interval(1,10);
        Interval interval2 = new Interval(2,9);
        Interval interval3 = new Interval(3,8);
        Interval interval4 = new Interval(4,7);
        Interval interval5 = new Interval(5,6);
        Interval interval6 = new Interval(6,6);

       intervals.add(interval3);intervals.add(interval1);
       intervals.add(interval4);intervals.add(interval2);
       intervals.add(interval5);intervals.add(interval6);
       System.out.println(Arrays.toString(a.merge(intervals).toArray()));
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
       ArrayList<Interval> ansList = new ArrayList<>();

        Comparator<Interval> comparator = (a, b) -> {if(a.start > b.start) return 1; if(a.start < b.start) return  -1; return 0;};
       Collections.sort(intervals,comparator);

       ansList.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start <= ansList.get(ansList.size()-1).end){
                if(ansList.get(ansList.size()-1).end < intervals.get(i).end)
                ansList.get(ansList.size()-1).end = intervals.get(i).end;
            }
            else {
                ansList.add(intervals.get(i));
            }
        }

       return ansList;

    }

    public static class Interval {
     int start;
      int end;
      Interval() { start = 0; end = 0; }
     Interval(int s, int e) {
          start = s; end = e;
      }
 }
}
