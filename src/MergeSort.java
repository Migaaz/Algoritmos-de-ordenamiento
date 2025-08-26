public class MergeSort {
    public static void mergeSort(int[] arr){
        if (arr.length > 1){
            int posicionMitadArr = arr.length / 2;

            int[] izquierda = new int[posicionMitadArr];
            int[] derecha = new int[arr.length-posicionMitadArr];

            for (int i = 0; i < posicionMitadArr; i++){
                izquierda[i] = arr[i];
            }

            for (int i = 0; i < arr.length-posicionMitadArr; i++){
                derecha[i] = arr[posicionMitadArr+i];
            }

            mergeSort(izquierda);
            mergeSort(derecha);

            merge(arr,izquierda,derecha);
        }
    }

    private static void merge(int[] arr, int[] izquierda, int[] derecha){
        int i = 0, j = 0, k = 0;

        while (i < izquierda.length && j < derecha.length){
            if (izquierda[i] < derecha[j]){
                arr[k++] = izquierda[i++];
            } else {
                arr[k++] = derecha[j++];

            }
        }

        while (i < izquierda.length) {
            arr[k++] = izquierda[i++];
        }

        while (j < derecha.length) {
            arr[k++] = derecha[j++];
        }
    }
}