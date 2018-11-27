package JavaInterviewRelated.Synchronization;

public class Sender {
    public void send(String message){
        System.out.println("Sending \t" + message);
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Thread Interrupted");
        }

        System.out.println("\n" + message + "sent!\n");

    }
}
