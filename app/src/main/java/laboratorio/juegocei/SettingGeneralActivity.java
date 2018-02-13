package laboratorio.juegocei;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingGeneralActivity extends AppCompatActivity {

    private ImageButton backButton;
    private SeekBar level;
    private TextView levelSelected;
    private Setting setting;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Display display = getWindowManager().getDefaultDisplay();
        setContentView(R.layout.settings_general);

        //Find your views
        backButton = (ImageButton) findViewById(R.id.buttom_back);
        level = findViewById(R.id.seekBarLevel);
        levelSelected = findViewById(R.id.levelSelected);
        setting = (Setting)getApplication();

        //Assign a listener to your button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        levelSelected.setText("Nivel 1");
        level.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int levelNumber, boolean b) {
                setting.setActualLevel(levelNumber + 1);
                levelSelected.setText("Nivel " + (levelNumber + 1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                setting.setActualLevel(1);
                levelSelected.setText("Nivel 1");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                setting.setActualLevel(3);
//                levelSelected.setText("Nivel 3");
            }
        });
    }


}
