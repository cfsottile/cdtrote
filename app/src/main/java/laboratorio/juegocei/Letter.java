package laboratorio.juegocei;

import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * Created by cristian on 5/12/17.
 */

public class Letter {
    private Bitmap image;
    private Point position;

    public Letter(Bitmap image, Point position) {
        this.image = image;
        this.position = position;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
