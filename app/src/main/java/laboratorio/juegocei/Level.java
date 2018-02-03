package laboratorio.juegocei;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.widget.ImageButton;

import laboratorio.juegocei.table.SubTrack;

/**
 * Created by cristian on 1/2/18.
 */

public abstract class Level {
    ImageButton imagePaso, imageTrote;
    Letters letters;

    public Level(ImageButton imagePaso, ImageButton imageTrote, Letters letters) {
        this.imagePaso = imagePaso;
        this.imageTrote = imageTrote;
        this.letters = letters;
    }

    public abstract void draw(SubTrack subTrack, Horse horse, Canvas canvas, Paint paint, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp, int anchoPista, int altoPista, int MARGEN_ARRIBA_PISTA);
    public abstract void drawAirButtons(Air subTrackAir, Air selectedAir);
    public abstract void step(SubTrack subTrack, Character subTrackDestination, Character selectedDestination);
}
