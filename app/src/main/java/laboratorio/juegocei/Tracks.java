package laboratorio.juegocei;

import android.graphics.Point;

import java.util.Arrays;

/**
 * Created by cristian on 6/12/17.
 */

public class Tracks {
    private int screenX;
    private int screenY;
    private final int MARGEN_IZQUIERDO_DERECHO_PISTA;
    private int MARGEN_ARRIBA_PISTA;
    private int MARGEN_ABAJO_PISTA;
    private final int ANCHO_ORIGINAL_IMAGEN_PISTA = 951;
    private final int ALTO_ORIGINAL_IMAGEN_PISTA = 1211;
    private int anchoPista;
    private int altoPista;

    public Tracks(int screenX, int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;
        MARGEN_IZQUIERDO_DERECHO_PISTA = screenX / 20;
        MARGEN_ARRIBA_PISTA = screenX / 4;
        MARGEN_ABAJO_PISTA = screenX / 4;
        anchoPista = screenX - (MARGEN_IZQUIERDO_DERECHO_PISTA * 2);
        altoPista = screenY - MARGEN_ARRIBA_PISTA - MARGEN_ABAJO_PISTA;
    }

    public Track prueba1() {
        return new Track(Arrays.asList(
            Arrays.asList(
                new Destination(
                    new Letter(
                        null,
                        new Point(
                            getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
                            getYConvertido(altoPista, 1))),
                    Arc.MOVE),
                new Destination(
                    new Letter(
                        null,
                        new Point(
                            getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
                            getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA))),
                    Arc.LINE),
                new Destination(
                    new Letter(
                        null,
                        new Point(
                            getXConvertido(anchoPista, 1),
                            getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA / 2))),
                    Arc.LINE))));
    }

    public Track prueba2() {
        return new Track(Arrays.asList(
                Arrays.asList(
                        new Destination(
                                new Letter(
                                        null,
                                        new Point(
                                                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
                                                getYConvertido(altoPista, 1))),
                                Arc.MOVE),
                        new Destination(
                                new Letter(
                                        null,
                                        new Point(
                                                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
                                                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA))),
                                Arc.LINE),
                        new Destination(
                                new Letter(
                                        null,
                                        new Point(
                                                getXConvertido(anchoPista, 1),
                                                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA / 2))),
                                Arc.LINE)),
                Arrays.asList(
                        new Destination(
                                new Letter(
                                        null,
                                        new Point(
                                                getXConvertido(anchoPista, 1),
                                                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA / 2))),
                                Arc.MOVE),
                        new Destination(
                                new Letter(
                                        null,
                                        new Point(
                                                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA),
                                                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA / 2))),
                                Arc.LINE),
                        new Destination(
                                new Letter(
                                        null,
                                        new Point(
                                                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
                                                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA))),
                                Arc.LINE))));
    }

    private int getYConvertido(int altoPista, int y) {
        return MARGEN_ARRIBA_PISTA + altoPista - (y * altoPista / ALTO_ORIGINAL_IMAGEN_PISTA);
    }

    private int getXConvertido(int anchoPista, int x) {
        return (x * anchoPista / ANCHO_ORIGINAL_IMAGEN_PISTA) + MARGEN_IZQUIERDO_DERECHO_PISTA;
    }
}