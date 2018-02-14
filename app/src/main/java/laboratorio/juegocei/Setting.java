package laboratorio.juegocei;

import android.app.Application;
import android.content.Context;

import laboratorio.juegocei.table.Track;
import laboratorio.juegocei.table.Tracks;

public class Setting extends Application {
    private int actualLevel;
    private Sound sound;
    private Tracks tracks;
    private Track track;

    public Setting() {

       this.actualLevel = 1;
    }

    public int getActualLevel(){
        return this.actualLevel;
    }

    public void setActualLevel(int level){
        this.actualLevel = level;

    }

    public void setTracks(int screenX, int screenY) {
        this.tracks = (new Tracks(screenX, screenY));
        this.track = this.tracks.table3();
    }

    public void setActualTable(int table) {
        switch (table) {
            case 3:
                this.track = this.tracks.table3();
                break;
            case 4:
                this.track = this.tracks.table4();
                break;
            default:
                this.track = this.tracks.table3();
                break;
        }
    }

    public Track getActualTrack() {
        return this.track;
    }

    public void setSound(Context context) {
        this.sound = new Sound(context);
    }

    public void enabledSound() {
        this.sound.enable();
    }

    public void disabledSound() {
        this.sound.disable();
    }

    public Sound getSound() {
        return this.sound;
    }
}
