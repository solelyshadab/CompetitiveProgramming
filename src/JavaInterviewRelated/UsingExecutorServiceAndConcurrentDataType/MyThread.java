package JavaInterviewRelated.UsingExecutorServiceAndConcurrentDataType;

import java.util.Map;

public class MyThread implements Runnable {
    Map<Integer,Integer>  map;
    int startKey;

    public MyThread(Map<Integer,Integer> map, int startKey){
        this.map = map;
        this.startKey = startKey;
    }

    @Override
    public void run(){
        System.out.println("Thread started! " + Thread.currentThread().getId());
        for(int i = startKey; i < startKey+5; i++) {
            map.put(i, i);
        }

        System.out.println("Thread ended!  " + Thread.currentThread().getId());
    }
}
