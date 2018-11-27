package CourseEra.Month2.HashTable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class MyHashTable {
    public final int BUCKET_SIZE;
    public LinkedList<Long> bucketArray[];


    public MyHashTable(int BUCKET_SIZE){
        this.BUCKET_SIZE = BUCKET_SIZE;
        bucketArray = new LinkedList[BUCKET_SIZE];

        for(int i = 0; i < BUCKET_SIZE ; i++){
            bucketArray[i] = new LinkedList<>();
        }
    }

    public int hashFunction(long data){
        return (int) Math.abs(data % BUCKET_SIZE);
    }

    public void insertData(long data){
        int key = hashFunction(data);
        bucketArray[key].addFirst(data);
    }

    public boolean isPresent(long data){

        int key = hashFunction(data);
        LinkedList list = bucketArray[key];
        if(list.contains(data))
        return true;
        else
        return false;
    }

    public void deleteData(int data){
        int key = hashFunction(data);
        LinkedList list = bucketArray[key];
        for(int i = 0; i < list.size(); i ++){
            if(list.get(i).equals(data)){
                list.remove(data);
            }
        }
    }


}
