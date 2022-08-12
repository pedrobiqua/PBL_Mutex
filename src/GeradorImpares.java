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
            
            while (Chave.count < Chave.chave.length - 1) {
                Thread.sleep(1000);
                mutex.acquire(); // esperar
                    int randomIndex = r.nextInt(Chave.listaImpar.size());
                    int temp =  Chave.listaImpar.get(randomIndex);
                    Chave.chave[Chave.count] = temp;
                    Chave.contadorImpar += temp;

                    System.out.println("IMPAR("+ (Chave.count + 1) +"): " + Chave.listaImpar.get(randomIndex));
                    Chave.count++;
                mutex.release(); // sinalizar
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
