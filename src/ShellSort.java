public class ShellSort {
    public static void shellSort(int[] arr){
        int longitudArr = arr.length;

        for (int salto = longitudArr/2; salto > 0; salto /= 2 ){

            for (int i = salto; i < longitudArr; i++){
                int temp = arr[i];
                int j = i;

                while (j >= salto && arr[j - salto] > temp){
                    arr[j] = arr[j - salto];
                    j -= salto;
                }

                arr[j] = temp;
            }
        }
    }
}
