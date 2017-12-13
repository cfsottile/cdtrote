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

import java.util.HashMap;

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

        gameView.setUp(this.letters());
        ImageButton horseStep1 = findViewById(R.id.horseStep1);
        ImageButton horseStep2 = findViewById(R.id.horseStep2);
        ImageButton back = findViewById(R.id.buttom_back);

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
        back.setVisibility(View.INVISIBLE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        gameView.setImageButtonsBack(back);
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

    public HashMap<String, ImageButton> letters() {
        HashMap<String, ImageButton> hm = new HashMap<>();
        hm.put("A", (ImageButton) findViewById(R.id.letterA));
        hm.put("B", (ImageButton) findViewById(R.id.letterB));
        hm.put("C", (ImageButton) findViewById(R.id.letterC));
        hm.put("E", (ImageButton) findViewById(R.id.letterE));
        hm.put("F", (ImageButton) findViewById(R.id.letterF));
        hm.put("X", (ImageButton) findViewById(R.id.letterX));
        hm.put("H", (ImageButton) findViewById(R.id.letterH));
        hm.put("K", (ImageButton) findViewById(R.id.letterK));
        hm.put("M", (ImageButton) findViewById(R.id.letterM));
        return hm;
    }

}
