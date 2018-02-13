package laboratorio.juegocei.levels;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.widget.ImageButton;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.GameActivity;
import laboratorio.juegocei.Horse;
import laboratorio.juegocei.Letters;
import laboratorio.juegocei.R;
import laboratorio.juegocei.Sound;
import laboratorio.juegocei.table.SubTrack;

public class Level1 extends Level {
    public Level1(ImageButton imagePaso, ImageButton imageTrote, Letters letters, GameActivity activity, Sound sound) {
        super(imagePaso, imageTrote, letters, activity, sound);
    }

    public void draw(SubTrack subTrack, Horse horse, Canvas canvas, Paint paint, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp, int anchoPista, int altoPista, int MARGEN_ARRIBA_PISTA) {
        subTrack.drawCorrectPath(canvas, paint);
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
        if (!subTrack.finished()) this.sound.runHorse(selectedAir);
    }
}
