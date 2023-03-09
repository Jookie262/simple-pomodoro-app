package com.example.simplepomodoroapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BorderTextView extends androidx.appcompat.widget.AppCompatTextView {

    private Paint p = new Paint();
    private String mString;

    public BorderTextView(@NonNull Context context) {
        super(context);
    }

    public BorderTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BorderTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mString = this.getText().toString();

        p.clearShadowLayer();
        p.setTextSize(this.getTextSize());
        p.setTypeface(this.getTypeface());
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setStrokeWidth(8);
        p.setColor(Color.BLACK);
        canvas.drawText(mString, 0, getLineHeight(), p);

        p.setStyle(Paint.Style.FILL);
        p.setColor(this.getTextColors().getDefaultColor());
        canvas.drawText(mString, 0, getLineHeight(), p);
    }
}
