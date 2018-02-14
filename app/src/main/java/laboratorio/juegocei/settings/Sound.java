package laboratorio.juegocei.settings;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.R;

public class Sound {

    private MediaPlayer resoplido;
    private MediaPlayer relincho;
    private MediaPlayer campana;
    private MediaPlayer caminando;
    private MediaPlayer trote;
    private MediaPlayer galope;
    private boolean stopped;

    private Boolean enabled;

    public Sound(Context context) {
        enabled = true;
        stopped = false;
        resoplido = MediaPlayer.create(context, R.raw.resoplido);
        relincho = MediaPlayer.create(context, R.raw.relincho);
        campana = MediaPlayer.create(context, R.raw.campana);
        caminando = MediaPlayer.create(context, R.raw.caminando);
        trote = MediaPlayer.create(context, R.raw.trote);
        galope = MediaPlayer.create(context, R.raw.galope);

        caminando.setLooping(true);
        trote.setLooping(true);
        galope.setLooping(true);
    }

    public boolean setValue(boolean value) {
        this.enabled = value;
        return value;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void disable() {
        enabled = false;
    }

    public void enable(){
        enabled = true;
    }

    public void resoplido(){
        if (enabled) {
            resoplido.seekTo(500);
            resoplido.start();
            stopped = false;
        }
    }

    public void relincho() {
        if (enabled) {
            this.stop();
            relincho.start();
            stopped = false;
        }
    }

    public void campana() {
        if (enabled) {
            campana.start();
            stopped = false;
        }
    }

    public void caminando() {
        if (enabled) {
            caminando.start();
            stopped = false;
        }
    }

    public void runHorse(Air air){
        switch (air) {
            case PASO:
                caminando();
                break;
            case TROTE:
                trote();
                break;
        }
        stopped = false;
    }

    public void galope() {
        if (enabled) galope.start();
    }

    public void trote() {
        if (enabled) trote.start();
    }

    public void stop() {
        if (!stopped) {
            try {
                if (caminando.isPlaying()) { caminando.stop(); caminando.prepare(); return; }
                if (trote.isPlaying()) { trote.stop(); trote.prepare(); return; }
                if (galope.isPlaying()) { galope.stop(); }
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.stopped = true;
        }
    }
}

