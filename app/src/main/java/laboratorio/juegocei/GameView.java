package laboratorio.juegocei;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.BitmapFactory;
import android.widget.ImageButton;

import laboratorio.juegocei.table.SubTrack;
import laboratorio.juegocei.table.Track;
import laboratorio.juegocei.table.Tracks;

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
    private Bitmap cucarda;
    private Horse horse;

    private int screenX; //ancho de pantalla
    private int screenY; //alto de pantalla
    private int MARGEN_IZQUIERDO_DERECHO_PISTA;
    private int MARGEN_ARRIBA_PISTA;
    private int MARGEN_ABAJO_PISTA;
    private final int ANCHO_ORIGINAL_IMAGEN_PISTA = 951; //en pixels
    private final int ALTO_ORIGINAL_IMAGEN_PISTA = 1211; //en pixels
    private int anchoPista;//ancho redimensionado de la pista en pixels
    private int altoPista;//alcho redimensionado de la pista en pixels

    private Matrix matrix = new Matrix();

    int frame = 0;

    private Track track;
    private SubTrack currentSubTrack;
    private ImageButton imagePaso;
    private Bitmap back;
    private ImageButton backButton;
    private Bitmap restart;
    private ImageButton restartButton;
    private ImageButton imageTrote;
    private Letters letters;
    private Level level;

    public GameView(Context context, int screenX, int screenY) {
        super(context);
        setUpScreenValues(screenX, screenY);
        surfaceHolder = getHolder();
        setUpPaint();
        setUpImages();
        setUpLetters();
        setUpFinishButtons();
        setUpLogicElements();
    }

    private void setUpFinishButtons() {
        back = Bitmap.createScaledBitmap(
            BitmapFactory.decodeResource(getResources(), R.drawable.back), convertX(200), convertY(200), true);
        restart = Bitmap.createScaledBitmap(
            BitmapFactory.decodeResource(getResources(), R.drawable.restart), convertX(200), convertY(200), true);
    }

    private void setUpLetters() {
        letters = new Letters(screenX, screenY, paint, getResources());
    }

    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.drawBitmap(background, 0, 0, paint);
            canvas.drawBitmap(pista, MARGEN_IZQUIERDO_DERECHO_PISTA, MARGEN_ARRIBA_PISTA, paint);
            drawLetters(canvas);
            level.drawAirButtons(currentSubTrack.getAir() , null);
            currentSubTrack.updateMovement();
            level.draw(currentSubTrack, horse, canvas, paint, matrix, anchoPista, altoPista, MARGEN_ARRIBA_PISTA, anchoPista, altoPista, MARGEN_ARRIBA_PISTA);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void drawLetters(Canvas canvas) {
        letters.draw(canvas);
    }

    public void drawFinishButtons() {
        canvas.drawBitmap(back, 0, 0, paint);
        canvas.drawBitmap(restart, screenX - convertX(200), 0, paint);
        backButton.setX(0);
        restartButton.setX(screenX - convertX(200));
    }

    public void setImageButtonsAir(ImageButton paso, ImageButton trote){
        this.imagePaso = paso;
        this.imageTrote = trote;
        level = new Level2(imagePaso, imageTrote, letters);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        step(event);
        return super.onTouchEvent(event);
    }

    private void step(MotionEvent event) {
        level.step(
            currentSubTrack,
            currentSubTrack.lastDestination().getLetter(),
            letters.computeDestination(event));
        if (currentSubTrack.finished() && !track.hasNext()) {
            playing = false;
        }
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

    @Override
    public void run() {
        currentSubTrack = track.current();
        while (playing) {
            draw();
            update();
            control();
        }
        if (currentSubTrack.finished() && !track.hasNext()) {
            if (surfaceHolder.getSurface().isValid()) {
                canvas = surfaceHolder.lockCanvas();
                canvas.drawBitmap(cucarda, screenX/4, screenY/4, paint);
                drawFinishButtons();
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void update() {
        currentSubTrack.update();
        if (currentSubTrack.finished()) {
            currentSubTrack = track.current();
        }
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setUpScreenValues(int screenX, int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;
        MARGEN_IZQUIERDO_DERECHO_PISTA = screenX / 20;
        MARGEN_ARRIBA_PISTA = screenX / 4;
        MARGEN_ABAJO_PISTA = screenX / 4;
        anchoPista = screenX - (MARGEN_IZQUIERDO_DERECHO_PISTA * 2);//ancho en pixels
        altoPista = screenY - MARGEN_ARRIBA_PISTA - MARGEN_ABAJO_PISTA;//alto en pixels
    }

    private void setUpImages() {
        background = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(getResources(), R.drawable.fondo), screenX, screenY, true);
        pista = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(getResources(), R.drawable.pista), anchoPista, altoPista, true);
        cucarda = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(getResources(), R.drawable.cucarda), screenX/2, screenX/2, true);
    }

    private void setUpPaint() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
    }

    private void setUpLogicElements() {
        horse = new Horse(BitmapFactory.decodeResource(getResources(), R.drawable.horse), getResources(), getContext());
        track = (new Tracks(screenX, screenY)).table3();
    }

    public void setFinishButtons(ImageButton back, ImageButton restart) {
        this.backButton = back;
        this.restartButton = restart;
    }

    private int convertY(int y) {
        return y * screenY / 1794;
    }

    private int convertX(int x) {
        return x * screenX / 1080;
    }
}


