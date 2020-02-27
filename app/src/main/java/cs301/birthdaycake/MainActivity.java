package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {//ah look! another minor change
    //look I made a minor change! 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView foundView = findViewById( R.id.cakeview );

        CakeController ourController = new CakeController(foundView);

        Button blowout = findViewById( R.id.blow_out );
        blowout.setOnClickListener(ourController);

        Switch candleSwitch = findViewById( R.id.candle_switch );
        candleSwitch.setOnCheckedChangeListener(ourController);

        SeekBar candleSeek = findViewById( R.id.candle_bar );
        candleSeek.setOnSeekBarChangeListener(ourController);

        foundView.setOnTouchListener(ourController);

    }

    public void goodbye(View button) {
        System.out.println("Goodbye");
        finishAffinity();
    }
}
