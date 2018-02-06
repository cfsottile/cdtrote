package laboratorio.juegocei;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.view.MotionEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cristian on 1/2/18.
 */

public class Letters {
    private List<Character> list;
    private HashMap<Character, Bitmap> images;
    private HashMap<Character, Point> drawingPoints, destinationPoints;
    private int screenX, screenY;
    private final int ANCHO_ORIGINAL_IMAGEN_PISTA = 951;
    private final int ALTO_ORIGINAL_IMAGEN_PISTA = 1211;
    private Paint paint;
    private Resources resources;
    private int timer;
    private Character lastChanged;

    public Letters(int screenX, int screenY, Paint paint, Resources resources) {
        this.screenX = screenX;
        this.screenY = screenY;
        this.paint = paint;
        this.resources = resources;
        list = Arrays.asList('a', 'b', 'c', 'e', 'f', 'x', 'h', 'k', 'm');
        initializeImages();
        initializeDrawingPoints();
        initializeDestinationPoints();
    }

    private void initializeImages() {
        images = new HashMap<>();
        for (Character c : list) {
            images.put(c, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resources, getDrawableId("", c)), convertX(200), convertY(200), true));
        }
    }

    private void initializeDrawingPoints() {
        drawingPoints = new HashMap<>();
        drawingPoints.put('a', new Point(screenX / 2 - convertX(100), screenY - convertY(300)));
        drawingPoints.put('b', new Point(convertX(874 + 30), screenY / 2 - convertY(100)));
        drawingPoints.put('c', new Point(screenX / 2 - convertX(100), 0));
        drawingPoints.put('e', new Point(convertX(-20), screenY / 2 - convertY(100)));
        drawingPoints.put('f', new Point(convertX(914 + 30), convertY(906 + 210)));
        drawingPoints.put('x', new Point(screenX / 2 - convertX(100), screenY / 2 - convertY(100)));
        drawingPoints.put('h', new Point(convertX(126 - 120), convertY(305 + 150)));
        drawingPoints.put('k', new Point(convertX(-50), convertY(906 + 210)));
        drawingPoints.put('m', new Point(convertX(838 + 50), convertY(300 + 150)));
    }

    private void initializeDestinationPoints() {
        destinationPoints = new HashMap<>();
        destinationPoints.put('a', new Point(convertX(538), convertY(1591)));
        destinationPoints.put('b', new Point(convertX(1010), convertY(893)));
        destinationPoints.put('c', new Point(convertX(542), convertY(100)));
        destinationPoints.put('e', new Point(convertX(82), convertY(893)));
        destinationPoints.put('f', new Point(convertX(1038), convertY(1221)));
        destinationPoints.put('x', new Point(convertX(538), convertY(888)));
        destinationPoints.put('h', new Point(convertX(109), convertY(546)));
        destinationPoints.put('k', new Point(convertX(51), convertY(1212)));
        destinationPoints.put('m', new Point(convertX(984), convertY(550)));
    }

    private int convertY(int y) {
        return y * screenY / 1794;
    }

    private int convertX(int x) {
        return x * screenX / 1080;
    }

    public void draw(Canvas canvas) {
        for (Character c : list) {
            canvas.drawBitmap(images.get(c), drawingPoints.get(c).x, drawingPoints.get(c).y, paint);
        }
    }

    public void highlight(String color, Character c) {
        images.put(c, Bitmap.createScaledBitmap(
            BitmapFactory.decodeResource(resources, getDrawableId(color, c)), convertX(200), convertY(200), true));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                images.put(c,
                    Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, getDrawableId("", c)), convertX(200), convertY(200), true));
            }
        }, 1000);
    }

    public Character computeDestination(MotionEvent event) {
        double minDistance = screenX + screenY;
        Character minDestination = null;
        for (Map.Entry<Character, Point> e : destinationPoints.entrySet()) {
            double distance = distance(e.getValue().x, event.getX(), e.getValue().y, event.getY());
            if (distance < minDistance) {
                minDistance = distance;
                minDestination = e.getKey();
            }
        }
        return minDestination;
    }

    private double distance(float x1, float x2, float y1, float y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private int getDrawableId(String color, Character c) {
        switch (color) {
            case "green":
                switch (c) {
                    case 'a': return R.drawable.letter_a_green;
                    case 'b': return R.drawable.letter_b_green;
                    case 'c': return R.drawable.letter_c_green;
                    case 'e': return R.drawable.letter_e_green;
                    case 'f': return R.drawable.letter_f_green;
                    case 'x': return R.drawable.letter_x_green;
                    case 'h': return R.drawable.letter_h_green;
                    case 'k': return R.drawable.letter_k_green;
                    case 'm': return R.drawable.letter_m_green;
                }
            case "red":
                switch (c) {
                    case 'a': return R.drawable.letter_a_red;
                    case 'b': return R.drawable.letter_b_red;
                    case 'c': return R.drawable.letter_c_red;
                    case 'e': return R.drawable.letter_e_red;
                    case 'f': return R.drawable.letter_f_red;
                    case 'x': return R.drawable.letter_x_red;
                    case 'h': return R.drawable.letter_h_red;
                    case 'k': return R.drawable.letter_k_red;
                    case 'm': return R.drawable.letter_m_red;
                }
            case "":
                switch (c) {
                    case 'a': return R.drawable.letter_a;
                    case 'b': return R.drawable.letter_b;
                    case 'c': return R.drawable.letter_c;
                    case 'e': return R.drawable.letter_e;
                    case 'f': return R.drawable.letter_f;
                    case 'x': return R.drawable.letter_x;
                    case 'h': return R.drawable.letter_h;
                    case 'k': return R.drawable.letter_k;
                    case 'm': return R.drawable.letter_m;
                }
            default: return 0;
        }
    }
}
