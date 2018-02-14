package laboratorio.juegocei.settings;

import android.app.Application;
import android.content.Context;

import laboratorio.juegocei.table.Track;
import laboratorio.juegocei.table.Tracks;

public class Setting extends Application {
    private int actualLevel;
    private Sound sound;
    private boolean lastOptionSound = true;
    private Tracks tracks;
    private Track track;
    private int screenX, screenY;
    private int lastTableSelected = 3;

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
        this.screenX = screenX;
        this.screenY = screenY;
        this.tracks = (new Tracks(screenX, screenY));
        this.track = this.tracks.table3();
    }

    public void setActualTable(int table) {
        this.tracks = (new Tracks(screenX, screenY));
        lastTableSelected = table;
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

    public void update() {
        setActualTable(lastTableSelected);
    }

    public Track getActualTrack() {
        return this.track;
    }

    public void setSound(Context context) {
        this.sound = new Sound(context);
        this.sound.setValue(lastOptionSound);
    }

    public void enabledSound() {
        this.sound.enable();
        this.lastOptionSound = true;
    }

    public void disabledSound() {
        this.sound.disable();
        this.lastOptionSound = false;
    }

    public boolean isEnabled() {
        return this.sound.isEnabled();
    }

    public Sound getSound() {
        return this.sound;
    }

    public int getLastTableSelected() {
        return lastTableSelected;
    }
}
