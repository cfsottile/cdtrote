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
import android.media.Image;
import android.widget.ImageButton;

import java.util.List;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.Destination;
import laboratorio.juegocei.Horse;
import laboratorio.juegocei.R;

public class SubTrack {
    private Path path;
    private Float currentDistance;
    private Float totalDistance;
    private PathMeasure pathMeasure;
    private int movement;
    private Point lastPoint;
    private Air air = null;
    private int pasoMovement = 10;
    private int troteMovement = 20;

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

    private void buildPathFrom(List<Destination> ds) {
        path = new Path();
        for (Destination destination: ds) {
            this.addDestinationToPath(destination);
        }
    }

    private void addDestinationToPath(Destination d) {
        Point point = d.getPoint();
        switch (d.getArc()) {
            case MOVE:
                path.moveTo(point.x, point.y);
                break;
            case LINE:
                path.lineTo(point.x, point.y);
                break;
        }
    }

    public void start() {
        movement = air.equals(Air.PASO) ? pasoMovement : troteMovement;
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

    public void glowAirButton(ImageButton imagePaso, ImageButton imageTrote) {
        if (air.equals(Air.PASO)){
            imagePaso.setBackgroundResource(R.drawable.background_left_glow);
            imageTrote.setBackgroundResource(R.drawable.background_right);
        } else {
            imagePaso.setBackgroundResource(R.drawable.background_left);
            imageTrote.setBackgroundResource(R.drawable.background_right_glow);
        }
    }

    public void updateMovement() {
        if (movement != 0) {
            movement = air.equals(Air.PASO) ? pasoMovement : troteMovement;
        }
    }
}
