package laboratorio.juegocei.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

import laboratorio.juegocei.MainActivity;
import laboratorio.juegocei.R;

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
        Button initButton = findViewById(R.id.inicioButton);
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

        initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

}
