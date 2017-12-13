package laboratorio.juegocei.table;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.RectF;
import android.widget.ImageButton;

import java.util.List;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.Destination;
import laboratorio.juegocei.Horse;

public class SubTrack {
    private Path path;
    private Float currentDistance;
    private Float totalDistance;
    private PathMeasure pathMeasure;
    private int movement;
    private Point lastPoint;
    private Air air= null;

    public SubTrack(Path path) {
        this.path = path;
        initialize();
    }

    public SubTrack(List<Destination> destinations) {
        buildPathFrom(destinations);
        initialize();
    }

    public SubTrack(List<Destination> destinations, Air air) {
        buildPathFrom(destinations);
        initialize();
        this.air = air;
    }

    public Air getAir(){
        return this.air;
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
        for (Destination destination: ds) {
            this.addDestinationToPath(destination);
        }
    }

    private void addDestinationToPath(Destination d) {
        Point point = d.getPoint();
        Point quadPoint;
        switch (d.getArc()) {
            case MOVE:
                path.moveTo(point.x, point.y);
                break;
            case LINE:
                path.lineTo(point.x, point.y);
                break;
            case LEFT_ARC:
                quadPoint = computeLeftQuadPoint(lastPoint, point);
                path.quadTo(quadPoint.x, quadPoint.y, point.x, point.y);
                break;
            case RIGHT_ARC:
//                float[] values = computeArcValues(point, lastPoint);
                quadPoint = computeRightQuadPoint(lastPoint, point);
//                path.arcTo(new RectF(values[0], values[1], values[2], values[3]), 270, -90, false);
//                double distance = distanceBetween(lastPoint.x, point.x, lastPoint.y, point.y);
                path.quadTo(quadPoint.x, quadPoint.y, point.x, point.y);
                break;
        }
//        will use this to form the RectF for arcTo
        lastPoint = point;
    }

    private Point computeRightQuadPoint(Point a, Point b) {
        Point c = new Point();

        if (a.x < b.x && a.y > b.y) {
            c.x = b.x;
            c.y = a.y;
        } else if (a.x < b.x && a.y < b.y) {
            c.x = a.x;
            c.y = b.y;
        } else if (a.x > b.x && a.y < b.y) {
            c.x = b.x;
            c.y = a.y;
        } else if (a.x > b.x && a.y > b.y) {
            c.x = a.x;
            c.y = b.y;
        } else if (a.x == b.x && a.y > b.y) {
            c.x = (int) (a.x + distanceBetween(a.x, b.x, a.y, b.y) * 1.4);
            c.y = (int) (a.y - (distanceBetween(a.x, b.x, a.y, b.y) / 2));
        } else if (a.x == b.x && a.y < b.y) {
            c.x = (int) (a.x - distanceBetween(a.x, b.x, a.y, b.y) * 1.4);
            c.y = (int) (a.y + distanceBetween(a.x, b.x, a.y, b.y) / 2);
        } else if (a.y == b.y && a.x < b.x) {
            c.x = (int) (a.x + distanceBetween(a.x, b.x, a.y, b.y) / 2);
            c.y = (int) (a.y + distanceBetween(a.x, b.x, a.y, b.y) * 1.4);
        } else if (a.y == b.y && a.x > b.x) {
            c.x = (int) (a.x - distanceBetween(a.x, b.x, a.y, b.y) / 2);
            c.y = (int) (a.y - distanceBetween(a.x, b.x, a.y, b.y) * 1.4);
        }
        return c;
    }

    private Point computeLeftQuadPoint(Point a, Point b) {
        Point c = new Point();

        if (a.x < b.x && a.y > b.y) {
            c.x = a.x;
            c.y = b.y;
        } else if (a.x < b.x && a.y < b.y) {
            c.x = b.x;
            c.y = a.y;
        } else if (a.x > b.x && a.y < b.y) {
            c.x = a.x;
            c.y = b.y;
        } else if (a.x > b.x && a.y > b.y) {
            c.x = b.x;
            c.y = a.y;
        } else if (a.x == b.x && a.y > b.y) {
            c.x = (int) (a.x - distanceBetween(a.x, b.x, a.y, b.y) * 1.4);
            c.y = (int) (a.y - distanceBetween(a.x, b.x, a.y, b.y) / 2);
        } else if (a.x == b.x && a.y < b.y) {
            c.x = (int) (a.x + distanceBetween(a.x, b.x, a.y, b.y) * 1.4);
            c.y = (int) (a.y + distanceBetween(a.x, b.x, a.y, b.y) / 2);
        } else if (a.y == b.y && a.x < b.x) {
            c.x = (int) (a.x + distanceBetween(a.x, b.x, a.y, b.y) / 2);
            c.y = (int) (a.y - distanceBetween(a.x, b.x, a.y, b.y) * 1.4);
        } else if (a.y == b.y && a.x > b.x) {
            c.x = (int) (a.x - distanceBetween(a.x, b.x, a.y, b.y) / 2);
            c.y = (int) (a.y + distanceBetween(a.x, b.x, a.y, b.y) * 1.4);
        }

        return c;
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
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public void start() {
        movement = 100;
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