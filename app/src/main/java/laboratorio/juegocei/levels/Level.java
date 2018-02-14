package laboratorio.juegocei.levels;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.GameActivity;
import laboratorio.juegocei.Horse;
import laboratorio.juegocei.Letters;
import laboratorio.juegocei.Sound;
import laboratorio.juegocei.table.SubTrack;

public abstract class Level {
    Letters letters;
    GameActivity activity;
    Sound sound;

    public Level(Letters letters, GameActivity activity, Sound sound) {
        this.letters = letters;
        this.activity = activity;
        this.sound = sound;
    }

    public abstract void draw(SubTrack subTrack, Horse horse, Canvas canvas, Paint paint, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp, int anchoPista, int altoPista, int MARGEN_ARRIBA_PISTA);
    public abstract void drawAirButtons(Air subTrackAir, Air selectedAir);
    public abstract void step(SubTrack subTrack, Character subTrackDestination, Character selectedDestination, Air subTrackAir, Air selectedAir);
    public abstract void setTargetLetters(SubTrack subTrack);
}
