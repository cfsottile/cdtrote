package laboratorio.juegocei.levels;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.GameActivity;
import laboratorio.juegocei.Horse;
import laboratorio.juegocei.Letters;
import laboratorio.juegocei.R;
import laboratorio.juegocei.settings.Sound;
import laboratorio.juegocei.table.SubTrack;

public class Level3 extends Level {
    private boolean showingError;

    public Level3(Letters letters, GameActivity activity, Sound sound) {
        super(letters, activity, sound);
        showingError = false;
    }

    @Override
    public void draw(SubTrack subTrack, Horse horse, Canvas canvas, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp, int anchoPista, int altoPista, int MARGEN_ARRIBA_PISTA) {
        subTrack.drawCorrectPath(canvas);
        subTrack.drawIncorrectPath(canvas);
        subTrack.drawHorse(horse, canvas, matrix, anchoPista, altoPista, MARGEN_ARRIBA_PISTA);
    }

    public void drawAirButtons(Air subTrackAir, Air selectedAir) {
        if (!showingError) {
            if (selectedAir.equals(Air.PASO)){
                activity.changeImage(Air.PASO, R.drawable.background_left_glow);
                activity.changeImage(Air.TROTE, R.drawable.background_right);
            } else {
                activity.changeImage(Air.PASO, R.drawable.background_left);
                activity.changeImage(Air.TROTE, R.drawable.background_right_glow);
            }
        }
    }

    public void step(SubTrack subTrack, Character subTrackDestination, Character selectedDestination, Air subTrackAir, Air selectedAir) {
        this.sound.stop();
        if (subTrackDestination.equals(selectedDestination)) {
            if (subTrackAir.equals(selectedAir)) {
                letters.clearTargetLetters();
                letters.highlight("green", subTrackDestination);
                subTrack.start();
                if (!subTrack.finished()) this.sound.runHorse(selectedAir);
            } else {
                if (!subTrack.finished()) this.sound.resoplido();
                letters.highlight("green", subTrackDestination);
                showRedAirImage(selectedAir);
            }
        } else {
            letters.highlight("red", selectedDestination);
            if (!subTrack.finished()) this.sound.resoplido();
            if (!subTrackAir.equals(selectedAir)) {
                showRedAirImage(selectedAir);
            }
        }
    }

    private void showRedAirImage(Air selectedAir) {
        if (selectedAir.equals(Air.PASO)) {
            highlightAirImage(Air.PASO, R.drawable.background_left_glow_red, R.drawable.background_left_glow);
        } else {
            highlightAirImage(Air.TROTE, R.drawable.background_right_glow_red, R.drawable.background_right_glow);
        }
    }

    private void highlightAirImage(Air air, int resourceRed, int resourceNormal) {
        showingError = true;
        activity.changeImage(air, resourceRed);
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.changeImage(air, resourceNormal);
                showingError = false;
            }
        }, 1000);
    }

    public void setTargetLetters(SubTrack subTrack) {
        letters.setTargetLetters(
            Arrays.asList(
                subTrack.lastDestination().getLetter(),
                subTrack.lastDestinationIncorrectPath().getLetter()));
    }
}
