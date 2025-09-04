public class MergeSort {
    public static void mergeSort(int[] vector){
        if (vector.length > 1){
            int posicionMitadArr = vector.length / 2;

            int[] izquierda = new int[posicionMitadArr];
            int[] derecha = new int[vector.length-posicionMitadArr];

            for (int i = 0; i < posicionMitadArr; i++){
                izquierda[i] = vector[i];
            }

            for (int i = 0; i < vector.length-posicionMitadArr; i++){
                derecha[i] = vector[posicionMitadArr+i];
            }

            mergeSort(izquierda);
            mergeSort(derecha);

            merge(vector,izquierda,derecha);
        }
    }

    private static void merge(int[] vector, int[] izquierda, int[] derecha){
        int i = 0, j = 0, k = 0;

        while (i < izquierda.length && j < derecha.length){
            if (izquierda[i] < derecha[j]){
                vector[k++] = izquierda[i++];
            } else {
                vector[k++] = derecha[j++];

            }
        }

        while (i < izquierda.length) {
            vector[k++] = izquierda[i++];
        }

        while (j < derecha.length) {
            vector[k++] = derecha[j++];
        }
    }
}