package JavaInterviewRelated.UseMultiThreadToBatchProcess;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerData {
    public Map<Long, Customer> mCustomerList;

    public CustomerData(){
        mCustomerList = new ConcurrentHashMap<>();
    }

}
