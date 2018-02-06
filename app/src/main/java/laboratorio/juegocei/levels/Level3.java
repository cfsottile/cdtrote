package laboratorio.juegocei.levels;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageButton;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.Horse;
import laboratorio.juegocei.Letters;
import laboratorio.juegocei.R;
import laboratorio.juegocei.table.SubTrack;

/**
 * Created by cristian on 5/2/18.
 */

public class Level3 extends Level {
    private boolean showingError;

    public Level3(ImageButton imagePaso, ImageButton imageTrote, Letters letters) {
        super(imagePaso, imageTrote, letters);
        showingError = false;
    }

    @Override
    public void draw(SubTrack subTrack, Horse horse, Canvas canvas, Paint paint, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp, int anchoPista, int altoPista, int MARGEN_ARRIBA_PISTA) {
        subTrack.drawCorrectPath(canvas, paint);
        subTrack.drawIncorrectPath(canvas, paint);
        subTrack.drawHorse(horse, canvas, matrix, anchoPista, altoPista, MARGEN_ARRIBA_PISTA);
    }

    public void drawAirButtons(Air subTrackAir, Air selectedAir) {
        if (!showingError) {
            if (selectedAir.equals(Air.PASO)){
                imagePaso.setBackgroundResource(R.drawable.background_left_glow);
                imageTrote.setBackgroundResource(R.drawable.background_right);
            } else {
                imagePaso.setBackgroundResource(R.drawable.background_left);
                imageTrote.setBackgroundResource(R.drawable.background_right_glow);
            }
        }
    }

    public void step(SubTrack subTrack, Character subTrackDestination, Character selectedDestination, Air subTrackAir, Air selectedAir) {
        if (subTrackDestination.equals(selectedDestination)) {
            letters.highlight("green", subTrackDestination);
            if (subTrackAir.equals(selectedAir)) {
                subTrack.start();
            } else {
                showRedAirImage(selectedAir);
            }
        } else {
            letters.highlight("red", selectedDestination);
//            ruido caballo
            if (!subTrackAir.equals(selectedAir)) {
                showRedAirImage(selectedAir);
            }
        }
    }

    private void showRedAirImage(Air selectedAir) {
        if (selectedAir.equals(Air.PASO)) {
            highlightAirImage(imagePaso, R.drawable.background_left_glow_red, R.drawable.background_left_glow);
        } else {
            highlightAirImage(imageTrote, R.drawable.background_right_glow_red, R.drawable.background_right_glow);
        }
    }

    private void highlightAirImage(ImageButton imageButton, int resourceRed, int resourceNormal) {
        showingError = true;
        imageButton.setBackgroundResource(resourceRed);
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                imageButton.setBackgroundResource(resourceNormal);
                showingError = false;
            }
        }, 1000);
    }
}
