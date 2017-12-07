package laboratorio.juegocei;

import android.graphics.Point;
import android.widget.ImageButton;

public class Letter extends Reference {
    private ImageButton imageButton;

    public Letter(ImageButton imageButton, Point position) {
        this.imageButton = imageButton;
        this.position = position;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

}
