public class QuickSort {
    public static void quickSort (int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort (int[] arr, int inicio, int fin){
        if (inicio < fin) {
            int indicePivote = particionar(arr, inicio, fin);
            quickSort(arr, inicio, indicePivote - 1);
            quickSort(arr, indicePivote + 1, fin);
        }
    }

    private static int particionar(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                intercambiar(arr, ++i, j);
            }
        }

        intercambiar(arr, ++i , fin);
        return i;
    }

    private static void intercambiar (int[] arr, int primero, int segundo){
        int aux = arr[primero];
        arr[primero] = arr [segundo];
        arr[segundo] = aux;
    }
}