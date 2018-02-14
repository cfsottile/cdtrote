package laboratorio.juegocei.settings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import laboratorio.juegocei.R;

public class SettingGeneralActivity extends AppCompatActivity {

    private TextView levelSelected;
    private Setting setting;
    private Spinner tableSelected;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Display display = getWindowManager().getDefaultDisplay();
        setContentView(R.layout.settings_general);

        setting = (Setting)getApplication();

        //Find your views
        ImageButton backButton = (ImageButton) findViewById(R.id.buttom_back);
        SeekBar level = findViewById(R.id.seekBarLevel);
        levelSelected = findViewById(R.id.levelSelected);
        tableSelected = findViewById(R.id.tableSelected);

        //Assign a listener to your button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        levelSelected.setText("Nivel " + setting.getActualLevel());
        level.setProgress(setting.getActualLevel()-1);
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
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        String[] items = new String[]{"Tabla 3", "Tabla 4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        tableSelected.setAdapter(adapter);
        tableSelected.setSelection(setting.getLastTableSelected() - 3);
        tableSelected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                String option = tableSelected.getSelectedItem().toString();

                if (option.equals("Tabla 3")){
                    setting.setActualTable(3);
                }
                if (option.equals("Tabla 4")){
                    setting.setActualTable(4);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }


}
