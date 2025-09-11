public class AlgoritmosPorDivideYVenceras {

    // T(n) = O(n log n)
    // Espacio adicional = O(n)
    // Estable
    public static void quickSort(int[] vector) {
        quickSort(vector, 0, vector.length - 1);
    }

    private static void quickSort(int[] vector, int inicio, int fin) {
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

        intercambiar(vector, ++i, fin);
        return i;
    }

    private static void intercambiar(int[] vector, int primero, int segundo) {
        int aux = vector[primero];
        vector[primero] = vector[segundo];
        vector[segundo] = aux;
    }

    // T(n) = O(n log n) - O(n²)
    // Espacio adicional = O(log n)
    // No estable
    public static void dualQuickSort(int[] vector) {
        dualQuickSort(vector, 0, vector.length - 1);
    }

    private static void dualQuickSort(int[] vector, int inicio, int fin) {
        if (inicio < fin) {
            int[] pivotes = particionarDual(vector, inicio, fin);
            int indicePivote1 = pivotes[0];
            int indicePivote2 = pivotes[1];

            dualQuickSort(vector, inicio, indicePivote1 - 1);
            dualQuickSort(vector, indicePivote1 + 1, indicePivote2 - 1);
            dualQuickSort(vector, indicePivote2 + 1, fin);
        }
    }

    private static int[] particionarDual(int[] vector, int inicio, int fin) {
        if (vector[inicio] > vector[fin])
            intercambiar(vector, inicio, fin);


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

    // T(n) = O(n log n)
    // Espacio adicional = O(n)
    // Estable
    public static void mergeSort(int[] vector){
        if (vector.length > 1){
            int posicionMitadVector = vector.length / 2;

            int[] izquierda = new int[posicionMitadVector];
            int[] derecha = new int[vector.length-posicionMitadVector];

            for (int i = 0; i < posicionMitadVector; i++){
                izquierda[i] = vector[i];
            }

            for (int i = 0; i < vector.length-posicionMitadVector; i++){
                derecha[i] = vector[posicionMitadVector+i];
            }

            mergeSort(izquierda);
            mergeSort(derecha);

            merge(vector,izquierda,derecha);
        }
    }

    private static void merge(int[] vector, int[] izquierda, int[] derecha){
        int indiceVectorOrdenado = 0;
        int indiceVectorIzquierda = 0;
        int indiceVectorDerecha = 0;

        while (indiceVectorIzquierda < izquierda.length && indiceVectorDerecha < derecha.length){
            if (izquierda[indiceVectorIzquierda] < derecha[indiceVectorDerecha]){
                vector[indiceVectorOrdenado++] = izquierda[indiceVectorIzquierda++];
            } else {
                vector[indiceVectorOrdenado++] = derecha[indiceVectorDerecha++];
            }
        }

        while (indiceVectorIzquierda < izquierda.length) {
            vector[indiceVectorOrdenado++] = izquierda[indiceVectorIzquierda++];
        }

        while (indiceVectorDerecha < derecha.length) {
            vector[indiceVectorOrdenado++] = derecha[indiceVectorDerecha++];
        }
    }
}
