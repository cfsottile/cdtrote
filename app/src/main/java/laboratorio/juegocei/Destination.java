package laboratorio.juegocei;

import android.graphics.Point;

/**
 * Created by cristian on 5/12/17.
 */

public class Destination {
    private Letter letter;
    private Arc arc;

    public Destination(Letter letter, Arc arc) {
        this.letter = letter;
        this.arc = arc;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public Arc getArc() {
        return arc;
    }

    public void setArc(Arc arc) {
        this.arc = arc;
    }

    public Point getPoint() {
        return letter.getPosition();
    }
}
