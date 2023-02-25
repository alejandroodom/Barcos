import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner teclado = new Scanner(System.in);

        int barcox = random.nextInt(4);
        int barcoy = random.nextInt(4);

        char[][] tablero = new char[4][4];
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                tablero[fila][columna] = '?';
            }
        }

        boolean salir = false;
        int intentos = 0;

        while (!salir) {
            for (int fila = 0; fila < 4; fila++) {
                for (int columna = 0; columna < 4; columna++) {
                    System.out.print(tablero[fila][columna]);
                }
                System.out.println();
            }

            System.out.print("¿Qué columna? \n");
            int columna = teclado.nextInt() - 1;
            System.out.print("¿Qué linea? \n");
            int fila = teclado.nextInt() - 1;

            if (fila == barcox && columna == barcoy) {
                System.out.println("¡Tocado y hundido!");
                salir = true;
            } else {
                if (fila < 0 || fila > 3 || columna < 0 || columna > 3) {
                    System.out.println("Coordenadas incorrectas. Inténtalo de nuevo.");
                } else if (tablero[fila][columna] == 'X' || tablero[fila][columna] == 'O') {
                    System.out.println("Ya has disparado ahí. Inténtalo de nuevo.");
                } else {
                    System.out.println("Agua");
                    tablero[fila][columna] = 'O';
                    intentos++;
                }
            }

            if (salir) {
                System.out.println("Ha ganado");
            }
        }
    }
}
