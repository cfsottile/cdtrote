package laboratorio.juegocei;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.BitmapFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by diego on 6/11/2017.
 */

public class GameView extends SurfaceView implements Runnable {

    //*****MAIN LOOP **
    //indica si el juego esta reproduciéndose
    boolean playing;
    //thread del juego
    private Thread gameThread = null;
    //****FIN MAIN LOOP **


    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    private Bitmap background;
    private Bitmap pista;
    private Horse horse;

    private int screenX; //ancho de pantalla
    private int screenY; //alto de pantalla
    private final int MARGEN_IZQUIERDO_DERECHO_PISTA;
    private int MARGEN_ARRIBA_PISTA;
    private int MARGEN_ABAJO_PISTA;
    private final int ANCHO_ORIGINAL_IMAGEN_PISTA = 951; //en pixels
    private final int ALTO_ORIGINAL_IMAGEN_PISTA = 1211; //en pixels
    private int anchoPista;//ancho redimensionado de la pista en pixels
    private int altoPista;//alcho redimensionado de la pista en pixels

    private PathMeasure pathMeasureTramoActual;
    private Float longitudTramoActual;
    private Float distanciaRecorridaTramoActual;
    Path path = null;

    private Matrix matrix = new Matrix();

    int frame = 0;

    //Puntos de prueba para una imagen de ANCHO_ORIGINAL_IMAGEN_PISTA  x ALTO_ORIGINAL_IMAGEN_PISTA
    private Point[] coordenadas = new Point[]{
            new Point(ANCHO_ORIGINAL_IMAGEN_PISTA / 2, 1),
            new Point(ANCHO_ORIGINAL_IMAGEN_PISTA / 2, ALTO_ORIGINAL_IMAGEN_PISTA),
            new Point(1, ALTO_ORIGINAL_IMAGEN_PISTA / 2)};

    private Track track;

    private List<Destination> destinations;

    private List<List<Destination>> destinationss;
    private SubTrack currentSubTrack;

    public GameView(Context context, int screenX, int screenY) {
        super(context);
        this.setScreenX(screenX);
        this.setScreenY(screenY);

        surfaceHolder = getHolder();

        //configuro paint
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);


        //Imagen de fondo
        background = BitmapFactory.decodeResource(getResources(), R.drawable.fondo);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, true);

        //Imagen de pista
        MARGEN_IZQUIERDO_DERECHO_PISTA = screenX / 20;
        MARGEN_ARRIBA_PISTA = screenX / 4;
        MARGEN_ABAJO_PISTA = screenX / 4;
        pista = BitmapFactory.decodeResource(getResources(), R.drawable.pista);
        anchoPista = screenX - (MARGEN_IZQUIERDO_DERECHO_PISTA * 2);//ancho en pixels
        altoPista = screenY - MARGEN_ARRIBA_PISTA - MARGEN_ABAJO_PISTA;//alto en pixels
        pista = Bitmap.createScaledBitmap(pista, anchoPista, altoPista, true);

        destinations = Arrays.asList(
                new Destination(
                        new Letter(
                                null,
                                new Point(
                                        getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
                                        getYConvertido(altoPista, 1))),
                        Arc.LINE),
                new Destination(
                        new Letter(
                                null,
                                new Point(
                                        getXConvertido(anchoPista, ANCHO_ORIGINAL_IMAGEN_PISTA / 2),
                                        getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA))),
                        Arc.LINE),
                new Destination(
                        new Letter(
                                null,
                                new Point(
                                        getXConvertido(anchoPista, 1),
                                        getYConvertido(altoPista, ALTO_ORIGINAL_IMAGEN_PISTA / 2))),
                        Arc.LINE));

        destinationss = Arrays.asList(destinations);

        //Imagen del horse
        horse = new Horse(BitmapFactory.decodeResource(getResources(), R.drawable.horse));

        track = setupTrack();

//        //convierto coordenadas
//        for (Point p : coordenadas) {
//            p.set(getXConvertido(anchoPista, p.x), getYConvertido(altoPista, p.y));
//        }
//
//
//        Point p;
//        //Armo el path
//        path = new Path();
//
//        for (int i = 0; i < coordenadas.length; i++) {
//
//            if (i == 0) {
//                path.moveTo(coordenadas[i].x, coordenadas[i].y);
//            } else {
//                path.lineTo(coordenadas[i].x, coordenadas[i].y);
//            }
//
//
//        }


    }

    @TargetApi(24)
    private Track setupTrack() {
        return new Track(
            destinationss.stream().map(
                ds -> new SubTrack(buildPath(ds))).collect(Collectors.toList()));
    }

    @TargetApi(24)
    private Path buildPath(List<Destination> ds) {
        Path path = new Path();
        ds.stream().forEach(d -> addDestination(path, d));
        return path;
    }

    private void addDestination(Path path, Destination d) {
        Point point = d.getPoint();
        switch (d.getArc()) {
            case LINE: path.lineTo(point.x, point.y); break;
            case LEFT_ARC: path.lineTo(point.x, point.y); break;
            case RIGHT_ARC: path.lineTo(point.x, point.y); break;
        }
    }


    private int getYConvertido(int altoPista, int y) {
        return MARGEN_ARRIBA_PISTA + altoPista - (y * altoPista / ALTO_ORIGINAL_IMAGEN_PISTA);
    }

    private int getXConvertido(int anchoPista, int x) {
        return (x * anchoPista / ANCHO_ORIGINAL_IMAGEN_PISTA) + MARGEN_IZQUIERDO_DERECHO_PISTA;
    }


    private void draw() {

        if (surfaceHolder.getSurface().isValid()) {
            //lock del canvas
            canvas = surfaceHolder.lockCanvas();
            canvas.drawBitmap(background, 0, 0, paint);
            canvas.drawBitmap(pista, MARGEN_IZQUIERDO_DERECHO_PISTA, MARGEN_ARRIBA_PISTA, paint);

            currentSubTrack.draw(horse, canvas, paint, matrix, anchoPista, altoPista, MARGEN_ARRIBA_PISTA);

            //Unlock del canvas
            surfaceHolder.unlockCanvasAndPost(canvas);

        }
    }


//    private void dibujarCaballo(Canvas canvas, Bitmap horse, float distanciaRecorrida, PathMeasure pathMeasure, Matrix matrix, int anchoPista, int altoPista, int frame) {
//        Bitmap caballoRedimiensionado = null;
//        int caballo_offsetX;
//        int caballo_offsetY;
//        float x;
//        float y;
//
//        matrix.reset();
//        if (pathMeasure != null) {
//            float[] pos = new float[2];
//            float[] tan = new float[2];
//            pathMeasure.getPosTan(distanciaRecorrida, pos, tan);
//            x = pos[0];
//            y = pos[1];
//            float degrees = (float) (Math.atan2(tan[1], tan[0]) * 180.0 / Math.PI) + 90; //angulo del tramo
//
//            caballoRedimiensionado = redimensionarCaballo(horse, anchoPista, altoPista, altoPista - (y - MARGEN_ARRIBA_PISTA));
//            caballo_offsetX = caballoRedimiensionado.getWidth() / 2;
//            caballo_offsetY = caballoRedimiensionado.getHeight() / 2;
//            //matrix.postRotate(degrees + 90, caballo_offsetX, caballo_offsetY);
//            matrix.postTranslate(x - caballo_offsetX, y - caballo_offsetY);
//            canvas.drawBitmap(caballoRedimiensionado, matrix, null);
//        }
//
//
//    }

    /*
        Redimensiona el horse de acuerdo a la profundidad en la que se encuentra
     */
//    private Bitmap redimensionarCaballo(Bitmap horse, int anchoPista, int altoPista, float profundidad) { //profundidad va de 0 a alto de pista. 0 es menos profundo
//        float incrementoPorProfundidad = (profundidad) * 1 / altoPista;
//        float divisor = 2 + incrementoPorProfundidad;
//        int anchoCaballo = (int) (anchoPista / divisor);
//        int altoCaballo = anchoCaballo * horse.getHeight() / horse.getWidth();
//        return Bitmap.createScaledBitmap(horse, anchoCaballo, altoCaballo, true);
//    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentSubTrack = track.get(0);
        currentSubTrack.start();
        return super.onTouchEvent(event);
    }

    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }


    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    public void setScreenY(int screenY) {
        this.screenY = screenY;
    }


    @Override
    public void run() {
        currentSubTrack = track.get(0);
        while (playing) {
            draw();
            update();
            control();
        }
//        track.run();
    }

    private void update() {
        currentSubTrack.update();
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


