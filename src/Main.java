public class Main {
    enum Dimensiones {
        LONGITUD_ARRAY(200),
        LONGITUD_NUMEROS(5);

        private final int valor;

        Dimensiones(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }

    public static void main(String[] args) {
        int[] listaNumeros = new int[Dimensiones.LONGITUD_ARRAY.getValor()];
        int longitudArray = listaNumeros.length;

        for (int i = 0; i < longitudArray; i++) {
            listaNumeros[i] = (int) (Math.random() * Math.pow(10,Dimensiones.LONGITUD_NUMEROS.getValor()));
        }

        for (int numero : listaNumeros){
            System.out.print(numero+" ");
        }

        RadixSort.radixSort(listaNumeros);

        System.out.println();
        for (int numero : listaNumeros){
            System.out.print(numero+" ");
        }
    }
}