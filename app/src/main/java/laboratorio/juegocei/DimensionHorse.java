package laboratorio.juegocei;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.HashMap;

public class DimensionHorse {
    private HashMap<Orientation, CircularList> imagess;
    private Context context;
    private Resources resources;
    private Bitmap lastImage;

    DimensionHorse(Resources resources, Context context) {
        this.context = context;
        this.resources = resources;
        imagess = new HashMap<>();
        imagess.put(Orientation.N, loadImages(Orientation.N, resources, context));
        imagess.put(Orientation.S, loadImages(Orientation.S, resources, context));
        imagess.put(Orientation.E, loadImages(Orientation.E, resources, context));
        imagess.put(Orientation.W, loadImages(Orientation.W, resources, context));
        imagess.put(Orientation.NE, loadImages(Orientation.NE, resources, context));
        imagess.put(Orientation.NW, loadImages(Orientation.NW, resources, context));
        imagess.put(Orientation.SE, loadImages(Orientation.SE, resources, context));
        imagess.put(Orientation.SW, loadImages(Orientation.SW, resources, context));
        lastImage = nextImage(Orientation.N);
    }

    private CircularList loadImages(Orientation orientation, Resources resources, Context context) {
        CircularList images = new CircularList();
        for (int i = 10; i < 31; i++) {
            StringBuffer name = new StringBuffer();
            name.append(orientation.toString().toLowerCase()).append("_00").append(i);
            int id = resources.getIdentifier(name.toString(), "drawable", context.getPackageName());
            images.add(id);
        }
        return images;
    }

    public Bitmap nextImage(Orientation orientation) {
        lastImage = BitmapFactory.decodeResource(resources, imagess.get(orientation).getNext());
        return lastImage;
    }

    public Bitmap lastImage() {
        return lastImage;
    }
}
