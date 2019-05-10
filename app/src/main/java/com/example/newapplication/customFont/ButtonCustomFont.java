package com.example.newapplication.customFont;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.example.newapplication.R;

@SuppressLint("AppCompatCustomView")
public class ButtonCustomFont extends Button {
    String customFont;

    public ButtonCustomFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        style(context, attrs);
    }

    public ButtonCustomFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        style(context, attrs);
    }

    private void style(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ButtonCustomFont);
        int cf = a.getInteger(R.styleable.ButtonCustomFont_fontName, 0);
        int fontName = 0;
        switch (cf) {
            case 1:
                fontName = R.string.KFC_NASKH_WEBFONT;
                break;
            case 2:
                fontName = R.string.ME_QURAN_WEBFONT;
                break;
            default:
                fontName = R.string.KFC_NASKH_WEBFONT;
                break;
        }

        customFont = getResources().getString(fontName);

        Typeface tf = Typeface.createFromAsset(context.getAssets(), customFont + ".otf");
        setTypeface(tf);
        a.recycle();
    }
}
