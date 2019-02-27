package JavaInterviewRelated.UseMultiThreadToBatchProcess;

public class BatchProcessDemo {
    public static void main(String[] args){

        CustomerMaintenanceBatch customerMaintenanceBatch = new CustomerMaintenanceBatch();
        customerMaintenanceBatch.loadMap();
        System.out.println("Before processing: \n");
        customerMaintenanceBatch.printDiscount();
        customerMaintenanceBatch.UpdateAllCustomersInConcurrentBatches();
        System.out.println("\nAfter processing: \n");

        customerMaintenanceBatch.printDiscount();
    }
}
