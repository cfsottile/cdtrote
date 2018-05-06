package laboratorio.juegocei.table;

import android.graphics.Point;

import java.util.Arrays;
import java.util.List;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.Arc;
import laboratorio.juegocei.Destination;
import laboratorio.juegocei.Reference;

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
    private Reference letterA, letterB, letterC, letterE, letterF, letterX, letterH, letterK, letterM;
    private Reference letterXup, letterXdown, cornerRUp, cornerLUp, cornerRDown, cornerLDown;

    public Tracks(int screenX, int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;
        MARGEN_IZQUIERDO_DERECHO_PISTA = screenX / 20;
        MARGEN_ARRIBA_PISTA = screenX / 4;
        MARGEN_ABAJO_PISTA = screenX / 4;
        anchoPista = screenX - (MARGEN_IZQUIERDO_DERECHO_PISTA * 2);
        altoPista = screenY - MARGEN_ARRIBA_PISTA - MARGEN_ABAJO_PISTA;
        letterA = new Reference(new Point(convertX(ANCHO_ORIGINAL_IMAGEN_PISTA / 2), convertY(ALTO_ORIGINAL_IMAGEN_PISTA - 33)), 'a');
        letterB = new Reference(new Point(convertX(874 - 10), convertY(604)), 'b');
        letterC = new Reference(new Point(convertX(ANCHO_ORIGINAL_IMAGEN_PISTA / 2), convertY(1 + 15)), 'c');
        letterE = new Reference(new Point(convertX(86 + 10), convertY(602)), 'e');
        letterF = new Reference(new Point(convertX(914 - 10), convertY(904)), 'f');
        letterX = new Reference(new Point(convertX(ANCHO_ORIGINAL_IMAGEN_PISTA / 2), convertY(ALTO_ORIGINAL_IMAGEN_PISTA / 2)), 'x');
        letterH = new Reference(new Point(convertX(126 + 10), convertY(302)), 'h');
        letterK = new Reference(new Point(convertX(46 + 10), convertY(906)), 'k');
        letterM = new Reference(new Point(convertX(838 - 10), convertY(300)), 'm');
        letterXup = new Reference(new Point(convertX(ANCHO_ORIGINAL_IMAGEN_PISTA / 2), convertY((ALTO_ORIGINAL_IMAGEN_PISTA / 2) / 2)));
        letterXdown = new Reference(new Point(convertX(ANCHO_ORIGINAL_IMAGEN_PISTA / 2), convertY((ALTO_ORIGINAL_IMAGEN_PISTA / 4) * 3)));
        cornerRUp = new Reference(new Point(convertX(798 - 10), convertY(1 + 15)));
        cornerLUp = new Reference(new Point(convertX(168 + 10), convertY(1 + 15)));
        cornerRDown = new Reference(new Point(convertX(948 - 10), convertY(ALTO_ORIGINAL_IMAGEN_PISTA - 33)));
        cornerLDown = new Reference(new Point(convertX(1 + 15), convertY(ALTO_ORIGINAL_IMAGEN_PISTA - 33)));

    }

    public Track table3() {
        SubTrack subTrack0 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterA, Arc.MOVE),
                new Destination(this.letterX, Arc.LINE)
            ),
            Air.TROTE
        );
        SubTrack subTrack1 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterX, Arc.MOVE),
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
                new Destination(new Reference(new Point(convertX(474), convertY(16))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(443), convertY(18))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(406), convertY(27))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(363), convertY(42))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(330), convertY(56))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(295), convertY(76))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(262), convertY(99))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(231), convertY(127))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(202), convertY(155))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(174), convertY(188))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(162), convertY(218))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(150), convertY(258))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(146), convertY(298))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(146), convertY(328))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(150), convertY(362))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(160), convertY(397))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(176), convertY(428))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(195), convertY(454))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(224), convertY(486))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(263), convertY(522))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(302), convertY(545))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(338), convertY(561))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(364), convertY(571))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(409), convertY(582))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(441), convertY(588))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(475), convertY(590))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(504), convertY(588))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(534), convertY(586))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(562), convertY(582))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(590), convertY(574))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(617), convertY(566))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(649), convertY(554))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(672), convertY(543))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(702), convertY(523))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(728), convertY(500))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(748), convertY(480))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(762), convertY(462))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(782), convertY(434))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(796), convertY(407))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(806), convertY(374))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(814), convertY(339))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(816), convertY(313))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(815), convertY(276))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(808), convertY(250))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(794), convertY(216))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(770), convertY(174))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(747), convertY(140))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(720), convertY(112))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(684), convertY(85))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(650), convertY(66))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(611), convertY(46))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(570), convertY(30))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(533), convertY(21))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(499), convertY(17))), Arc.LINE),
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
                new Destination(new Reference(new Point(convertX(462), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(440), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(418), convertY(1174))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(396), convertY(1171))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(374), convertY(1167))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(353), convertY(1162))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(328), convertY(1156))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(292), convertY(1143))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(260), convertY(1130))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(232), convertY(1116))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(208), convertY(1102))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(187), convertY(1090))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(168), convertY(1076))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(151), convertY(1062))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(133), convertY(1047))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(117), convertY(1033))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(103), convertY(1017))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(91), convertY(1001))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(79), convertY(984))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(69), convertY(964))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(61), convertY(934))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(58), convertY(905))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(58), convertY(891))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(59), convertY(871))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(60), convertY(856))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(64), convertY(835))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(68), convertY(821))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(76), convertY(802))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(95), convertY(767))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(119), convertY(736))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(142), convertY(713))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(173), convertY(690))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(202), convertY(672))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(237), convertY(655))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(270), convertY(641))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(297), convertY(632))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(328), convertY(625))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(362), convertY(618))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(392), convertY(614))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(422), convertY(611))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(450), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(468), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(486), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(510), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(536), convertY(610))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(564), convertY(612))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(591), convertY(616))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(620), convertY(621))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(654), convertY(628))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(686), convertY(639))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(711), convertY(648))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(733), convertY(657))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(755), convertY(669))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(778), convertY(684))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(800), convertY(701))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(821), convertY(722))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(837), convertY(741))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(846), convertY(754))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(860), convertY(776))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(871), convertY(800))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(879), convertY(824))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(884), convertY(845))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(888), convertY(864))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(890), convertY(885))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(891), convertY(905))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(890), convertY(915))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(889), convertY(927))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(881), convertY(951))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(870), convertY(972))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(856), convertY(991))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(840), convertY(1010))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(825), convertY(1028))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(808), convertY(1043))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(792), convertY(1057))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(776), convertY(1068))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(760), convertY(1079))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(743), convertY(1090))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(729), convertY(1098))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(709), convertY(1109))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(692), convertY(1119))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(675), convertY(1127))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(656), convertY(1135))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(639), convertY(1142))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(624), convertY(1148))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(610), convertY(1152))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(594), convertY(1158))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(578), convertY(1161))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(562), convertY(1165))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(546), convertY(1168))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(530), convertY(1171))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(516), convertY(1174))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(503), convertY(1175))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(489), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(476), convertY(1176))), Arc.LINE),
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

        List<List<Destination>> destinationss = alternativePathsTable3();

        subTrack1.setUpIncorrectPath(destinationss.get(0));
        subTrack2.setUpIncorrectPath(destinationss.get(1));
        subTrack3.setUpIncorrectPath(destinationss.get(2));
        subTrack4.setUpIncorrectPath(destinationss.get(3));
        subTrack5.setUpIncorrectPath(destinationss.get(4));
        subTrack6.setUpIncorrectPath(destinationss.get(5));
        subTrack7.setUpIncorrectPath(destinationss.get(6));
        subTrack8.setUpIncorrectPath(destinationss.get(7));
        subTrack0.setUpIncorrectPath(destinationss.get(8));

        return new Track(
            Arrays.asList(
                subTrack0, subTrack1, subTrack2, subTrack3, subTrack4, subTrack5, subTrack6, subTrack7, subTrack8),
            0);
    }

    public Track table4() {
        SubTrack subTrack0 = new SubTrack(
            Arrays.asList(
                new Destination(letterA, Arc.MOVE),
                new Destination(letterX, Arc.LINE)
            ),
            Air.PASO
        );
        SubTrack subTrack1 = new SubTrack(
            Arrays.asList(
                new Destination(letterX, Arc.MOVE),
                new Destination(letterC, Arc.LINE),
                new Destination(cornerLUp, Arc.LINE),
                new Destination(cornerLDown, Arc.LINE),
                new Destination(letterA, Arc.LINE)
            ),
            Air.PASO
        );
        SubTrack subTrack2 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterA, Arc.MOVE),
                new Destination(new Reference(new Point(convertX(476), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(489), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(503), convertY(1175))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(516), convertY(1174))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(530), convertY(1171))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(546), convertY(1168))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(562), convertY(1165))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(578), convertY(1161))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(594), convertY(1158))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(610), convertY(1152))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(624), convertY(1148))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(639), convertY(1142))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(656), convertY(1135))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(675), convertY(1127))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(692), convertY(1119))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(709), convertY(1109))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(729), convertY(1098))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(743), convertY(1090))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(760), convertY(1079))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(776), convertY(1068))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(792), convertY(1057))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(808), convertY(1043))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(825), convertY(1028))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(840), convertY(1010))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(856), convertY(991))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(870), convertY(972))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(881), convertY(951))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(889), convertY(927))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(890), convertY(915))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(891), convertY(905))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(890), convertY(885))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(888), convertY(864))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(884), convertY(845))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(879), convertY(824))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(871), convertY(800))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(860), convertY(776))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(846), convertY(754))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(837), convertY(741))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(821), convertY(722))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(800), convertY(701))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(778), convertY(684))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(755), convertY(669))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(733), convertY(657))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(711), convertY(648))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(686), convertY(639))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(654), convertY(628))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(620), convertY(621))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(591), convertY(616))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(564), convertY(612))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(536), convertY(610))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(510), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(486), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(468), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(450), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(422), convertY(611))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(392), convertY(614))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(362), convertY(618))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(328), convertY(625))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(297), convertY(632))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(270), convertY(641))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(237), convertY(655))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(202), convertY(672))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(173), convertY(690))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(142), convertY(713))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(119), convertY(736))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(95), convertY(767))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(76), convertY(802))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(68), convertY(821))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(64), convertY(835))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(60), convertY(856))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(59), convertY(871))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(58), convertY(891))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(58), convertY(905))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(61), convertY(934))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(69), convertY(964))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(79), convertY(984))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(91), convertY(1001))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(103), convertY(1017))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(117), convertY(1033))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(133), convertY(1047))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(151), convertY(1062))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(168), convertY(1076))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(187), convertY(1090))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(208), convertY(1102))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(232), convertY(1116))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(260), convertY(1130))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(292), convertY(1143))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(328), convertY(1156))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(353), convertY(1162))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(374), convertY(1167))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(396), convertY(1171))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(418), convertY(1174))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(440), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(462), convertY(1176))), Arc.LINE),
                new Destination(this.letterA, Arc.LINE)
            ),
            Air.TROTE
        );
        SubTrack subTrack3 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterA, Arc.MOVE),
                new Destination(this.cornerRDown, Arc.LINE),
                new Destination(this.letterF, Arc.LINE),
                new Destination(this.letterH, Arc.LINE),
                new Destination(this.cornerLUp, Arc.LINE),
                new Destination(this.letterC, Arc.LINE)
            ),
            Air.PASO
        );
        SubTrack subTrack4 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterC, Arc.MOVE),
                new Destination(new Reference(new Point(convertX(476), convertY(16))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(502), convertY(20))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(532), convertY(32))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(556), convertY(50))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(571), convertY(75))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(579), convertY(110))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(577), convertY(146))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(567), convertY(176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(548), convertY(195))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(518), convertY(214))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(493), convertY(226))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(445), convertY(246))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(403), convertY(272))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(386), convertY(290))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(373), convertY(314))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(366), convertY(350))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(370), convertY(376))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(381), convertY(398))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(394), convertY(413))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(407), convertY(424))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(434), convertY(434))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(455), convertY(438))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(476), convertY(440))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(502), convertY(439))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(522), convertY(433))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(540), convertY(422))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(557), convertY(406))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(572), convertY(382))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(578), convertY(360))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(579), convertY(340))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(576), convertY(318))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(570), convertY(300))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(558), convertY(284))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(539), convertY(266))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(514), convertY(252))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(494), convertY(244))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(457), convertY(231))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(426), convertY(216))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(401), convertY(198))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(382), convertY(176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(369), convertY(150))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(364), convertY(122))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(364), convertY(94))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(371), convertY(70))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(388), convertY(50))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(407), convertY(33))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(427), convertY(24))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(449), convertY(18))), Arc.LINE),
                new Destination(this.letterC, Arc.LINE),
                new Destination(this.cornerRUp, Arc.LINE),
                new Destination(this.letterM, Arc.LINE)
            ),
            Air.PASO
        );
        SubTrack subTrack5 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterM, Arc.MOVE),
                new Destination(this.cornerRDown, Arc.LINE),
                new Destination(this.letterA, Arc.LINE),
                new Destination(new Reference(new Point(convertX(462), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(440), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(418), convertY(1174))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(396), convertY(1171))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(374), convertY(1167))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(353), convertY(1162))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(328), convertY(1156))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(292), convertY(1143))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(260), convertY(1130))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(232), convertY(1116))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(208), convertY(1102))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(187), convertY(1090))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(168), convertY(1076))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(151), convertY(1062))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(133), convertY(1047))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(117), convertY(1033))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(103), convertY(1017))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(91), convertY(1001))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(79), convertY(984))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(69), convertY(964))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(61), convertY(934))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(58), convertY(905))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(58), convertY(891))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(59), convertY(871))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(60), convertY(856))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(64), convertY(835))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(68), convertY(821))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(76), convertY(802))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(95), convertY(767))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(119), convertY(736))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(142), convertY(713))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(173), convertY(690))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(202), convertY(672))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(237), convertY(655))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(270), convertY(641))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(297), convertY(632))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(328), convertY(625))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(362), convertY(618))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(392), convertY(614))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(422), convertY(611))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(450), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(468), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(486), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(510), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(536), convertY(610))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(564), convertY(612))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(591), convertY(616))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(620), convertY(621))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(654), convertY(628))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(686), convertY(639))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(711), convertY(648))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(733), convertY(657))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(755), convertY(669))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(778), convertY(684))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(800), convertY(701))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(821), convertY(722))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(837), convertY(741))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(846), convertY(754))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(860), convertY(776))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(871), convertY(800))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(879), convertY(824))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(884), convertY(845))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(888), convertY(864))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(890), convertY(885))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(891), convertY(905))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(890), convertY(915))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(889), convertY(927))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(881), convertY(951))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(870), convertY(972))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(856), convertY(991))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(840), convertY(1010))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(825), convertY(1028))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(808), convertY(1043))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(792), convertY(1057))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(776), convertY(1068))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(760), convertY(1079))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(743), convertY(1090))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(729), convertY(1098))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(709), convertY(1109))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(692), convertY(1119))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(675), convertY(1127))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(656), convertY(1135))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(639), convertY(1142))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(624), convertY(1148))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(610), convertY(1152))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(594), convertY(1158))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(578), convertY(1161))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(562), convertY(1165))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(546), convertY(1168))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(530), convertY(1171))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(516), convertY(1174))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(503), convertY(1175))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(489), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(476), convertY(1176))), Arc.LINE),
                new Destination(this.letterA, Arc.LINE)
            ),
            Air.TROTE
        );
        SubTrack subTrack6 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterA, Arc.MOVE),
                new Destination(this.cornerLDown, Arc.LINE),
                new Destination(this.letterK, Arc.LINE),
                new Destination(this.letterM, Arc.LINE)
            ),
            Air.PASO
        );
        SubTrack subTrack7 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterM, Arc.MOVE),
                new Destination(this.cornerRUp, Arc.LINE),
                new Destination(this.letterC, Arc.LINE),
                new Destination(new Reference(new Point(convertX(449), convertY(18))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(427), convertY(24))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(407), convertY(33))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(388), convertY(50))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(371), convertY(70))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(364), convertY(94))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(364), convertY(122))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(369), convertY(150))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(382), convertY(176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(401), convertY(198))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(426), convertY(216))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(457), convertY(231))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(494), convertY(244))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(514), convertY(252))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(539), convertY(266))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(558), convertY(284))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(570), convertY(300))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(576), convertY(318))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(579), convertY(340))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(578), convertY(360))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(572), convertY(382))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(557), convertY(406))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(540), convertY(422))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(522), convertY(433))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(502), convertY(439))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(476), convertY(440))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(455), convertY(438))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(434), convertY(434))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(407), convertY(424))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(394), convertY(413))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(381), convertY(398))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(370), convertY(376))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(366), convertY(350))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(373), convertY(314))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(386), convertY(290))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(403), convertY(272))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(445), convertY(246))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(493), convertY(226))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(518), convertY(214))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(548), convertY(195))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(567), convertY(176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(577), convertY(146))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(579), convertY(110))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(571), convertY(75))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(556), convertY(50))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(532), convertY(32))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(502), convertY(20))), Arc.LINE),
                new Destination(this.letterC, Arc.LINE),
                new Destination(this.cornerLUp, Arc.LINE),
                new Destination(this.letterH, Arc.LINE)
            ),
            Air.PASO
        );
        SubTrack subTrack8 = new SubTrack(
            Arrays.asList(
                new Destination(this.letterH, Arc.MOVE),
                new Destination(this.letterE, Arc.LINE),
                new Destination(this.letterF, Arc.LINE),
                new Destination(this.cornerRDown, Arc.LINE),
                new Destination(this.letterA, Arc.LINE),
                new Destination(this.letterX, Arc.LINE)
            ),
            Air.TROTE
        );

        List<List<Destination>> destinationss = alternativePathsTable4();

        subTrack1.setUpIncorrectPath(destinationss.get(0));
        subTrack2.setUpIncorrectPath(destinationss.get(1));
        subTrack3.setUpIncorrectPath(destinationss.get(2));
        subTrack4.setUpIncorrectPath(destinationss.get(3));
        subTrack5.setUpIncorrectPath(destinationss.get(4));
        subTrack6.setUpIncorrectPath(destinationss.get(5));
        subTrack7.setUpIncorrectPath(destinationss.get(6));
        subTrack8.setUpIncorrectPath(destinationss.get(7));
        subTrack0.setUpIncorrectPath(destinationss.get(8));

        return new Track(
            Arrays.asList(
                subTrack0, subTrack1, subTrack2, subTrack3, subTrack4, subTrack5, subTrack6, subTrack7, subTrack8),
            0);
    }

    private List<List<Destination>> alternativePathsTable3() {
        return Arrays.asList(
            Arrays.asList(
                new Destination(letterX, Arc.MOVE),
                new Destination(letterE, Arc.LINE),
                new Destination(letterH, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(letterK, Arc.MOVE),
                new Destination(cornerLDown, Arc.LINE),
                new Destination(cornerRDown, Arc.LINE),
                new Destination(cornerRUp, Arc.LINE),
                new Destination(letterC, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(letterB, Arc.MOVE),
                new Destination(this.cornerRDown, Arc.LINE),
                new Destination(this.letterA, Arc.LINE),
                new Destination(new Reference(new Point(convertX(462), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(440), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(418), convertY(1174))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(396), convertY(1171))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(374), convertY(1167))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(353), convertY(1162))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(328), convertY(1156))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(292), convertY(1143))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(260), convertY(1130))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(232), convertY(1116))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(208), convertY(1102))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(187), convertY(1090))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(168), convertY(1076))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(151), convertY(1062))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(133), convertY(1047))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(117), convertY(1033))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(103), convertY(1017))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(91), convertY(1001))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(79), convertY(984))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(69), convertY(964))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(61), convertY(934))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(58), convertY(905))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(58), convertY(891))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(59), convertY(871))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(60), convertY(856))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(64), convertY(835))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(68), convertY(821))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(76), convertY(802))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(95), convertY(767))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(119), convertY(736))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(142), convertY(713))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(173), convertY(690))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(202), convertY(672))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(237), convertY(655))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(270), convertY(641))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(297), convertY(632))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(328), convertY(625))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(362), convertY(618))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(392), convertY(614))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(422), convertY(611))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(450), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(468), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(486), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(510), convertY(609))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(536), convertY(610))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(564), convertY(612))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(591), convertY(616))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(620), convertY(621))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(654), convertY(628))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(686), convertY(639))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(711), convertY(648))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(733), convertY(657))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(755), convertY(669))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(778), convertY(684))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(800), convertY(701))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(821), convertY(722))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(837), convertY(741))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(846), convertY(754))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(860), convertY(776))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(871), convertY(800))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(879), convertY(824))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(884), convertY(845))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(888), convertY(864))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(890), convertY(885))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(891), convertY(905))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(890), convertY(915))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(889), convertY(927))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(881), convertY(951))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(870), convertY(972))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(856), convertY(991))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(840), convertY(1010))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(825), convertY(1028))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(808), convertY(1043))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(792), convertY(1057))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(776), convertY(1068))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(760), convertY(1079))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(743), convertY(1090))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(729), convertY(1098))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(709), convertY(1109))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(692), convertY(1119))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(675), convertY(1127))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(656), convertY(1135))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(639), convertY(1142))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(624), convertY(1148))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(610), convertY(1152))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(594), convertY(1158))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(578), convertY(1161))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(562), convertY(1165))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(546), convertY(1168))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(530), convertY(1171))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(516), convertY(1174))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(503), convertY(1175))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(489), convertY(1176))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(476), convertY(1176))), Arc.LINE),
                new Destination(this.letterA, Arc.LINE),
                new Destination(this.cornerLDown, Arc.LINE),
                new Destination(this.letterK, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(letterH, Arc.MOVE),
                new Destination(cornerLUp, Arc.LINE),
                new Destination(cornerRUp, Arc.LINE),
                new Destination(letterM, Arc.LINE),
                new Destination(letterK, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(letterF, Arc.MOVE),
                new Destination(this.cornerRUp, Arc.LINE),
                new Destination(this.letterC, Arc.LINE),
                new Destination(new Reference(new Point(convertX(474), convertY(16))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(443), convertY(18))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(406), convertY(27))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(363), convertY(42))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(330), convertY(56))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(295), convertY(76))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(262), convertY(99))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(231), convertY(127))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(202), convertY(155))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(174), convertY(188))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(162), convertY(218))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(150), convertY(258))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(146), convertY(298))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(146), convertY(328))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(150), convertY(362))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(160), convertY(397))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(176), convertY(428))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(195), convertY(454))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(224), convertY(486))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(263), convertY(522))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(302), convertY(545))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(338), convertY(561))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(364), convertY(571))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(409), convertY(582))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(441), convertY(588))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(475), convertY(590))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(504), convertY(588))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(534), convertY(586))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(562), convertY(582))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(590), convertY(574))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(617), convertY(566))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(649), convertY(554))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(672), convertY(543))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(702), convertY(523))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(728), convertY(500))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(748), convertY(480))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(762), convertY(462))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(782), convertY(434))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(796), convertY(407))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(806), convertY(374))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(814), convertY(339))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(816), convertY(313))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(815), convertY(276))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(808), convertY(250))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(794), convertY(216))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(770), convertY(174))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(747), convertY(140))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(720), convertY(112))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(684), convertY(85))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(650), convertY(66))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(611), convertY(46))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(570), convertY(30))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(533), convertY(21))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(499), convertY(17))), Arc.LINE),
                new Destination(this.letterC, Arc.LINE),
                new Destination(this.cornerLUp, Arc.LINE),
                new Destination(this.letterH, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(letterK, Arc.MOVE),
                new Destination(cornerLDown, Arc.LINE),
                new Destination(cornerRDown, Arc.LINE),
                new Destination(letterF, Arc.LINE),
                new Destination(letterH, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(this.letterC, Arc.MOVE),
                new Destination(this.cornerRUp, Arc.LINE),
                new Destination(this.letterM, Arc.LINE),
                new Destination(this.letterK, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(letterF, Arc.MOVE),
                new Destination(cornerRUp, Arc.LINE),
                new Destination(cornerLUp, Arc.LINE),
                new Destination(letterK, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(this.letterA, Arc.MOVE)
            )
        );
    }

    private List<List<Destination>> alternativePathsTable4() {
        return Arrays.asList(
            Arrays.asList(
                new Destination(this.letterX, Arc.MOVE),
                new Destination(this.letterF, Arc.LINE),
                new Destination(this.letterM, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(this.letterA, Arc.MOVE),
                new Destination(this.cornerRDown, Arc.LINE),
                new Destination(this.letterF, Arc.LINE),
                new Destination(this.letterH, Arc.LINE),
                new Destination(this.cornerLUp, Arc.LINE),
                new Destination(this.letterC, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(this.letterA, Arc.MOVE),
                new Destination(this.cornerLDown, Arc.LINE),
                new Destination(this.letterK, Arc.LINE),
                new Destination(this.letterM, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(letterC, Arc.MOVE),
                new Destination(cornerLUp, Arc.LINE),
                new Destination(letterH, Arc.LINE),
                new Destination(letterF, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(this.letterM, Arc.MOVE),
                new Destination(this.cornerRUp, Arc.LINE),
                new Destination(this.letterC, Arc.LINE),
                new Destination(new Reference(new Point(convertX(474), convertY(16))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(443), convertY(18))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(406), convertY(27))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(363), convertY(42))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(330), convertY(56))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(295), convertY(76))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(262), convertY(99))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(231), convertY(127))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(202), convertY(155))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(174), convertY(188))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(162), convertY(218))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(150), convertY(258))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(146), convertY(298))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(146), convertY(328))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(150), convertY(362))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(160), convertY(397))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(176), convertY(428))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(195), convertY(454))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(224), convertY(486))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(263), convertY(522))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(302), convertY(545))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(338), convertY(561))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(364), convertY(571))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(409), convertY(582))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(441), convertY(588))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(475), convertY(590))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(504), convertY(588))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(534), convertY(586))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(562), convertY(582))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(590), convertY(574))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(617), convertY(566))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(649), convertY(554))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(672), convertY(543))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(702), convertY(523))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(728), convertY(500))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(748), convertY(480))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(762), convertY(462))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(782), convertY(434))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(796), convertY(407))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(806), convertY(374))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(814), convertY(339))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(816), convertY(313))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(815), convertY(276))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(808), convertY(250))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(794), convertY(216))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(770), convertY(174))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(747), convertY(140))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(720), convertY(112))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(684), convertY(85))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(650), convertY(66))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(611), convertY(46))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(570), convertY(30))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(533), convertY(21))), Arc.LINE),
                new Destination(new Reference(new Point(convertX(499), convertY(17))), Arc.LINE),
                new Destination(this.letterC, Arc.LINE),
                new Destination(this.cornerLUp, Arc.LINE),
                new Destination(this.letterH, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(this.letterA, Arc.MOVE),
                new Destination(this.cornerRDown, Arc.LINE),
                new Destination(this.letterF, Arc.LINE),
                new Destination(this.letterH, Arc.LINE),
                new Destination(this.cornerLUp, Arc.LINE),
                new Destination(this.letterC, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(letterM, Arc.MOVE),
                new Destination(letterK, Arc.LINE),
                new Destination(cornerLDown, Arc.LINE),
                new Destination(letterA, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(letterH, Arc.MOVE),
                new Destination(cornerLUp, Arc.LINE),
                new Destination(cornerRUp, Arc.LINE),
                new Destination(letterM, Arc.LINE),
                new Destination(letterK, Arc.LINE)
            ),
            Arrays.asList(
                new Destination(this.letterA, Arc.MOVE)
            )
        );
    }

    private int convertY(int y) {
        return MARGEN_ARRIBA_PISTA + (y * altoPista / ALTO_ORIGINAL_IMAGEN_PISTA);
    }

    private int convertX(int x) {
        return (x * anchoPista / ANCHO_ORIGINAL_IMAGEN_PISTA) + MARGEN_IZQUIERDO_DERECHO_PISTA;
    }
}