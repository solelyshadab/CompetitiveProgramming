package JavaInterviewRelated.UsingExecutorServiceAndConcurrentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args){
        Map<Integer,Integer> map = new ConcurrentHashMap<>();
        List<Runnable> myThreadList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        int multiplier = 0;
        for(int i =0; i < 5; i++){
            Thread myThread = new Thread(new MyThread(map, multiplier));
            myThreadList.add(myThread);
            multiplier += 5;
        }

        myThreadList.forEach(executorService::execute);

//        myThreadList.forEach( myThread -> {
//            try {
//                myThread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        map.values().forEach(System.out::println);

        executorService.shutdown();
    }
}
