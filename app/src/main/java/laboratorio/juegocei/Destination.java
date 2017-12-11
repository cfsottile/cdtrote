package laboratorio.juegocei;

import android.graphics.Point;

public class Destination {
    private Reference reference;
    private Arc arc;

    public Destination(Reference reference, Arc arc) {
        this.reference = reference;
        this.arc = arc;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Letter reference) {
        this.reference = reference;
    }

    public Arc getArc() {
        return arc;
    }

    public void setArc(Arc arc) {
        this.arc = arc;
    }

    public Point getPoint() {
        return reference.getPosition();
    }
}
