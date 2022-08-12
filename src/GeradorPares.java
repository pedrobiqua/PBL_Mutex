import java.util.Random;
import java.util.concurrent.Semaphore;

public class GeradorPares extends Thread {
    private Semaphore mutex;
    

    public GeradorPares(Semaphore mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        // Todo
        try {

            Random r = new Random();
            
            while (Chave.count < Chave.chave.length - 1) {
                Thread.sleep(3000);
                mutex.acquire(); // esperar
                    int randomIndex = r.nextInt(Chave.listaPar.size());
                    int temp =  Chave.listaPar.get(randomIndex);
                    Chave.chave[Chave.count] = temp;
                    Chave.contadorPares += temp;

                    System.out.println("PAR("+ (Chave.count + 1) +"): " + Chave.listaPar.get(randomIndex));
                    Chave.count++;
                mutex.release(); // sinalizar
            }
            


        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
