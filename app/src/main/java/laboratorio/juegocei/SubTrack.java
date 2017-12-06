package laboratorio.juegocei;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;

import java.util.List;

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
        initialize();
    }

    public SubTrack(List<Destination> destinations) {
        buildPathFrom(destinations);
        initialize();
    }

    private void initialize() {
        currentDistance = 0f;
        pathMeasure = new PathMeasure(path, false);
        totalDistance = pathMeasure.getLength();
        movement = 0;
    }

    @TargetApi(24)
    private void buildPathFrom(List<Destination> ds) {
        path = new Path();
        ds.stream().forEach(this::addDestinationToPath);
    }

    private void addDestinationToPath(Destination d) {
        Point point = d.getPoint();
        switch (d.getArc()) {
            case MOVE: path.moveTo(point.x, point.y); break;
            case LINE: path.lineTo(point.x, point.y); break;
            case LEFT_ARC: path.lineTo(point.x, point.y); break;
            case RIGHT_ARC: path.lineTo(point.x, point.y); break;
        }
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
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

    public boolean finished() {
        return currentDistance == totalDistance;
    }
}
