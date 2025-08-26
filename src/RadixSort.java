public class RadixSort {
    public static void radixSort(int[] arr) {
        int valorMaximo = valorMaximo(arr);

        for (int exp = 1; valorMaximo/exp >= 1; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] arr, int exponente) {
        int[] aux = new int[arr.length];
        int[] repeticionDigito = new int[10];

        for (int valor : arr) {
            int digito = ((valor / exponente) % 10);
            repeticionDigito[digito]++;
        }

        for (int i = 1; i < 10; i++) {
            repeticionDigito[i] += repeticionDigito[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int digito = ((arr[i] / exponente) % 10);
            aux[repeticionDigito[digito] - 1] = arr[i];
            repeticionDigito[digito]--;
        }

        System.arraycopy(aux, 0, arr, 0, arr.length);
    }

    private static int valorMaximo(int[] arr) {
        int valorMax = arr[0];

        for (int numeroArr : arr) {
            if (numeroArr > valorMax) {
                valorMax = numeroArr;
            }
        }

        return valorMax;
    }
}