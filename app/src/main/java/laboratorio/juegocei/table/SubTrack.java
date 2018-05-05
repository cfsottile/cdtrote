package laboratorio.juegocei.table;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.Destination;
import laboratorio.juegocei.Horse;
import laboratorio.juegocei.levels.Level;

public class SubTrack {
    private Path path, incorrectPath;
    private Float currentDistance;
    private Float totalDistance;
    private PathMeasure pathMeasure;
    private int movement;
    private boolean moving;
    private Air air = null;
    private int pasoMovement = 10;
    private int troteMovement = 20;
    private List<Destination> destinations, incorrectDestinations;
    protected Paint paint1, paint2;

    public SubTrack(Path path) {
        this.path = path;
        initialize();
        initPaints();
    }

    public SubTrack(List<Destination> destinations) {
        this.destinations = destinations;
        buildPathFrom(destinations);
        initialize();
    }

    public SubTrack(List<Destination> destinations, Air air) {
        this.destinations = destinations;
        this.path = buildPathFrom(destinations);
        initialize();
        this.air = air;
    }

    private void initialize() {
        currentDistance = 0f;
        pathMeasure = new PathMeasure(path, false);
        totalDistance = pathMeasure.getLength();
        movement = 0;
        moving = false;
        initPaints();
    }

    private Path buildPathFrom(List<Destination> ds) {
        Path path = new Path();
        for (Destination destination: ds) {
            this.addDestinationToPath(destination, path);
        }
        return path;
    }

    private void addDestinationToPath(Destination d, Path path) {
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
        moving = true;
        movement = air.equals(Air.PASO) ? pasoMovement : troteMovement;
    }

    public void drawCorrectPath(Canvas canvas) {
        canvas.drawPath(path, paint1);
    }

    public void drawIncorrectPath(Canvas canvas) {
        if (!moving) {
            canvas.drawPath(incorrectPath, paint2);
        }
    }

    public void drawHorse(Horse horse, Canvas canvas, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp) {
        horse.draw(canvas, currentDistance, pathMeasure, matrix, fieldWidth, fieldHeight, marginUp, moving);
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

    public boolean updateMovement() {
        if (moving) {
            movement = air.equals(Air.PASO) ? pasoMovement : troteMovement;
        }
        return moving;
    }

    public Destination lastDestination() {
        return destinations.get(destinations.size() - 1);
    }

    public Destination lastDestinationIncorrectPath() {
        return incorrectDestinations.get(incorrectDestinations.size() - 1);
    }

    public Air getAir() {
        return air;
    }

    public void setUpIncorrectPath(List<Destination> destinations) {
        incorrectDestinations = destinations;
        incorrectPath = buildPathFrom(incorrectDestinations);
    }

    protected void initPaints() {
        paint1 = new Paint();
        paint1.setStrokeWidth(5);
        paint1.setStyle(Paint.Style.STROKE);
        paint2 = new Paint();
        paint2.setStrokeWidth(5);
        paint2.setStyle(Paint.Style.STROKE);
    }

    protected void setUpPaints() {
        Level.current.setUpPaints(paint1, paint2);
    }
}
