import java.util.Random;
import java.util.concurrent.Semaphore;

public class GeradorImpares extends Thread {
    private Semaphore mutex;
    

    public GeradorImpares(Semaphore mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        //Todo
        try {

            Random r = new Random();
            Random time = new Random();

            while (Contador.getCount() < Chave.chave.length - 1) {
                Thread.sleep(time.nextInt(300 - 100) + 100);
                mutex.acquire(); // esperar
                    int randomIndex = r.nextInt(Chave.listaImpar.size());
                    int temp =  Chave.listaImpar.get(randomIndex);
                    if (Contador.getCount() < Chave.chave.length ) {
                        Chave.chave[Contador.getCount()] = temp;
                        Chave.contadorImpar ++;

                        System.out.println("IMPAR("+ (Contador.getCount() + 1) +"): " + Chave.listaImpar.get(randomIndex));
                        Contador.setCount();
                    }
                mutex.release(); // sinalizar
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
