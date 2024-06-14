package com.example;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        /* ej1 */
        TGrafoDirigido VUELE_SEGURO = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "src\\main\\java\\com\\example\\aeropuertos.txt", "src\\main\\java\\com\\example\\conexiones.txt",
                false, TGrafoDirigido.class);
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(VUELE_SEGURO.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, VUELE_SEGURO.getVertices(), "Matriz vuelos");

        Double[][] floyd = VUELE_SEGURO.floyd();
        UtilGrafos.imprimirMatrizMejorado(floyd, VUELE_SEGURO.getVertices(), "Matriz Floyd");

        TCaminos caminoMontevideoCuritiva = VUELE_SEGURO.todosLosCaminos("Montevideo", "Curitiba");
        TCaminos caminoPorto_AlegreSantos = VUELE_SEGURO.todosLosCaminos("Porto_Alegre", "Santos");

        TCamino x = caminoPorto_AlegreSantos.getCaminoCritico();
        x.imprimirEtiquetasConsola();
        System.out.println(x.getCostoTotal());


        x = caminoMontevideoCuritiva.getCaminoCritico();
        x.imprimirEtiquetasConsola();
        System.out.println(x.getCostoTotal());
    }
}
