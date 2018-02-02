package laboratorio.juegocei;

import android.graphics.Point;

public class Reference {
    protected Point position;
    protected Character letter;

    public Reference(Point position) {
        this.position = position;
    }

    public Reference(Point position, Character letter) {
        this.position = position;
        this.letter = letter;
    }

    public Point getPosition() {
        return position;
    }

    public Character getLetter() {
        return letter;
    }
}
