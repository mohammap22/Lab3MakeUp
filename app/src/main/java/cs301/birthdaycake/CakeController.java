package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;


public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView cv) {
        this.cakeView = cv;
        cakeModel = cv.getOurModel();
    }

    @Override
    public void onClick(View v) {
        cakeModel.isLit = false;
        cakeView.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
        if (isChecked == true) {
            cakeModel.hasCandles = true;
        } else {
            cakeModel.hasCandles = false;
        }
        cakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean unused) {
        cakeModel.numCandles = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        cakeView.invalidate();
    }

    public boolean onTouch(View v, MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();
        cakeModel.balloonCoordinates[0] = x;
        cakeModel.balloonCoordinates[1] = y;
        cakeModel.x = event.getX();
        cakeModel.y = event.getY();
        cakeView.invalidate();
        return true;
    }

}
