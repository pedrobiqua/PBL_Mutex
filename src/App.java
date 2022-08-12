import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) throws Exception {

        Semaphore mutex = new Semaphore(1);

        var chave = Chave.chave;
        Chave.setListas();

        GeradorImpares t1 = new GeradorImpares( mutex );
        GeradorPares t2 = new GeradorPares( mutex );

        GeradorImpares t3 = new GeradorImpares( mutex );
        GeradorPares t4 = new GeradorPares( mutex );

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            
            t2.join();
            t1.join();
            t3.join();
            t4.join();

            System.out.println("\nQuantidade de impar: " + Chave.contadorImpar);
            System.out.println("Quantidade de par: " + Chave.contadorPares + "\n");

            System.out.println("Numeros do array chave: ");
            for (int i : chave) {
                System.out.print(i + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
