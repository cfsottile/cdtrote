package laboratorio.juegocei;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import laboratorio.juegocei.settings.Setting;
import laboratorio.juegocei.settings.SoundActivity;

public class GameActivity extends AppCompatActivity {
    private ImageButton imagePaso, imageTrote, back, restart, settingButton;
    private Setting setting;
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Display display = getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        /* Setting of the game */
        setting = (Setting)getApplication();
//        setting.setActualLevel(1);
//        setting.setActualTable(4);

        gameView = new GameView(this, size.x, size.y, this, setting.getSound(), setting.getActualTrack());

        setContentView(R.layout.activity_game);
        RelativeLayout rel=(RelativeLayout)findViewById(R.id.relLayout);
        rel.addView(gameView,0);

        imagePaso = findViewById(R.id.horseStep1);
        imageTrote = findViewById(R.id.horseStep2);
        back = findViewById(R.id.buttom_back);
        back.setX(-250);
        back.setY(0);

        restart = findViewById(R.id.button_restart);
        restart.setX(250);
        restart.setY(0);

        settingButton = findViewById(R.id.setting);
        gameView.setImageButtonsAir(imagePaso, imageTrote);
        gameView.setFinishButtons(back, restart);
        gameView.setSoundSettingButton(settingButton);
        gameView.setLevel(setting.getActualLevel(), this);
        gameView.prepareTrack();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setting.update();
                gameView.finishAndRestart();
                finish();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView.finishAndRestart();
                finish();
                setting.update();
                setting.getSound().campana();
                startActivity(new Intent(getBaseContext(), GameActivity.class));
            }
        });
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), SoundActivity.class));
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

    public void changeImage(Air air, int resource) {
        switch (air) {
            case PASO:
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imagePaso.setBackgroundResource(resource);
                    }
                });
                break;
            case TROTE:
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageTrote.setBackgroundResource(resource);
                    }
                });
                break;
        }
    }

    public void backButtonSetX(float x) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                back.setX(x);
            }
        });
    }

    public void restartButtonSetX(float x) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                restart.setX(x);
            }
        });
    }

    public void soundSettingButtonSetX(float x) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                settingButton.setX(x);
            }
        });
    }

    public void hideAirButtons() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imagePaso.setVisibility(View.INVISIBLE);
                imageTrote.setVisibility(View.INVISIBLE);
            }
        });
    }

}
