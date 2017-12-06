package laboratorio.juegocei;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;

/**
 * Created by cristian on 5/12/17.
 */

public class SubTrack {
    private Path path;
    private Float currentDistance;
    private Float totalDistance;
    private PathMeasure pathMeasure;
    private int movement;

    public SubTrack(Path path) {
        this.path = path;
        currentDistance = 0f;
        pathMeasure = new PathMeasure(path, false);
        totalDistance = pathMeasure.getLength();
        movement = 0;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public void run(Horse horse) {
//        * dibujará la pista (vemos si es para todos o no)
//        * onclick en donde sea (para niveles avanzados, sólo en letras)
    }

    public void start() {
        movement = 10;
    }

    public void draw(Horse horse, Canvas canvas, Paint paint, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp) {
        canvas.drawPath(path, paint);
        horse.draw(canvas, currentDistance, pathMeasure, matrix, fieldWidth, fieldHeight, marginUp);
    }

    public void update() {
        if (currentDistance < totalDistance) {
            currentDistance += movement;
            if (currentDistance > totalDistance) {// Si supera el punto de llegada, lo seteo al extremo del path
                currentDistance = totalDistance;
            }
        }
    }
}
