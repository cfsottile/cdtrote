package laboratorio.juegocei;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.widget.ImageButton;

import laboratorio.juegocei.table.SubTrack;

/**
 * Created by cristian on 1/2/18.
 */

public class Level1 extends Level {
    public Level1(ImageButton imagePaso, ImageButton imageTrote, Letters letters) {
        super(imagePaso, imageTrote, letters);
    }

    public void draw(SubTrack subTrack, Horse horse, Canvas canvas, Paint paint, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp, int anchoPista, int altoPista, int MARGEN_ARRIBA_PISTA) {
        subTrack.drawCorrectPath(canvas, paint);
        subTrack.drawHorse(horse, canvas, matrix, anchoPista, altoPista, MARGEN_ARRIBA_PISTA);
    }

    public void drawAirButtons(Air subTrackAir, Air selectedAir) {
        if (subTrackAir.equals(Air.PASO)){
            imagePaso.setBackgroundResource(R.drawable.background_left_glow);
            imageTrote.setBackgroundResource(R.drawable.background_right);
        } else {
            imagePaso.setBackgroundResource(R.drawable.background_left);
            imageTrote.setBackgroundResource(R.drawable.background_right_glow);
        }
    }

    public void step(SubTrack subTrack, Character subTrackDestination, Character selectedDestination, Air subTrackAir, Air selectedAir) {
        subTrack.start();
    }
}
