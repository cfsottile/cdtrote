package laboratorio.juegocei;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

public class Sound {

    private MediaPlayer resoplido;
    private MediaPlayer relincho;
    private MediaPlayer campana;
    private MediaPlayer caminando;
    private MediaPlayer trote;
    private MediaPlayer galope;

    private static Boolean enabled;

    public Sound(Context context) {
        enabled = true;
        resoplido = MediaPlayer.create(context, R.raw.resoplido);
        relincho = MediaPlayer.create(context, R.raw.relincho);
        campana = MediaPlayer.create(context, R.raw.campana);
        caminando = MediaPlayer.create(context, R.raw.caminando);
        trote = MediaPlayer.create(context, R.raw.trote);
        galope = MediaPlayer.create(context, R.raw.galope);
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
        }
    }

    public void relincho() {
        if (enabled) relincho.start();
    }

    public void campana() {
        if (enabled) campana.start();
    }

    public void caminando() {
        if (enabled) caminando.start();
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
    }

    public void galope() {
        if (enabled) galope.start();
    }

    public void trote() {
        if (enabled) trote.start();
    }

    public void stop() {
        try {
            if (resoplido.isPlaying() ) { resoplido.stop(); resoplido.prepare(); return; }
            if (relincho.isPlaying()) { relincho.stop(); relincho.prepare(); return; }
            if (campana.isPlaying()) { campana.stop(); campana.prepare(); return; }
            if (caminando.isPlaying()) { caminando.stop(); caminando.prepare(); return; }
            if (trote.isPlaying()) { trote.stop(); trote.prepare(); return; }
            if (galope.isPlaying()) { galope.stop(); }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

