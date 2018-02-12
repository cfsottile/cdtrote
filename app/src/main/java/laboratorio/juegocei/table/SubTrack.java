package laboratorio.juegocei.table;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;

import java.util.List;

import laboratorio.juegocei.Air;
import laboratorio.juegocei.Destination;
import laboratorio.juegocei.Horse;
import laboratorio.juegocei.Reference;

public class SubTrack {
    private Path path, incorrectPath;
    private Float currentDistance;
    private Float totalDistance;
    private PathMeasure pathMeasure;
    private int movement;
    private Air air = null;
    private int pasoMovement = 10 * 20;
    private int troteMovement = 20 * 20;
    private List<Destination> destinations, incorrectDestinations;

    public SubTrack(Path path) {
        this.path = path;
        initialize();
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
        movement = air.equals(Air.PASO) ? pasoMovement : troteMovement;
    }

    public void drawCorrectPath(Canvas canvas, Paint paint) {
        canvas.drawPath(path, paint);
    }

    public void drawIncorrectPath(Canvas canvas, Paint paint) {
        if (movement == 0) {
            canvas.drawPath(incorrectPath, paint);
        }
    }

    public void drawHorse(Horse horse, Canvas canvas, Matrix matrix, int fieldWidth, int fieldHeight, int marginUp) {
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

    public void updateMovement() {
        if (movement != 0) {
            movement = air.equals(Air.PASO) ? pasoMovement : troteMovement;
        }
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
}
