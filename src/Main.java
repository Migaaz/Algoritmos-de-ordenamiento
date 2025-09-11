public class Main {
    enum Dimensiones {
        LONGITUD_ARRAY(100_000_000),
        LONGITUD_NUMEROS(8),
        MOSTRAR_NUMERO_VALORES(5);

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
        int[] listaDualQuickSort = new int[Dimensiones.LONGITUD_ARRAY.getValor()];
        int longitudArray = listaRadix.length;

        for (int i = 0; i < longitudArray; i++) {
            listaRadix[i] = (int) (Math.random() * Math.pow(10, Dimensiones.LONGITUD_NUMEROS.getValor()));
            listaQuick[i] = listaRadix[i];
            listaMerge[i] = listaRadix[i];
            listaDualQuickSort[i] = listaRadix[i];
        }
    }

    private static void mostrarArray (int[] vector){
        System.out.println();

        for (int i = 0; i < Dimensiones.MOSTRAR_NUMERO_VALORES.getValor(); i++){
            System.out.print(vector[i]+" ");
        }

        System.out.println("\n ... ");

        for (int i = 0; i < Dimensiones.MOSTRAR_NUMERO_VALORES.getValor(); i++){
            System.out.print(vector[vector.length-(Dimensiones.MOSTRAR_NUMERO_VALORES.getValor()+1)+i]+" ");
        }
    }
}