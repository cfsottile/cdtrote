package laboratorio.juegocei;

import android.graphics.Point;

public class Reference {
    protected Point position;

    public Reference(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }
}
