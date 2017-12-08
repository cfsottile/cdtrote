package laboratorio.juegocei;

import android.graphics.Point;
import android.widget.ImageButton;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
    private final Letter letterA;
    private final Letter letterB;
    private final Letter letterC;
    private final Letter letterE;
    private final Letter letterF;
    private final Letter letterX;
    private final Letter letterH;
    private final Letter letterK;
    private final Letter letterM;
    private final Reference cornerRUp;
    private final Reference cornerLUp;
    private final Reference cornerRDown;
    private final Reference cornerLDown;

    public Tracks(int screenX, int screenY, HashMap<String, ImageButton> letters) {
        this.screenX = screenX;
        this.screenY = screenY;
        MARGEN_IZQUIERDO_DERECHO_PISTA = screenX / 20;
        MARGEN_ARRIBA_PISTA = screenX / 4;
        MARGEN_ABAJO_PISTA = screenX / 4;
        anchoPista = screenX - (MARGEN_IZQUIERDO_DERECHO_PISTA * 2);
        altoPista = screenY - MARGEN_ARRIBA_PISTA - MARGEN_ABAJO_PISTA;
        letterA = new Letter(letters.get("A"), new Point(
                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
                getYConvertido(altoPista, 1)));
        letterB = new Letter(letters.get("B"), new Point(
                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA),
                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA / 2)));
        letterC = new Letter(letters.get("C"), new Point(
                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA)));
        letterE = new Letter(letters.get("E"), new Point(
                getXConvertido(anchoPista, 1),
                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA / 2)));
        letterF = new Letter(letters.get("F"), new Point(
                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA),
                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA / 3)));
        letterX = new Letter(letters.get("X"), new Point(
                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA/ 2),
                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA /2)));
        letterH = new Letter(letters.get("H"), new Point(
                getXConvertido(anchoPista, 1),
                getYConvertido(altoPista, (ALTO_ORIGINAL_IMAGEN_PISTA / 3)*2)));
        letterK = new Letter(letters.get("K"), new Point(
                getXConvertido(anchoPista, 1),
                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA / 3)));
        letterM = new Letter(letters.get("M"), new Point(
                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA),
                getYConvertido(altoPista, (ALTO_ORIGINAL_IMAGEN_PISTA / 3)*2)));
        cornerRUp = new Letter(null, new Point(
                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA),
                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA)));
        cornerLUp = new Letter(null, new Point(
                getXConvertido(anchoPista, 1),
                getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA)));
        cornerRDown = new Letter(null, new Point(
                getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA),
                getYConvertido(altoPista, 1)));
        cornerLDown = new Letter(null, new Point(
                getXConvertido(anchoPista, 1),
                getYConvertido(altoPista, 1)));

    }

    public Track prueba1() {
        return new Track(Arrays.asList(
            Arrays.asList(
                new Destination(this.letterA, Arc.MOVE),
                new Destination(this.letterF, Arc.LEFT_ARC),
                new Destination(this.letterM, Arc.LEFT_ARC),
                new Destination(this.letterC, Arc.LEFT_ARC),
                new Destination(this.letterH, Arc.LEFT_ARC))));
    }

    public Track pruebaCirculo() {
        return new Track(Arrays.asList(
                Arrays.asList(
                        new Destination(this.letterA, Arc.MOVE),
                        new Destination(this.letterX, Arc.RIGHT_ARC),
                        new Destination(this.letterA, Arc.RIGHT_ARC))));
    }

    public Track prueba2() {
        return new Track(Arrays.asList(
                Arrays.asList(
                        new Destination(this.letterA, Arc.MOVE),
                        new Destination(this.letterX, Arc.LINE),
                        new Destination(this.letterC, Arc.LINE),
                        new Destination(this.letterE, Arc.LINE)),
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

    public Track table3() {
        return new Track(
        Arrays.asList(
                Arrays.asList(
                        new Destination(this.letterA, Arc.MOVE),
                        new Destination(this.letterX, Arc.LINE),
                        new Destination(this.letterC, Arc.LINE),
                        new Destination(this.cornerRUp, Arc.LINE),
                        new Destination(this.cornerRDown, Arc.LINE),
                        new Destination(this.cornerLDown, Arc.LINE),
                        new Destination(this.letterK, Arc.LINE)
                ),
                Arrays.asList(
                        new Destination(this.letterK, Arc.MOVE),
                        new Destination(this.letterE, Arc.LINE),
                        new Destination(this.letterX, Arc.LINE),
                        new Destination(this.letterB, Arc.LINE)
                ),
                Arrays.asList(
                        new Destination(this.letterB, Arc.MOVE),
                        new Destination(this.cornerRUp, Arc.LINE),
                        new Destination(this.letterC, Arc.LINE),
                        new Destination(this.letterX, Arc.LEFT_ARC),
                        new Destination(this.letterC, Arc.RIGHT_ARC),
                        new Destination(this.cornerLUp, Arc.LINE),
                        new Destination(this.letterH, Arc.LINE)
                ),
                Arrays.asList(
                        new Destination(this.letterH, Arc.MOVE),
                        new Destination(this.letterE, Arc.LINE),
                        new Destination(this.letterX, Arc.RIGHT_ARC),
                        new Destination(this.letterB, Arc.LEFT_ARC),
                        new Destination(this.letterF, Arc.LINE)
                )
        ));

    }

    private int getYConvertido(int altoPista, int y) {
        return MARGEN_ARRIBA_PISTA + altoPista - (y * altoPista / ALTO_ORIGINAL_IMAGEN_PISTA);
    }

    private int getXConvertido(int anchoPista, int x) {
        return (x * anchoPista / ANCHO_ORIGINAL_IMAGEN_PISTA) + MARGEN_IZQUIERDO_DERECHO_PISTA;
    }
}