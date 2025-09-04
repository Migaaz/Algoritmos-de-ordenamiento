public class QuickSort {
    public static void quickSort (int[] vector){
        quickSort(vector,0,vector.length-1);
    }

    private static void quickSort (int[] vector, int inicio, int fin){
        if (inicio < fin) {
            int indicePivote = particionar(vector, inicio, fin);
            quickSort(vector, inicio, indicePivote - 1);
            quickSort(vector, indicePivote + 1, fin);
        }
    }

    private static int particionar(int[] vector, int inicio, int fin) {
        int pivote = vector[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (vector[j] <= pivote) {
                intercambiar(vector, ++i, j);
            }
        }

        intercambiar(vector, ++i , fin);
        return i;
    }

    private static void intercambiar (int[] vector, int primero, int segundo){
        int aux = vector[primero];
        vector[primero] = vector [segundo];
        vector[segundo] = aux;
    }
}