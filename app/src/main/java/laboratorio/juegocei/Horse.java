package laboratorio.juegocei;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PathMeasure;

public class Horse {
    private final HorseDirections horseDirections;
    private Bitmap horse;

    public Horse(Bitmap horse, Resources resources, Context context) {
        this.horse = horse;
        this.horseDirections = new HorseDirections(resources, context);
    }

    public void draw(Canvas canvas, float distanciaRecorrida, PathMeasure pathMeasure, Matrix matrix, int anchoPista, int altoPista, int margin, boolean moving) {
        Bitmap caballoRedimiensionado = null;
        int caballo_offsetX;
        int caballo_offsetY;
        float x;
        float y;
        Orientation orientation;
        float rotation;

        matrix.reset();
        if (pathMeasure != null) {
            float[] pos = new float[2];
            float[] tan = new float[2];
            pathMeasure.getPosTan(distanciaRecorrida, pos, tan);
            x = pos[0];
            y = pos[1];
            float degrees = (float) (Math.atan2(tan[1], tan[0]) * 180.0 / Math.PI) + 90; //angulo del tramo
            orientation = Orientation.from(degrees);

            if (moving) {
                horse = nextHorse(pathMeasure, distanciaRecorrida, orientation);
            } else {
                horse = horseDirections.lastImage();
            }

            caballoRedimiensionado = resize(anchoPista, altoPista, altoPista - (y - margin));
            caballo_offsetX = caballoRedimiensionado.getWidth() / 2;
            caballo_offsetY = caballoRedimiensionado.getHeight() / 2;
            if (moving) {
                matrix.postRotate(computeRotation(orientation, degrees), caballo_offsetX, caballo_offsetY);
            }
            matrix.postTranslate(x - caballo_offsetX, y - caballo_offsetY);
            canvas.drawBitmap(caballoRedimiensionado, matrix, null);
        }
    }

    private float computeRotation(Orientation orientation, float degrees) {
        switch (orientation) {
            case N: return degrees;
            case S: return degrees + 180;
            case E: return degrees + 270;
            case W: return degrees + 90;
            case NE: return degrees + 315;
            case NW: return degrees + 45;
            case SE: return degrees + 225;
            case SW: return degrees + 135;
            default: return degrees;
        }
    }

    private Bitmap resize(int anchoPista, int altoPista, float profundidad) { //profundidad va de 0 a alto de pista. 0 es menos profundo
        float incrementoPorProfundidad = (profundidad) * 1 / altoPista;
        float divisor = 2 + incrementoPorProfundidad;
        int anchoCaballo = (int) (anchoPista / divisor);
        int altoCaballo = anchoCaballo * horse.getHeight() / horse.getWidth();
        return Bitmap.createScaledBitmap(horse, anchoCaballo, altoCaballo, true);
    }

    private Bitmap nextHorse(PathMeasure pathMeasure, float currentDistance, Orientation orientation) {
        if (currentDistance > 0 && currentDistance < pathMeasure.getLength()) {
            return horseDirections.nextImage(orientation);
        } else {
            return horseDirections.lastImage();
        }
    }
}
