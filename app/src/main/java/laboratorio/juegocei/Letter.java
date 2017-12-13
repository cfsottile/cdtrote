package laboratorio.juegocei;

import android.graphics.Point;
import android.widget.ImageButton;

public class Letter extends Reference {
    private ImageButton imageButton;

    public Letter(ImageButton imageButton, Point position) {
        super(position);
        this.imageButton = imageButton;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

}
