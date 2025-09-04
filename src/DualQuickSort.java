public class DualQuickSort {
    public static void dualQuickSort (int[] vector){
        dualQuickSort(vector,0,vector.length-1);
    }

    private static void dualQuickSort (int[] vector, int inicio, int fin){
        if (inicio < fin) {
            int[] pivotes = particionar(vector, inicio, fin);
            int indicePivote1 = pivotes[0];
            int indicePivote2 = pivotes[1];

            dualQuickSort(vector, inicio, indicePivote1 - 1);
            dualQuickSort(vector, indicePivote1 + 1, indicePivote2 - 1);
            dualQuickSort(vector, indicePivote2 + 1, fin);
        }
    }

    private static int[] particionar(int[] vector, int inicio, int fin) {
        if (vector[inicio] > vector[fin]){
            intercambiar(vector,inicio,fin);
        }

        int pivoteInicio = vector[inicio];
        int pivoteFin = vector[fin];

        int barridoInferior = inicio + 1;
        int barridoMedio = inicio + 1;
        int barridoSuperior = fin - 1;


        while (barridoMedio <= barridoSuperior) {
            if (vector[barridoMedio] < pivoteInicio) {
                intercambiar(vector, barridoMedio++, barridoInferior++);
            } else if (vector[barridoMedio] > pivoteFin) {
                intercambiar(vector, barridoMedio, barridoSuperior--);
            } else {
                barridoMedio++;
            }
        }

        intercambiar(vector, inicio, --barridoInferior);
        intercambiar(vector, fin, ++barridoSuperior);

        return new int[]{barridoInferior, barridoSuperior};
    }

    private static void intercambiar (int[] vector, int primero, int segundo){
        int aux = vector[primero];
        vector[primero] = vector [segundo];
        vector[segundo] = aux;
    }
}