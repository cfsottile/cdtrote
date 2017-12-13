package laboratorio.juegocei.table;

import android.graphics.Point;
import android.widget.ImageButton;

import java.util.Arrays;
import java.util.HashMap;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.Arc;
import laboratorio.juegocei.Destination;
import laboratorio.juegocei.Letter;
import laboratorio.juegocei.Reference;

public class Tracks {
    private final Reference letterXup;
    private final Reference letterXdown;
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
    private Air air;

    public Tracks(int screenX, int screenY, HashMap<String, ImageButton> letters) {
        this.screenX = screenX;
        this.screenY = screenY;
        MARGEN_IZQUIERDO_DERECHO_PISTA = screenX / 20;
        MARGEN_ARRIBA_PISTA = screenX / 4;
        MARGEN_ABAJO_PISTA = screenX / 4;
        anchoPista = screenX - (MARGEN_IZQUIERDO_DERECHO_PISTA * 2);
        altoPista = screenY - MARGEN_ARRIBA_PISTA - MARGEN_ABAJO_PISTA;
        letterA = new Letter(letters.get("A"), new Point(
            convertX(ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
            convertY(ALTO_ORIGINAL_IMAGEN_PISTA)));
        letterB = new Letter(letters.get("B"), new Point(
            convertX(874),
            convertY(604)));
        letterC = new Letter(letters.get("C"), new Point(
            convertX(ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
            convertY(1)));
        letterE = new Letter(letters.get("E"), new Point(
            convertX(86),
            convertY(602)));
        letterF = new Letter(letters.get("F"), new Point(
            convertX(914),
            convertY(904)));
        letterXup = new Reference(new Point(
            convertX(ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
            convertY((ALTO_ORIGINAL_IMAGEN_PISTA / 2) / 2)));
        letterXdown = new Reference(new Point(
            convertX(ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
            convertY((ALTO_ORIGINAL_IMAGEN_PISTA / 4) * 3)));
        letterX = new Letter(letters.get("X"), new Point(
            convertX(ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
            convertY(ALTO_ORIGINAL_IMAGEN_PISTA / 2)));
        letterH = new Letter(letters.get("H"), new Point(
            convertX(126),
            convertY(302)));
        letterK = new Letter(letters.get("K"), new Point(
            convertX(46),
            convertY(906)));
        letterM = new Letter(letters.get("M"), new Point(
            convertX(838),
            convertY(300)));
        cornerRUp = new Reference(new Point(
            convertX(798),
            convertY(1)));
        cornerLUp = new Reference(new Point(
            convertX(168),
            convertY(1)));
        cornerRDown = new Reference(new Point(
            convertX(948),
            convertY(ALTO_ORIGINAL_IMAGEN_PISTA)));
        cornerLDown = new Reference(new Point(
            convertX(1),
            convertY(ALTO_ORIGINAL_IMAGEN_PISTA)));

    }

    public Track table3NewVersion() {
        SubTrack subTrack1 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterA, Arc.MOVE),
                new Destination(this.letterX, Arc.LINE),
                new Destination(this.letterC, Arc.LINE),
                new Destination(this.cornerRUp, Arc.LINE),
                new Destination(this.cornerRDown, Arc.LINE),
                new Destination(this.cornerLDown, Arc.LINE),
                new Destination(this.letterK, Arc.LINE)
            ),
            Air.TROTE
        );
        SubTrack subTrack2 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterK, Arc.MOVE),
                new Destination(this.letterE, Arc.LINE),
                new Destination(new Reference(new Point(convertX(102), convertY(552))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(122), convertY(490))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(146), convertY(416))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(178), convertY(352))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(218), convertY(310))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(254), convertY(300))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(302), convertY(302))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(348), convertY(320))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(390), convertY(364))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(420), convertY(422))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(440), convertY(476))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(452), convertY(526))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(464), convertY(566))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(472), convertY(604))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(488), convertY(658))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(510), convertY(714))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(532), convertY(766))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(560), convertY(820))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(598), convertY(866))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(652), convertY(896))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(694), convertY(906))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(734), convertY(908))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(778), convertY(882))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(818), convertY(844))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(848), convertY(794))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(868), convertY(722))), Arc.LINE),
                new Destination(this.letterB, Arc.LINE)
            ),
            Air.PASO
        );
        SubTrack subTrack3 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterB, Arc.MOVE),
                new Destination(this.cornerRUp, Arc.LINE),
                new Destination(this.letterC, Arc.LINE),
                new Destination(new Reference(new Point(convertX(366), convertY(14))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(280), convertY(50))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(208), convertY(86))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(174), convertY(138))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(148), convertY(188))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(136), convertY(254))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(128), convertY(298))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(138), convertY(392))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(152), convertY(456))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(236), convertY(536))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(318), convertY(568))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(400), convertY(592))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(480), convertY(604))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(614), convertY(570))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(712), convertY(540))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(798), convertY(462))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(822), convertY(346))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(830), convertY(298))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(810), convertY(218))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(768), convertY(138))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(704), convertY(72))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(634), convertY(26))), Arc.LINE),
                new Destination(this.letterC, Arc.LINE),
                new Destination(this.cornerLUp, Arc.LINE),
                new Destination(this.letterH, Arc.LINE)
            ),
            Air.TROTE
        );
        SubTrack subTrack4 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterH, Arc.MOVE),
                new Destination(this.letterE, Arc.LINE),
                new Destination(new Reference(new Point(convertX(100), convertY(670))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(106), convertY(714))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(124), convertY(798))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(160), convertY(870))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(222), convertY(898))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(276), convertY(910))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(332), convertY(894))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(364), convertY(862))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(392), convertY(816))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(420), convertY(750))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(444), convertY(680))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(456), convertY(634))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(470), convertY(598))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(480), convertY(556))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(492), convertY(526))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(510), convertY(476))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(530), convertY(426))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(566), convertY(378))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(600), convertY(342))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(634), convertY(316))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(668), convertY(308))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(710), convertY(308))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(750), convertY(340))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(786), convertY(376))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(818), convertY(428))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(850), convertY(500))), Arc.LINE),
                new Destination(this.letterB, Arc.LINE),
                new Destination(this.letterF, Arc.LINE)
            ),
            Air.PASO
        );
        SubTrack subTrack5 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterF, Arc.MOVE),
                new Destination(this.cornerRDown, Arc.LINE),
                new Destination(this.letterA, Arc.LINE),
                new Destination(new Reference(new Point(convertX(372), convertY(1194))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(268), convertY(1172))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(192), convertY(1136))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(128), convertY(1068))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(92), convertY(1024))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(66), convertY(946))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(62), convertY(886))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(94), convertY(776))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(136), convertY(702))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(208), convertY(648))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(286), convertY(622))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(374), convertY(606))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(476), convertY(602))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(580), convertY(610))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(680), convertY(624))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(754), convertY(648))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(818), convertY(706))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(848), convertY(756))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(884), convertY(852))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(900), convertY(908))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(892), convertY(966))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(876), convertY(1030))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(810), convertY(1098))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(738), convertY(1146))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(638), convertY(1182))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(544), convertY(1198))), Arc.LINE),
                new Destination(this.letterA, Arc.LINE),
                new Destination(this.cornerLDown, Arc.LINE),
                new Destination(this.letterK, Arc.LINE)
            ),
            Air.TROTE
        );
        SubTrack subTrack6 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterK, Arc.MOVE),
                new Destination(this.letterM, Arc.LINE),
                new Destination(this.cornerRUp, Arc.LINE),
                new Destination(this.letterC, Arc.LINE)
            ),
            Air.TROTE
        );
        SubTrack subTrack7 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterC, Arc.MOVE),
                new Destination(this.cornerLUp, Arc.LINE),
                new Destination(this.letterH, Arc.LINE),
                new Destination(this.letterF, Arc.LINE)
            ),
            Air.PASO
        );
        SubTrack subTrack8 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterF, Arc.MOVE),
                new Destination(this.cornerRDown, Arc.LINE),
                new Destination(this.letterA, Arc.LINE),
                new Destination(this.letterX, Arc.LINE)
            ),
            Air.PASO
        );

        return new Track(
            Arrays.asList(
                subTrack1, subTrack2, subTrack3, subTrack4, subTrack5, subTrack6, subTrack7, subTrack8),
            0);
    }

    private int convertY(int y) {
        return MARGEN_ARRIBA_PISTA + (y * altoPista / ALTO_ORIGINAL_IMAGEN_PISTA);
    }

    private int convertX(int x) {
        return (x * anchoPista / ANCHO_ORIGINAL_IMAGEN_PISTA) + MARGEN_IZQUIERDO_DERECHO_PISTA;
    }
}