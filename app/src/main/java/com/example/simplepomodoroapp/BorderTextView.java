package com.example.simplepomodoroapp;

import android.content.Context;
import android.content.res.TypedArray;
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
    private String mString, strokeWidth, leftSpace;

    public BorderTextView(@NonNull Context context) {
        super(context);
    }

    public BorderTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BorderTextView, 0, 0);
        strokeWidth = a.getString(R.styleable.BorderTextView_stroke_width);
        leftSpace = a.getString(R.styleable.BorderTextView_left_space);
    }

    public BorderTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BorderTextView, defStyleAttr, 0);
        strokeWidth = a.getString(R.styleable.BorderTextView_stroke_width);
        leftSpace = a.getString(R.styleable.BorderTextView_left_space);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        mString = this.getText().toString();

        p.clearShadowLayer();
        p.setTextSize(this.getTextSize());
        p.setTypeface(this.getTypeface());
        p.setTextAlign(this.p.getTextAlign());
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setStrokeWidth(Integer.valueOf(strokeWidth));
        p.setColor(Color.BLACK);
        canvas.drawText(mString, Integer.valueOf(leftSpace), getLineHeight(), p);

        p.setStyle(Paint.Style.FILL);
        p.setColor(this.getTextColors().getDefaultColor());
        canvas.drawText(mString, Integer.valueOf(leftSpace), getLineHeight(), p);
    }
}
