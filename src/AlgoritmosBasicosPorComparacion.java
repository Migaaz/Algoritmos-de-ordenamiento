public class AlgoritmosBasicosPorComparacion {

    // T(n) = Ω(n²), Θ(n²), O(n²)
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

    // T(n) = Ω(n²), Θ(n²), O(n²)
    public static void insertionSort (int[] vector){

    }

    // T(n) = Ω(n log n), - , O(n²)
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