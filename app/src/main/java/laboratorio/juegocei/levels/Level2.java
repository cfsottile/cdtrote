package laboratorio.juegocei.levels;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.Arrays;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.GameActivity;
import laboratorio.juegocei.Horse;
import laboratorio.juegocei.Letters;
import laboratorio.juegocei.R;
import laboratorio.juegocei.Sound;
import laboratorio.juegocei.table.SubTrack;

public class Level2 extends Level {

    public Level2(Letters letters, GameActivity activity, Sound sound) {
        super(letters, activity, sound);
    }

    @Override
    public void draw(SubTrack subTrack, Horse horse, Canvas canvas, Paint paint, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp, int anchoPista, int altoPista, int MARGEN_ARRIBA_PISTA) {
        subTrack.drawCorrectPath(canvas, paint);
        subTrack.drawIncorrectPath(canvas, paint);
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
        if (subTrackDestination.equals(selectedDestination)) {
            letters.clearTargetLetters();
            letters.highlight("green", subTrackDestination);
            subTrack.start();
            if (!subTrack.finished()) this.sound.runHorse(subTrackAir);
        } else {
            if (!subTrack.finished()) this.sound.resoplido();
            letters.highlight("red", selectedDestination);
        }
    }

    public void setTargetLetters(SubTrack subTrack) {
        letters.setTargetLetters(
            Arrays.asList(
                subTrack.lastDestination().getLetter(),
                subTrack.lastDestinationIncorrectPath().getLetter()));
    }
}
