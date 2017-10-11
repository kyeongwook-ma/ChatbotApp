package finotek.global.dev.chatbot.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.Switch;

import finotek.global.dev.chatbot.R;

/**
 * Created by magyeong-ug on 2017. 3. 30..
 */

public class TalkBankSwitch extends Switch {
	public TalkBankSwitch(Context context) {
		super(context);
		init(context);
	}

	public TalkBankSwitch(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public TalkBankSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	public TalkBankSwitch(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init(context);
	}

	private void init(Context context) {

		setSwitchMinWidth(40);
		setTrackDrawable(ContextCompat.getDrawable(context, R.drawable.switch_track_off));
		setThumbDrawable(ContextCompat.getDrawable(context, R.drawable.switch_thumb_selector));

		setThumbTextPadding((int) context.getResources().getDimension(R.dimen.switch_thumb_radius));
		setTextOn("On");
		setTextOff("Off");

	}
}
