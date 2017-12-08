package laboratorio.juegocei;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.LinkedList;

/**
 * Created by natalia on 08/12/17.
 */

public class DimensionHorse {

    LinkedList<Bitmap> imagesS;
    LinkedList<Bitmap> imagesN;
    LinkedList<Bitmap> imagesW;
    LinkedList<Bitmap> imagesE;

    DimensionHorse(Resources resources) {
        imagesS = new LinkedList<>();
        imagesN = new LinkedList<>();
        imagesW = new LinkedList<>();
        imagesE = new LinkedList<>();

        imagesS.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesS.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesS.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesS.add(BitmapFactory.decodeResource(resources, R.drawable.horse));

        imagesN.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesN.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesN.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesN.add(BitmapFactory.decodeResource(resources, R.drawable.horse));

        imagesW.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesW.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesW.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesW.add(BitmapFactory.decodeResource(resources, R.drawable.horse));

        imagesE.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesE.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesE.add(BitmapFactory.decodeResource(resources, R.drawable.horse));
        imagesE.add(BitmapFactory.decodeResource(resources, R.drawable.horse));

    }


    public Bitmap getNextImage(float degrees) {

        if (degrees < 45) {
            return nextNorth();
        } else

        return null;
    }

    private Bitmap nextEast() {
        Bitmap image = imagesE.removeFirst();
        imagesE.addLast(image);
        return image;
    }

    private Bitmap nextNorth() {
        Bitmap image = imagesN.removeFirst();
        imagesN.addLast(image);
        return image;
    }
}
