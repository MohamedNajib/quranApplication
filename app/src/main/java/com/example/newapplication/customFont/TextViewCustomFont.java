package com.example.newapplication.customFont;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.newapplication.R;


@SuppressLint("AppCompatCustomView")
public class TextViewCustomFont extends TextView {

    String customFont;

    public TextViewCustomFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        style(context, attrs);
    }

    public TextViewCustomFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        style(context, attrs);

    }

    private void style(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextViewCustomFont);
        int cf = a.getInteger(R.styleable.TextViewCustomFont_fontName, 0);
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
