package laboratorio.juegocei.levels;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.GameActivity;
import laboratorio.juegocei.Horse;
import laboratorio.juegocei.Letters;
import laboratorio.juegocei.settings.Sound;
import laboratorio.juegocei.table.SubTrack;

public abstract class Level {
    public static Level current;
    public static List<Integer> colors = new LinkedList<>(Arrays.asList(
            Color.BLACK,
            Color.BLUE,
            Color.RED,
            Color.GREEN));
    protected static Random rand = new Random();

    Letters letters;
    GameActivity activity;
    Sound sound;

    public Level(Letters letters, GameActivity activity, Sound sound) {
        this.letters = letters;
        this.activity = activity;
        this.sound = sound;
    }

    public abstract void draw(SubTrack subTrack, Horse horse, Canvas canvas, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp, int anchoPista, int altoPista, int MARGEN_ARRIBA_PISTA);
    public abstract void drawAirButtons(Air subTrackAir, Air selectedAir);
    public abstract void step(SubTrack subTrack, Character subTrackDestination, Character selectedDestination, Air subTrackAir, Air selectedAir);
    public abstract void setTargetLetters(SubTrack subTrack);

    public void setUpPaints(Paint paint1, Paint paint2) {
        paint1.setColor(colors.remove(rand.nextInt(colors.size())));
        paint2.setColor(colors.remove(rand.nextInt(colors.size())));
        colors.add(paint1.getColor());
        colors.add(paint2.getColor());
    }
}
