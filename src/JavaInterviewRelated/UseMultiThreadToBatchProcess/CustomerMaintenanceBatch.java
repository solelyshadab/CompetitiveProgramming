package JavaInterviewRelated.UseMultiThreadToBatchProcess;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

 class CustomerMaintenanceBatch {
    // Shared collection, containing all the objects to update
    private CustomerData customerData = new CustomerData();
    private int mMaxNumberOfThreadsPerCpu = 5;
    private int numberOfCpus = Runtime.getRuntime().availableProcessors();
    private int numberOfThreadsToUse = numberOfCpus * mMaxNumberOfThreadsPerCpu;
    private static int NTHREADS = 20;
    private static final Executor executor = Executors.newFixedThreadPool(NTHREADS);
    private List<Thread> threadList = new ArrayList<>();


    public void UpdateAllCustomersInConcurrentBatches()
    {
        System.out.println("cpus: " + numberOfCpus);
        // This will create a semaphore that helps control as many thread launches as we need to.
        Semaphore mSemaphore = new Semaphore(numberOfThreadsToUse);

        CustomerIDList allCustomerIDs = new CustomerIDList(customerData.mCustomerList.keySet());

        while (allCustomerIDs.size() > 0)
        {
            // make of list of customer IDs to process in the next batch
            int batchSize = 50;
            List<Long> customerIDsToProcess = allCustomerIDs.subList(0,
                    Math.min(batchSize, allCustomerIDs.size()));
            // remove those customer IDs from the master list so they are not processed again
            allCustomerIDs.removeRange(0, Math.min(batchSize, allCustomerIDs.size()));

            // wait for the semaphore to let us launch another thread
            try {
                mSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // launch a thread worker and give it the list of customer IDs to process
            MyThread myThread = new MyThread(customerIDsToProcess, customerData,mSemaphore);
            threadList.add(myThread);
            executor.execute(myThread);
        }

        // ensure all threads have exited by waiting until we can get all
        // the semaphore requests
        for (int ctr = 0; ctr < numberOfThreadsToUse; ctr++)
        {
            try {
                mSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mSemaphore.release(numberOfThreadsToUse);
    }

    public void loadMap(){

        for(int i = 0 ; i < 200; i++){
            Customer customer = new Customer(i, 20 );
            customerData.mCustomerList.put( (long) i, customer);
        }
    }

    public void printDiscount(){
        for(Customer customer : customerData.mCustomerList.values()){
            System.out.println("Customer ID: " + customer.getCustomerID() + " Discount: " + customer.getDiscount());
        }
    }

}
