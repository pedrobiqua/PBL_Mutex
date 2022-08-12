import java.util.ArrayList;

public class Chave {
    public static int[] chave = new int[30];
    public static int count = 0;

    public static ArrayList<Integer> listaPar = new ArrayList<Integer>();
    public static ArrayList<Integer> listaImpar = new ArrayList<Integer>();

    public static int contadorPares = 0;
    public static int contadorImpar = 0;

    public static void setListas() {
        listaPar.add(0);
        listaPar.add(2);
        listaPar.add(4);
        listaPar.add(6);
        listaPar.add(8);

        listaImpar.add(1);
        listaImpar.add(3);
        listaImpar.add(5);
        listaImpar.add(7);
        listaImpar.add(9);
    }
}
