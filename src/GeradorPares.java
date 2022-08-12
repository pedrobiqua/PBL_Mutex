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
            Random time = new Random();
            
            while (Contador.getCount() < Chave.chave.length - 1) {
                Thread.sleep(time.nextInt(300 - 100) + 100);
                mutex.acquire(); // esperar
                    int randomIndex = r.nextInt(Chave.listaPar.size());
                    int temp =  Chave.listaPar.get(randomIndex);
                    if (Contador.getCount() < Chave.chave.length ) {
                        Chave.chave[Contador.getCount()] = temp;
                        Chave.contadorPares++;

                        System.out.println("PAR("+ (Contador.getCount() + 1) +"): " + Chave.listaPar.get(randomIndex));
                        Contador.setCount();    
                    }
                    
                mutex.release(); // sinalizar
            }
            


        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
