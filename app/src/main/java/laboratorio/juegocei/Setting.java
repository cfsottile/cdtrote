package laboratorio.juegocei;

import android.app.Application;

public class Setting extends Application {
    private int actualLevel;

    public Setting() {
        this.actualLevel = 1;
    }

    public int getActualLevel(){
        return this.actualLevel;
    }

    public void setActualLevel(int level){
        this.actualLevel = level;
    }

    public void enabledSound() {

    }
}
