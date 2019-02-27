package JavaInterviewRelated.UseMultiThreadToBatchProcess;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    private Semaphore semaphore;
    private CustomerData customerData;
    private List<Long> customerIDsToProcess;

    public MyThread(List<Long> customerIDsToProcess, CustomerData customerData,Semaphore semaphore){
        this.customerIDsToProcess = customerIDsToProcess;
        this.semaphore = semaphore;
        this.customerData = customerData;
    }

    public void run(){
        updateAllCustomersInSubBatch(customerIDsToProcess);
    }

    private void updateAllCustomersInSubBatch(List<Long> customerIDsToProcess)
    {
        try
        {
            synchronized (customerData) {
                customerIDsToProcess.forEach(key -> customerData.mCustomerList.get(key).setDiscount());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // The work in this thread is complete. Release the semaphore request
            // so that it can be reused to
            // launch another thread worker for the next batch.
            semaphore.release();
        }
    }
}
