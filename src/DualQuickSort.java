public class DualQuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,0,2,7,9};
        dualQuickSort(arr);

    }

    public static void dualQuickSort (int[] arr){
        dualQuickSort(arr,0,arr.length-1);
    }

    private static void dualQuickSort (int[] arr, int inicio, int fin){
        if (inicio < fin) {
            int[] pivotes = particionar(arr, inicio, fin);
            int indicePivote1 = pivotes[0];
            int indicePivote2 = pivotes[1];

            dualQuickSort(arr, inicio, indicePivote1 - 1);
            dualQuickSort(arr, indicePivote1 + 1, indicePivote2 - 1);
            dualQuickSort(arr, indicePivote2 + 1, fin);
        }
    }

    private static int[] particionar(int[] arr, int inicio, int fin) {
        if (arr[inicio] > arr[fin]){
            intercambiar(arr,inicio,fin);
        }

        int pivoteInicio = arr[inicio];
        int pivoteFin = arr[fin];

        int barridoInferior = inicio + 1;
        int barridoMedio = inicio + 1;
        int barridoSuperior = fin - 1;


        while (barridoMedio <= barridoSuperior) {
            if (arr[barridoMedio] < pivoteInicio) {
                intercambiar(arr, barridoMedio++, barridoInferior++);
            } else if (arr[barridoMedio] > pivoteFin) {
                intercambiar(arr, barridoMedio, barridoSuperior--);
            } else {
                barridoMedio++;
            }
        }

        intercambiar(arr, inicio, --barridoInferior);
        intercambiar(arr, fin, ++barridoSuperior);

        return new int[]{barridoInferior, barridoSuperior};
    }

    private static void intercambiar (int[] arr, int primero, int segundo){
        int aux = arr[primero];
        arr[primero] = arr [segundo];
        arr[segundo] = aux;
    }
}