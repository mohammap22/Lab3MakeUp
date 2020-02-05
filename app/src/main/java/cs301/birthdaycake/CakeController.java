package cs301.birthdaycake;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import static cs301.birthdaycake.CakeView.cakeLeft;
import static cs301.birthdaycake.CakeView.cakeTop;
import static cs301.birthdaycake.CakeView.cakeWidth;
import static cs301.birthdaycake.CakeView.candleWidth;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener
{
    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView cv)
    {
        this.cakeView = cv;
        cakeModel = cv.getCakeModel();
    }

    @Override
    public void onClick(View v)
    {
        cakeModel.isLit = false;
        cakeView.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton cb, boolean isChecked)
    {
        if(isChecked == true)
        {
            cakeModel.hasCandles = true;
        }
        else
        {
            cakeModel.hasCandles = false;
        }
        cakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean unused)
    {
        cakeModel.numCandles = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar)
    {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar)
    {
        cakeView.invalidate();
    }
}
