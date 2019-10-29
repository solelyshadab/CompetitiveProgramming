package JavaInterviewRelated.PhilosopherDiningProblem;

public class Philosopher extends Thread {
    private Chopstick left, right;
    private int id;

    public Philosopher(Chopstick left, Chopstick right, int id){
        this.left = left;
        this.right = right;
        this.id = id;
    }

    private void eat(){
        if(pickUpChopsticks()) {
            System.out.println("Starting eating id: " + id);
            chew();
            dropChopsticks();
            System.out.println("Finished eating id: " + id);
        }
    }

    private boolean pickUpChopsticks(){
        if(!left.pickUp()){
            return false;
        }

        if(!right.pickUp()){
            left.drop();
            return false;
        }

        return true;
    }

    private void chew () {

    }

    private void dropChopsticks(){
        right.drop();
        left.drop();
    }

    @Override
    public void run(){
        eat();
    }


    public static void main(String[] args){

        Chopstick left = new Chopstick();
        Chopstick right = new Chopstick();

        for(int i = 0; i < 10 ; i++){
            Thread thread = new Philosopher(left, right, i+1);
            thread.start();
        }
    }

}
