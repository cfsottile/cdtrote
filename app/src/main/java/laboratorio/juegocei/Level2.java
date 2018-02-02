package laboratorio.juegocei;

import android.widget.ImageButton;

import laboratorio.juegocei.table.SubTrack;
import laboratorio.juegocei.table.Track;

/**
 * Created by cristian on 1/2/18.
 */

public class Level2 extends Level {
    public Level2(ImageButton imagePaso, ImageButton imageTrote, Letters letters) {
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
        if (subTrackDestination.equals(selectedDestination)) {
            letters.highlight("green", subTrackDestination);
            subTrack.start();
        } else {
            letters.highlight("red", selectedDestination);
//            ruido caballo
        }
    }
}
