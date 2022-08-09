import java.util.concurrent.Semaphore;

public class GeradorImpares extends Thread {
    private int [] number;
    private Semaphore mutex;

    public GeradorImpares(int[] number, Semaphore mutex) {
        this.number = number;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        //Todo
        
    }
}
