package laboratorio.juegocei;

import android.graphics.Point;

public class Destination {
    private Reference reference;
    private Arc arc;

    public Destination(Reference reference, Arc arc) {
        this.reference = reference;
        this.arc = arc;
    }

    public Arc getArc() {
        return arc;
    }

    public Point getPoint() {
        return reference.getPosition();
    }
}
