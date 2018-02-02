package laboratorio.juegocei;

import android.widget.ImageButton;

import laboratorio.juegocei.table.SubTrack;
import laboratorio.juegocei.table.Track;

/**
 * Created by cristian on 1/2/18.
 */

public class Level1 extends Level {
    public Level1(ImageButton imagePaso, ImageButton imageTrote, Letters letters) {
        super(imagePaso, imageTrote, letters);
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

    public void step(Track track, SubTrack subTrack, Character subTrackDestination, Character selectedDestination) {
        subTrack.start();
    }
}
