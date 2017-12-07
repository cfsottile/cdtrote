package laboratorio.juegocei;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.RectF;

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
    private Point lastPoint;

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
            case RIGHT_ARC:
                float[] values = computeArcValues(point, lastPoint);
                path.arcTo(new RectF(values[0], values[1], values[2], values[3]), 270, -90, false);
                break;
        }
//        will use this to form the RectF for arcTo
        lastPoint = point;
    }

    private float[] computeArcValues(Point currentPoint, Point lastPoint) {
        float left, top, right, bottom, startAngle = 0, sweepAngle = 0;
        boolean rightMirroring;
        left = Math.min(currentPoint.x, lastPoint.x);
        top = Math.min(currentPoint.y, lastPoint.y);
        right = Math.max(currentPoint.x, lastPoint.x);
        bottom = Math.max(currentPoint.y, lastPoint.y);
        rightMirroring = currentPoint.x < lastPoint.x;

        if (rightMirroring) {
            right += distanceBetween(right, bottom, left, bottom);
        } else {
            left -= distanceBetween(right, bottom, left, bottom);
        }

        if (currentPoint.x < lastPoint.x && currentPoint.y > lastPoint.y) {
            startAngle = 270;
            sweepAngle = -90;
        } else if (currentPoint.x > lastPoint.x && currentPoint.y > lastPoint.y) {
            startAngle = 270;
            sweepAngle = 90;
        } else if (currentPoint.x > lastPoint.x && currentPoint.y < lastPoint.y) {
            startAngle = 180;
            sweepAngle = -90;
        } else if (currentPoint.x < lastPoint.x && currentPoint.y < lastPoint.y) {
            startAngle = 0;
            sweepAngle = -90;
        }

        return new float[]{left, top, right, bottom, startAngle, sweepAngle};
    }

    private double distanceBetween(float x1, float x2, float y1, float y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1- y2, 2));
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public void start() {
        movement = 50;
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
            return currentDistance.equals(totalDistance);
    }
}
