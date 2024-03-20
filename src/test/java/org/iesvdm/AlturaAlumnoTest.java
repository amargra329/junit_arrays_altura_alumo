package org.iesvdm;

import org.junit.jupiter.api.Test;

import static org.iesvdm.AlturaAlumno.*;
import static org.junit.jupiter.api.Assertions.*;

public class AlturaAlumnoTest {
    @Test
    void añadeNombre_Test() {
        // WHEN
        // Creo un array inical con nombres
        String[] nombresIniciales = {"Óscar", "Pedro"};
        String nombre = "Álvaro";

        // DO
        // Creo una copia del array inicial pero con el nuevo nombre
        String[] nombresFinales = añadeNombre(nombresIniciales, nombre);

        // THEN
        // Compruebo que la longitud se incremento en 1
        assertEquals(nombresIniciales.length, nombresFinales.length - 1);

        // Compruebo que se añadio el nombre en la ultima posición
        assertTrue(nombresFinales[nombresFinales.length - 1].equals(nombre));

        // Compruebo que no se modificaron los nombres que ya estaban
        for (int i = 0; i < nombresFinales.length - 1; i++) {
            assertTrue(nombresIniciales[i] == nombresFinales[i]);
        }
    }

    @Test
    void añadeAltura_Test() {
        // WHEN
        // Creo un array con las alturas inicales
        double[] alturasIniciales = {1.9};

        // DO
        // Creo un array copiando las alturas iniciales más una nueva
        double[] alturasFinales = añadeAltura(alturasIniciales);

        // THEN
        // Compruebo que la longitud se incremento en 1
        assertEquals(alturasIniciales.length, alturasFinales.length - 1);

        // Compruebo que se añadio la altura en la ultima posición
        assertTrue(alturasFinales[alturasFinales.length - 1] == 1.5);

        // Compruebo que no se modificaron las alturas que ya estaban
        for (int i = 0; i < alturasFinales.length - 1; i++) {
            assertTrue(alturasIniciales[i] == alturasFinales[i]);
        }
    }

    @Test
    void modificaAltura_Test() {
        // WHEN
        // Creo un array inicial con las alturas
        double[] alturasIniciales = {1.9, 2.0, 1.5};
        double altura = 1.6;
        int indice = 1;

        // DO
        // Creo una copia de las alturas iniciales
        double[] alturasFinales = alturasIniciales;

        // Modifico la altura con indice 1
        modificaAltura(alturasFinales, indice, altura);

        // THEN
        // Compruebo que el tamaño del array sigue siendo el mismo
        assertTrue(alturasIniciales.length == alturasFinales.length);

        // Compruebo que se ha modificado el tamaño
        assertTrue(alturasFinales[indice] == altura);

        // Compruebo que no se ha modificado el tamaño de los otros valores
        for (int i = 0; i < alturasFinales.length; i++) {
            if (i != indice) {
                assertTrue(alturasFinales[0] == alturasIniciales[0]);
            }
        }
    }

    @Test
    void buscaNombre_Test() {
        // WHEN
        // Creo un array con los nombres
        String[] nombres = {"Álvaro", "Òscar", "Pedro"};

        // DO, DONE
        // Busco todos los nombres del array y pido los indice y asu vez compruebo si esta bien
        for (int i = 0; i < nombres.length; i++) {
            assertEquals(i, buscaNombre(nombres, nombres[i]));
        }

        // Compruebo que me da -1 con un nombre que no esta
        assertEquals(-1, buscaNombre(nombres, "abc"));
    }

    @Test
    void mostrar_Test() {
        // WHEN
        String[] array = {"Juan", "Ana", "Luis"};
        double[] alturas1 = {1.9, 1.78};
        double[] alturas2 = {1.9, 1.78, 1.8};

        // DO THEN
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            AlturaAlumno.mostrar(array, alturas1);
        });
        assertDoesNotThrow(() -> {
            AlturaAlumno.mostrar(array, alturas2);
        });
    }

    @Test
    void calculaMaximo_Test() {
        // WHEN
        // Creo el array con numeros
        double[] numeros = {2.234, 324.23, 43.34};

        // DO
        // Saco el numero máximo
        double[] max = calculaMaximo(numeros);

        // DONE
        // Compruebo de que el resultado es correcto
        assertTrue(max[0] == 1);
        assertTrue(max[1] == numeros[1]);
    }

    @Test
    void calculaMedia_Test() {
        // WHEN
        // Creo un array con numeros
        double[] numeros = {12.31231, 123.23, 123.213};

        // DO
        // Pido la media
        double media = calculaMedia(numeros);

        // DONE
        // Compruebo si la media esta bien
        assertEquals(media, 86, 25177);
    }
}
