public class AlgoritmosBasicosPorComparacion {

    // T(n) = Ω(n²), Θ(n²), O(n²)
    public static void ordenarPorSeleccion(int[] vector){
        for (int indiceActual = 0; indiceActual < vector.length; indiceActual++){
            int posicionValorMenor = indiceActual;
            for (int indiceComparacion = indiceActual+1; indiceComparacion < vector.length; indiceComparacion++) {
                if (vector[indiceComparacion] < vector[posicionValorMenor])
                    posicionValorMenor = indiceComparacion;
            }
            int aux = vector[indiceActual];
            vector[indiceActual] = vector[posicionValorMenor];
            vector[posicionValorMenor] = aux;
        }
    }

    // T(n) = Ω(n²), Θ(n²), O(n²)
    public static void ordenarPorInsercion(int[] vector){

    }
}
