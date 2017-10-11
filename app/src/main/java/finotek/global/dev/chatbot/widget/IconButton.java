package finotek.global.dev.chatbot.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;

import finotek.global.dev.chatbot.R;

public class IconButton extends TalkBankButton {
	private final String logTitle = "FINOTEK-ICON_BUTTON";

	protected int drawableWidth;
	protected DrawablePositions drawablePosition;
	protected int iconPadding;

	// Cached to prevent allocation during onLayout
	Rect bounds;

	public IconButton(Context context) {
		super(context);
		bounds = new Rect();
	}

	public IconButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		bounds = new Rect();
		applyAttributes(attrs);
	}

	public IconButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		bounds = new Rect();
		applyAttributes(attrs);
	}

	protected void applyAttributes(AttributeSet attrs) {
		// Slight contortion to prevent allocating in onLayout
		if (null == bounds) {
			bounds = new Rect();
		}

		TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IconButton);
		int paddingId = typedArray.getDimensionPixelSize(R.styleable.IconButton_iconPadding, 0);
		setIconPadding(paddingId);
		typedArray.recycle();
	}

	public void setIconPadding(int padding) {
		iconPadding = padding;
		requestLayout();
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);

		Paint textPaint = getPaint();
		String text = getText().toString();
		int textWidth = (int) textPaint.measureText(text, 0, text.length());
		int factor = (drawablePosition == DrawablePositions.LEFT_AND_RIGHT) ? 2 : 1;
		int leftPadding = getPaddingStart() / 2;
		int rightPadding = getPaddingEnd() / 2;

		Log.d(logTitle, "left padding : " + leftPadding);
		Log.d(logTitle, "right padding : " + rightPadding);

		int contentWidth = iconPadding * factor + textWidth;
		iconPadding += (int) ((getWidth() / 2.0) - (contentWidth / 2.0) - drawableWidth);

		setCompoundDrawablePadding(-iconPadding + leftPadding);
		switch (drawablePosition) {
			case LEFT:
				setPadding(iconPadding + leftPadding, getPaddingTop(), rightPadding, getPaddingBottom());
				break;

			case RIGHT:
				setPadding(leftPadding, getPaddingTop(), iconPadding + rightPadding, getPaddingBottom());
				break;

			case LEFT_AND_RIGHT:
				setPadding(iconPadding, getPaddingTop(), iconPadding, getPaddingBottom());
				break;

			default:
				setPadding(0, getPaddingTop(), 0, getPaddingBottom());
		}
	}

	@Override
	public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
		super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
		initCompoundDrawableSize();

		if (left != null && right != null) {
			drawableWidth = left.getIntrinsicWidth() + right.getIntrinsicWidth();
			drawablePosition = DrawablePositions.LEFT_AND_RIGHT;
		} else if (left != null) {
			drawableWidth = left.getIntrinsicWidth();
			drawablePosition = DrawablePositions.LEFT;
		} else if (right != null) {
			drawableWidth = right.getIntrinsicWidth();
			drawablePosition = DrawablePositions.RIGHT;
		} else {
			drawablePosition = DrawablePositions.NONE;
		}

		requestLayout();
	}

	private void initCompoundDrawableSize() {
		Drawable[] drawables = getCompoundDrawables();
		for (Drawable drawable : drawables) {
			if (drawable == null) {
				continue;
			}

			Rect realBounds = drawable.getBounds();
			drawable.setBounds(realBounds);
		}

		setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
	}

	private enum DrawablePositions {
		NONE,
		LEFT_AND_RIGHT,
		LEFT,
		RIGHT
	}
}