package laboratorio.juegocei.levels;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.widget.ImageButton;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.GameActivity;
import laboratorio.juegocei.Horse;
import laboratorio.juegocei.Letters;
import laboratorio.juegocei.table.SubTrack;

/**
 * Created by cristian on 1/2/18.
 */

public abstract class Level {
    protected ImageButton imagePaso, imageTrote;
    protected Letters letters;
    protected GameActivity activity;

    public Level(ImageButton imagePaso, ImageButton imageTrote, Letters letters, GameActivity activity) {
        this.imagePaso = imagePaso;
        this.imageTrote = imageTrote;
        this.letters = letters;
        this.activity = activity;
    }

    public abstract void draw(SubTrack subTrack, Horse horse, Canvas canvas, Paint paint, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp, int anchoPista, int altoPista, int MARGEN_ARRIBA_PISTA);
    public abstract void drawAirButtons(Air subTrackAir, Air selectedAir);
    public abstract void step(SubTrack subTrack, Character subTrackDestination, Character selectedDestination, Air subTrackAir, Air selectedAir);
    public abstract void setTargetLetters(SubTrack subTrack);
}
