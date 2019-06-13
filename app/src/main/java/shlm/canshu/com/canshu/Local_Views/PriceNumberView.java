package shlm.canshu.com.canshu.Local_Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class PriceNumberView extends TextView {
    public PriceNumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "font/price" +
                ".ttf");
        setTypeface(typeface);
    }

    public PriceNumberView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "font/price" +
                ".ttf");
        setTypeface(typeface);
    }

    public PriceNumberView(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "font/price" +
                ".ttf");
        setTypeface(typeface);
    }
}
