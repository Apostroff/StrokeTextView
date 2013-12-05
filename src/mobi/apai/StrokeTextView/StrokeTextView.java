package mobi.apai.StrokeTextView;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class StrokeTextView extends TextView {
    private int strokeColor= Color.TRANSPARENT;
    private int strokeColorPressed= Color.TRANSPARENT;
    private int strokeSize=2;

    public StrokeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public StrokeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StrokeTextView);
        strokeColor = a.getColor(R.styleable.StrokeTextView_textStrokeColor, strokeColor);
        strokeColorPressed = a.getColor(R.styleable.StrokeTextView_textStrokeColorPressed, strokeColorPressed);
        strokeSize = a.getDimensionPixelSize(R.styleable.StrokeTextView_textStrokeSize, strokeColor);
        a.recycle();
        init();
    }

    public StrokeTextView(Context context) {
        super(context);
        init();
    }
    private void init(){
        setOnClickListener(mClickListener);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        final ColorStateList textColor = getTextColors();
        TextPaint paint = this.getPaint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeMiter(10);

        this.setTextColor(isPressed()?strokeColorPressed:strokeColor);
        paint.setStrokeWidth(strokeSize);

        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        setTextColor(textColor);
        super.onDraw(canvas);

    }
    OnClickListener mClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            if (strokeColor!=strokeColorPressed){
                invalidate();
            }

        }
    };

}
