package laboratorio.juegocei.levels;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import java.util.Arrays;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.GameActivity;
import laboratorio.juegocei.Horse;
import laboratorio.juegocei.Letters;
import laboratorio.juegocei.R;
import laboratorio.juegocei.settings.Sound;
import laboratorio.juegocei.table.SubTrack;

public class Level1 extends Level {

    public Level1(Letters letters, GameActivity activity, Sound sound) {
        super(letters, activity, sound);
    }

    public void draw(SubTrack subTrack, Horse horse, Canvas canvas, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp, int anchoPista, int altoPista, int MARGEN_ARRIBA_PISTA) {
        subTrack.drawCorrectPath(canvas);
        subTrack.drawHorse(horse, canvas, matrix, anchoPista, altoPista, MARGEN_ARRIBA_PISTA);
    }

    public void drawAirButtons(Air subTrackAir, Air selectedAir) {
        if (subTrackAir.equals(Air.PASO)){
            activity.changeImage(Air.PASO, R.drawable.background_left_glow);
            activity.changeImage(Air.TROTE, R.drawable.background_right);
        } else {
            activity.changeImage(Air.PASO, R.drawable.background_left);
            activity.changeImage(Air.TROTE, R.drawable.background_right_glow);
        }
    }

    public void step(SubTrack subTrack, Character subTrackDestination, Character selectedDestination, Air subTrackAir, Air selectedAir) {
        letters.clearTargetLetters();
        subTrack.start();
        if (!subTrack.finished()) this.sound.runHorse(subTrackAir);
    }

    public void setTargetLetters(SubTrack subTrack) {
        letters.setTargetLetters(
            Arrays.asList(subTrack.lastDestination().getLetter()));
    }

    public void setUpPaints(Paint paint1, Paint paint2) {
        paint1.setColor(Color.BLACK);
    }
}
