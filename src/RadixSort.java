// T(n) = O(n k) --> n = numero de elementos del vector, k = longitud del valor maximo
// Espacio adicional = O(n)
// Estable
public class RadixSort {
    public static void radixSort(int[] vector) {
        int valorMaximo = valorMaximo(vector);

        for (int exp = 1; valorMaximo/exp >= 1; exp *= 10) {
            countingSort(vector, exp);
        }
    }

    private static void countingSort(int[] vector, int exponente) {
        int[] aux = new int[vector.length];
        int[] repeticionDigito = new int[10];

        for (int valor : vector) {
            int digito = ((valor / exponente) % 10);
            repeticionDigito[digito]++;
        }

        for (int i = 1; i < 10; i++) {
            repeticionDigito[i] += repeticionDigito[i - 1];
        }

        for (int i = vector.length - 1; i >= 0; i--) {
            int digito = ((vector[i] / exponente) % 10);
            aux[repeticionDigito[digito] - 1] = vector[i];
            repeticionDigito[digito]--;
        }

        System.arraycopy(aux, 0, vector, 0, vector.length);
    }

    private static int valorMaximo(int[] vector) {
        int valorMax = vector[0];

        for (int numeroVector : vector) {
            if (numeroVector > valorMax) {
                valorMax = numeroVector;
            }
        }

        return valorMax;
    }
}