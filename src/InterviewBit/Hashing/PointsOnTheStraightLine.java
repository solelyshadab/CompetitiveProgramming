package InterviewBit.Hashing;
import java.util.*;

public class PointsOnTheStraightLine {
    public static void main(String[] args){
        PointsOnTheStraightLine a = new PointsOnTheStraightLine();
        ArrayList<Integer> X = new ArrayList<>(Arrays.asList(4,8,-4));
        ArrayList<Integer> Y = new ArrayList<>(Arrays.asList(-4,-4,-4));
        System.out.println(a.maxPoints(X,Y));
    }
    //3 4 -4 8 -4 -4 -4
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        Map<Double, Integer> map = new HashMap<>();
        int maxPoint = 0;
        int duplicates; int verticals;
        for(int i = 0; i < a.size(); i++){

            duplicates = 1; verticals = 0;
            int x1 = a.get(i);
            int y1 = b.get(i);
            for(int j = i+1; j< a.size(); j++){
                int x2 = a.get(j);
                int y2 = b.get(j);

                if(x1 ==x2){
                    if(y1 == y2){
                        duplicates++;
                    }else{
                        verticals++;
                    }
                }else{
                    double slope;

                    if(y1==y2){
                        slope = 0.0;
                    }
                    else{
                        slope = (double) (y2 - y1) / (double)(x2-x1);
                    }
                    if(map.containsKey(slope)){
                        map.put(slope, map.get(slope) + 1);
                    }else{
                        map.put(slope, 1);
                    }
                }

            }
            // After every inner loop
            for(Integer slopeCount: map.values()){
                maxPoint = Math.max(maxPoint, slopeCount + duplicates);
            }
            maxPoint = Math.max(maxPoint, verticals + duplicates);
            map.clear();
        }

        return maxPoint;
    }
}
