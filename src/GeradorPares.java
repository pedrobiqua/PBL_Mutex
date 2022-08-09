import java.util.concurrent.Semaphore;

public class GeradorPares extends Thread {
    
    private int [] number;
    private Semaphore mutex;

    public GeradorPares(int[] number, Semaphore mutex) {
        this.number = number;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        // Todo
        
    }

}
