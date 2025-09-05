public class AlgoritmosBasicosPorComparacion {

    // T(n) = O(n²)
    // Espacio adicional O(1)
    // No estable
    public static void selectionSort (int[] vector){
        int longitudVector = vector.length;

        for (int indiceActual = 0; indiceActual < longitudVector; indiceActual++){
            int posicionValorMenor = indiceActual;
            for (int indiceComparacion = indiceActual+1; indiceComparacion < longitudVector; indiceComparacion++) {
                if (vector[indiceComparacion] < vector[posicionValorMenor])
                    posicionValorMenor = indiceComparacion;
            }
            int aux = vector[indiceActual];
            vector[indiceActual] = vector[posicionValorMenor];
            vector[posicionValorMenor] = aux;
        }
    }

    // T(n) = O(n) - O(n²)
    // Espacio adicional O(1)
    // Estable
    public static void insertionSort (int[] vector){
        for (int indiceActual=1; indiceActual<vector.length; indiceActual++) {
            int valorIndiceActual = vector[indiceActual];
            int i = indiceActual;

            while (i > 0 && valorIndiceActual < vector[i-1]) {
                vector[i] = vector[i-1];
                i--;
            }
            vector[i] = valorIndiceActual;
        }
    }

    // T(n) = O(n) - O(n²)
    // Espacio adicional O(1)
    // Estable
    public static void bubbleSort (int[] vector){
        for (int i = vector.length-1; i >= 0; i--){
            for (int j = 0; j < i; j++) {
                if (vector[j] > vector[j+1]){
                    int aux = vector[j];
                    vector[j] = vector[j+1];
                    vector[j+1] = aux;
                }
            }
        }
    }

    // T(n) = O(n) - O(n²)
    // Espacio adicional O(1)
    // No estable
    public static void combSort (int[] vector){
        boolean ordenado = false;
        int gap = vector.length-1;
        while (!ordenado || gap > 1){
            if (gap > 1)
                gap = (int) (gap/1.3);

            ordenado = true;
            int i = 0;
            while (i + gap < vector.length){
                if (vector[i] > vector[i+gap]){
                    int aux = vector[i];
                    vector[i] = vector[i+gap];
                    vector[i+gap] = aux;
                    ordenado = false;
                }
                i++;
            }
        }
    }

    // T(n) = O(n log n)
    // Espacio adicional O(1)
    // No estable
    public static void heapSort(int[] vector) {
        int longitudVector = vector.length;

        for (int i = longitudVector / 2 - 1; i >= 0; i--) {
            heap(vector, longitudVector, i);
        }

        for (int i = longitudVector - 1; i > 0; i--) {
            int temp = vector[0];
            vector[0] = vector[i];
            vector[i] = temp;

            heap(vector, i, 0);
        }
    }

    private static void heap(int[] vector, int longitudVector, int raiz) {
        int mayor = raiz;
        int izquierdo = 2 * raiz + 1;
        int derecho = 2 * raiz + 2;

        if (izquierdo < longitudVector && vector[izquierdo] > vector[mayor])
            mayor = izquierdo;

        if (derecho < longitudVector && vector[derecho] > vector[mayor])
            mayor = derecho;

        if (mayor != raiz) {
            int aux = vector[raiz];
            vector[raiz] = vector[mayor];
            vector[mayor] = aux;

            heap(vector, longitudVector, mayor);
        }
    }

    // T(n) = O(n log n) - O(n²)
    // Espacio adicional O(1)
    // No estable
    public static void shellSort(int[] vector){
        int longitudVector = vector.length;

        for (int salto = longitudVector/2; salto > 0; salto /= 2 ){

            for (int i = salto; i < longitudVector; i++){
                int temp = vector[i];
                int j = i;

                while (j >= salto && vector[j - salto] > temp){
                    vector[j] = vector[j - salto];
                    j -= salto;
                }

                vector[j] = temp;
            }
        }
    }
}