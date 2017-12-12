package laboratorio.juegocei;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Display display = getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        gameView = new GameView(this, size.x, size.y);

        setContentView(R.layout.activity_game);
        RelativeLayout rel=(RelativeLayout)findViewById(R.id.relLayout);
        rel.addView(gameView,0);

        ImageButton horseStep1 = findViewById(R.id.horseStep1);
        ImageButton horseStep2 = findViewById(R.id.horseStep2);
        gameView.setImageButtonsAir(horseStep1, horseStep2);
        horseStep1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "Paso", Toast.LENGTH_SHORT).show();

            }
        });

        horseStep2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "Galope", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }

}
