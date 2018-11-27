package CourseEra.Month3.DynamicProgramming.WeightedIndependentSetsinPathGraphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WeightedIndependentSubTree {
    private int totalVertices;
    private int[] WISArray;
    private int[] verticesWeightArray;
    private ArrayList<Integer> WISVerticesList = new ArrayList<>();

    public static void main(String[] args){
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/WIS_LargeData.txt");
        WeightedIndependentSubTree wis = new WeightedIndependentSubTree();
        wis.readFile(file);
        wis.findMaxWeights();
        wis.findIS();
        System.out.println("Max Weight : " + wis.WISArray[wis.totalVertices]);
        System.out.println("No. of Vertcies to check? ");
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0) {
            System.out.println("enter Vertice No: ");
            int k = in.nextInt();
            if (wis.WISVerticesList.contains(k))
                System.out.println("1");
            else
                System.out.println("0");
            t--;
        }
    }

    private void findIS(){
        int i = totalVertices;
        while(i > 1){
            if(WISArray[i-1] >= WISArray[i-2] + verticesWeightArray[i]){
                i--;
            }
            else {
                WISVerticesList.add(i);
                i = i-2;
            }
        }
        //For Vertice 1, if 2 is not added then 1 must be added.
        if(!WISVerticesList.contains(2))
            WISVerticesList.add(1);
    }

    private void findMaxWeights(){
        WISArray[0] = 0;
        WISArray[1] = verticesWeightArray[1];
        WISLoop();
    }

    private void WISLoop(){
        for(int i = 2; i <= totalVertices; i++){
            WISArray[i] = Math.max(WISArray[i-1],WISArray[i-2] + verticesWeightArray[i]);
        }
    }

    private void readFile(File file){
        try(Scanner scanner = new Scanner(file)){
            totalVertices = scanner.nextInt();
            verticesWeightArray = new int[totalVertices + 1];
            WISArray = new int[totalVertices + 1];
            int i =1;
            while (scanner.hasNext()){
                verticesWeightArray[i] = scanner.nextInt();
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
