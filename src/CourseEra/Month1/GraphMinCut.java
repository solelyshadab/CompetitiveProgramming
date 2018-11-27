package CourseEra.Month1;

import java.io.File;
import java.util.*;

public class GraphMinCut {
    private HashMap<Integer, List<Integer>> listofVertices = new HashMap<>();

    public static void main(String[] args){

        //Get file from resources folder
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/MinCut_GraphData.txt");

        int minCut = 0;
        for(int i =0; i<100;i++){
            GraphMinCut graphMinCut = new GraphMinCut();
            graphMinCut.getHashMap(file);
            int[] minCutArray = graphMinCut.contractGraph();
            System.out.println("Final cuts are: " + Arrays.toString(minCutArray));
            for(int j = 0; j< minCutArray.length;j++){
                if(minCut==0)
                    minCut = minCutArray[j];
                if(minCutArray[j]< minCut)
                    minCut = minCutArray[j];
            }
        }

        //System.out.println(Arrays.toString(minCutArray));
        System.out.println(minCut);
    }

    private int[] contractGraph(){
        Random random = new Random();
        while(listofVertices.size()>2){
            //int randomUkey = random.nextInt(listofVertices.size()-1) + 1;
            Object[] crunchifyKeys = listofVertices.keySet().toArray();
            Object randomUkey = crunchifyKeys[random.nextInt(crunchifyKeys.length)];
            int randomU = listofVertices.get(randomUkey).get(0);
            List<Integer> UEdges = listofVertices.get(randomU);
            int randomVkey = random.nextInt(UEdges.size()-1)+1;
            int randomV = UEdges.get(randomVkey);

            List<Integer> VEdges = listofVertices.get(randomV);

            for(Integer Vedge : VEdges){
                if(Vedge != randomU && Vedge!= randomV){
                    UEdges.add(Vedge);
                }
            }
            while(UEdges.contains(randomV)) {
                int index = UEdges.indexOf(randomV);
                UEdges.remove(index);
            }

            for(int a = 0; a< crunchifyKeys.length; a++) {
                Object VerticeKey = crunchifyKeys[a];
                List<Integer> Vertice = listofVertices.get(VerticeKey);
                if (Vertice.get(0) == randomV)
                    continue;

                while (Vertice.contains(randomV)) {
                    int V = Vertice.indexOf(randomV);
                    if (V >= 0) {
                        Vertice.remove(V);
                        Vertice.add(randomU);
                    }
                }
            }
            listofVertices.remove(randomV);

        }
        int minCut[] = new int[listofVertices.size()];

        int i =0;
        for (List<Integer> remainingVertices : listofVertices.values()) {
            minCut[i] = remainingVertices.size()-1;
            //System.out.println("Remaining Edges:  " + minCut[i]);
            i++;
        }

        return minCut;

    }


    public void getHashMap(File file){

        try (Scanner scanner = new Scanner(file)) {
            int i = 1;
            while (scanner.hasNextLine()) {

                String vertice = scanner.nextLine();
                LinkedList<Integer> listofEdges = new LinkedList<>();
                listofVertices.put(i, listofEdges);

                for(String edge: vertice.split("\t")){

                    listofEdges.add(Integer.parseInt(edge));
                }
                i++;
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}

