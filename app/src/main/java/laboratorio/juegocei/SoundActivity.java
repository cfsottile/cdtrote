package laboratorio.juegocei;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class SoundActivity extends AppCompatActivity {

    private Setting setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Display display = getWindowManager().getDefaultDisplay();
        setContentView(R.layout.setting_sound);

        setting = (Setting)getApplication();

        //Find your views
        ImageButton backButton = findViewById(R.id.buttom_back);
        Switch toggle = findViewById(R.id.sound);

        //Assign a listener to your button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        toggle.setChecked(setting.isEnabled());
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setting.enabledSound();
                } else {
                    setting.disabledSound();
                }
            }
        });

    }

}
