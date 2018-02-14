package laboratorio.juegocei;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PathMeasure;

public class Cucarda {

    Resources resources;
    Context context;
    private CircularList images;
    private Bitmap lastImage;

    public Cucarda(Resources resources, Context context) {
        this.resources = resources;
        images = loadImages(resources, context);
        lastImage = nextImage();
    }

    private CircularList loadImages(Resources resources, Context context) {
        CircularList images = new CircularList();
        for (int i = 1; i < 40; i++) {
            int id = resources.getIdentifier("cucarda00" + i, "drawable", context.getPackageName());
            images.add(id);
        }
        for (int i = 39; i > 0; i--) {
            int id = resources.getIdentifier("cucarda00" + i, "drawable", context.getPackageName());
            images.add(id);
        }
        return images;
    }

    public Bitmap nextImage() {
        lastImage = BitmapFactory.decodeResource(resources, images.getNext());
        return lastImage;
    }

    public Bitmap lastImage() {
        return lastImage;
    }

    public void draw(Canvas canvas, Matrix matrix) {
        matrix.reset();
        Bitmap cucarda = this.nextImage();
        canvas.drawBitmap(cucarda, matrix, null);

    }
}
