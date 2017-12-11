package laboratorio.juegocei;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PathMeasure;

public class Horse {
    private final DimensionHorse dimensionHorse;
    private Bitmap horse;
    private boolean moving;

    public Horse(Bitmap horse, Resources resources, Context context) {
        this.horse = horse;
        this.dimensionHorse = new DimensionHorse(resources, context);
    }

    public Bitmap getHorse() {
        return horse;
    }

    public void setHorse(Bitmap horse) {
        this.horse = horse;
    }

    public void draw(Canvas canvas, float distanciaRecorrida, PathMeasure pathMeasure, Matrix matrix, int anchoPista, int altoPista, int margin) {
        Bitmap caballoRedimiensionado = null;
        int caballo_offsetX;
        int caballo_offsetY;
        float x;
        float y;

        matrix.reset();
        if (pathMeasure != null) {
            float[] pos = new float[2];
            float[] tan = new float[2];
            pathMeasure.getPosTan(distanciaRecorrida, pos, tan);
            x = pos[0];
            y = pos[1];
            float degrees = (float) (Math.atan2(tan[1], tan[0]) * 180.0 / Math.PI) + 90; //angulo del tramo

            this.horse = nextHorse(pathMeasure, distanciaRecorrida, degrees);

            caballoRedimiensionado = resize(anchoPista, altoPista, altoPista - (y - margin));
            caballo_offsetX = caballoRedimiensionado.getWidth() / 2;
            caballo_offsetY = caballoRedimiensionado.getHeight() / 2;
//            acá cambiar imagen del caballo
//            matrix.postRotate(degrees, caballo_offsetX, caballo_offsetY);
            matrix.postTranslate(x - caballo_offsetX, y - caballo_offsetY);
            canvas.drawBitmap(caballoRedimiensionado, matrix, null);
        }
    }

    private Bitmap resize(int anchoPista, int altoPista, float profundidad) { //profundidad va de 0 a alto de pista. 0 es menos profundo
        float incrementoPorProfundidad = (profundidad) * 1 / altoPista;
        float divisor = 2 + incrementoPorProfundidad;
        int anchoCaballo = (int) (anchoPista / divisor);
        int altoCaballo = anchoCaballo * horse.getHeight() / horse.getWidth();
        return Bitmap.createScaledBitmap(horse, anchoCaballo, altoCaballo, true);
    }

    private Bitmap nextHorse(PathMeasure pathMeasure, float currentDistance, float degrees) {
        if (currentDistance > 0 && currentDistance < pathMeasure.getLength()) {
            return dimensionHorse.nextImage(Orientation.from(degrees));
        } else {
            return dimensionHorse.lastImage();
        }
    }

    public void dontMove() {
        moving = false;
    }

    public void beMoving() {
        moving = true;
    }
}
