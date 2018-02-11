package laboratorio.juegocei;

import android.app.Application;
import android.content.Context;

public class Setting extends Application {
    private int actualLevel;
    private Sound sound;

    public Setting() {
       this.actualLevel = 1;
    }

    public int getActualLevel(){
        return this.actualLevel;
    }

    public void setActualLevel(int level){
        this.actualLevel = level;
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
