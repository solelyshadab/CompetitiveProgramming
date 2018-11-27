package JavaInterviewRelated;

public class MultiThreadingByExtendingThreadClass extends Thread {
    public static void main(String[] args) throws InterruptedException {
        int n = 8; // Number of threads
        for (int i=0; i<8; i++)
        {
            MultiThreadingByExtendingThreadClass thread = new MultiThreadingByExtendingThreadClass();
            thread.start();
            Thread.sleep(1000);
        }

    }

    public void run(){
        try {
            System.out.println(" Thread " + Thread.currentThread().getId() + " is running");
        }
        catch (Exception e){
            System.out.println("Exception occured is " + e);
        }
    }
}
