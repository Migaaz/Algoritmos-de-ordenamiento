public class Main {
    enum Dimensiones {
        LONGITUD_ARRAY(100_000_000),
        LONGITUD_NUMEROS(8),
        MOSTRAR_NUMERO_VALORES(10);

        private final int valor;

        Dimensiones(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }

    public static void main(String[] args) {
        int[] listaRadix = new int[Dimensiones.LONGITUD_ARRAY.getValor()];
        int[] listaQuick = new int[Dimensiones.LONGITUD_ARRAY.getValor()];
        int[] listaMerge = new int[Dimensiones.LONGITUD_ARRAY.getValor()];
        int[] listaShell = new int[Dimensiones.LONGITUD_ARRAY.getValor()];
        int[] listaDualQuickSort = new int[Dimensiones.LONGITUD_ARRAY.getValor()];
        int longitudArray = listaRadix.length;

        for (int i = 0; i < longitudArray; i++) {
            listaRadix[i] = (int) (Math.random() * Math.pow(10, Dimensiones.LONGITUD_NUMEROS.getValor()));
            listaQuick[i] = listaRadix[i];
            listaMerge[i] = listaRadix[i];
            listaShell[i] = listaRadix[i];
            listaDualQuickSort[i] = listaRadix[i];
        }
        radix(listaRadix);
        quick(listaQuick);
        merge(listaMerge);
        shell(listaShell);
        dualQuick(listaDualQuickSort);
    }

    private static void radix(int[] arr){
        mostrarArray(arr);

        long tiempoInicio = System.currentTimeMillis();
        RadixSort.radixSort(arr);
        long tiempoFin = System.currentTimeMillis();

        mostrarArray(arr);

        System.out.printf("\nHa tardado %d milisegundos con RadixSort\n", tiempoFin-tiempoInicio);
    }

    private static void quick(int[] arr){
        mostrarArray(arr);

        long tiempoInicio = System.currentTimeMillis();
        QuickSort.quickSort(arr);
        long tiempoFin = System.currentTimeMillis();

        mostrarArray(arr);

        System.out.printf("\nHa tardado %d milisegundos con QuickSort\n", tiempoFin-tiempoInicio);
    }

    private static void merge(int[] arr){
        mostrarArray(arr);

        long tiempoInicio = System.currentTimeMillis();
        MergeSort.mergeSort(arr);
        long tiempoFin = System.currentTimeMillis();

        mostrarArray(arr);

        System.out.printf("\nHa tardado %d milisegundos con MergeSort\n", tiempoFin-tiempoInicio);
    }

    private static void shell(int[] arr){
        mostrarArray(arr);

        long tiempoInicio = System.currentTimeMillis();
        ShellSort.shellSort(arr);
        long tiempoFin = System.currentTimeMillis();

        mostrarArray(arr);

        System.out.printf("\nHa tardado %d milisegundos con ShellSort\n", tiempoFin-tiempoInicio);
    }

    private static void dualQuick(int[] arr){
        mostrarArray(arr);

        long tiempoInicio = System.currentTimeMillis();
        DualQuickSort.dualQuickSort(arr);
        long tiempoFin = System.currentTimeMillis();

        mostrarArray(arr);

        System.out.printf("\nHa tardado %d milisegundos con DualQuickSort\n", tiempoFin-tiempoInicio);
    }

    private static void mostrarArray (int[] arr){
        System.out.println();

        for (int i = 0; i < Dimensiones.MOSTRAR_NUMERO_VALORES.getValor(); i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println("\n ... ");

        for (int i = 0; i < Dimensiones.MOSTRAR_NUMERO_VALORES.getValor(); i++){
            System.out.print(arr[arr.length-(Dimensiones.MOSTRAR_NUMERO_VALORES.getValor()+1)+i]+" ");
        }
    }
}