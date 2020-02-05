package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView cv = findViewById(R.id.cakeview);
        CakeController cc = new CakeController(cv);
        Button button = findViewById(R.id.blow_out);
        button.setOnClickListener(cc);

        //checkpoint 3
        CompoundButton candleSwitch = findViewById(R.id.candle_switch);
        candleSwitch.setOnCheckedChangeListener(cc);

        //checkpoint 3
        SeekBar candleCounter = findViewById(R.id.candle_bar);
        candleCounter.setOnSeekBarChangeListener(cc);
    }

    public void goodbye(View button) {
        Log.i("button", "Goodbye")
        ;
    }
}
