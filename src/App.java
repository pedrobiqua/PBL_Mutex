import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) throws Exception {
        int[] chave = new int[100];
        Semaphore mutex = new Semaphore(1);

        GeradorImpares t1 = new GeradorImpares( chave, mutex );
        GeradorPares t2 = new GeradorPares( chave, mutex );

        t1.start();
        t2.start();
    }
}
