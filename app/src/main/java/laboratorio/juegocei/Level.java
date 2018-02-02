package laboratorio.juegocei;

import android.widget.ImageButton;

import laboratorio.juegocei.table.SubTrack;
import laboratorio.juegocei.table.Track;

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

    public abstract void drawAirButtons(Air subTrackAir, Air selectedAir);
    public abstract SubTrack step(Track track, SubTrack subTrack, Character subTrackDestination, Character selectedDestination);
}
