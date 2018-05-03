package laboratorio.juegocei;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import laboratorio.juegocei.settings.Setting;
import laboratorio.juegocei.settings.SettingGeneralActivity;

public class MainActivity extends AppCompatActivity {

    Setting setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Bitmap bitmapDecode = BitmapFactory.decodeResource(getResources(), R.drawable.portada);
        Bitmap bmp = Bitmap.createScaledBitmap(bitmapDecode, size.x, size.y,true);

        ImageView iv_background = findViewById(R.id.background);
        iv_background.setImageBitmap(bmp);

        /* Setting of the game */
        setting = (Setting)getApplication();
        setting.setSound(getBaseContext());
        setting.setTracks(size.x, size.y);

        ImageButton aboutButton = findViewById(R.id.about);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), AboutActivity.class));
            }
        });
        ImageButton settingButton = findViewById(R.id.setting);
        settingButton.setX(size.x - 130);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), SettingGeneralActivity.class));
            }
        });

        ImageButton playButton = findViewById(R.id.play2);
        playButton.setX(size.x / 2 - 125);
        playButton.setY(size.y / 2);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setting.getSound().campana();
                startActivity(new Intent(getBaseContext(), GameActivity.class));
            }
        });
    }

}
