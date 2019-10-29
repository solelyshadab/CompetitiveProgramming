package InterviewBit.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by 609112524 on 30/04/2019.
 */
public class BoxStacking {
    public static void main(String[] args){
        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);

        System.out.println("The maximum possible "+
                "height of stack is " +
                maxHeight(arr,4));

    }

    public static int maxHeight(Box[] boxes, int n){

        Box[] rotBoxes = new Box[n * 3];

        for(int i = 0; i < n; i++){
            Box box = boxes[i];

            rotBoxes[3*i] = new Box(box.h, Math.max(box.w, box.d), Math.min(box.w, box.d));
            rotBoxes[3*i +1] = new Box(box.w, Math.max(box.h, box.d), Math.min(box.h, box.d));
            rotBoxes[3*i +2] = new Box(box.d, Math.max(box.h, box.w), Math.min(box.h, box.w));
        }

        Arrays.sort(rotBoxes, Comparator.comparing(Box::getArea).reversed());

        int[] lis = new int[rotBoxes.length];

        for(int i =0; i < lis.length; i++){
            lis[i] = rotBoxes[i].h;
        }

        for(int i = 0; i < rotBoxes.length; i++){

            for(int j = 0; j < i ; j++){
                if( rotBoxes[j].d > rotBoxes[i].d && rotBoxes[j].w > rotBoxes[i].w
                        && lis[j] + rotBoxes[i].h > lis[i]){
                    lis[i] = lis[j] + rotBoxes[i].h;
                }
            }
        }

        int max = -1;
        for(int i = 0; i < lis.length; i++){
            max = Math.max(max, lis[i]);
        }

        return max;
    }

    static class Box{
        int h; int w; int d; int area;
        public Box(int h, int w, int d){
            this.h = h;
            this.w = w;
            this.d = d;
            area = w * d;
        }

        public int getArea(){
            return area;
        }
    }
}
