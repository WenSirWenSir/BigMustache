package shlm.canshu.com.canshu.LazyCatProgramUnt.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import shlm.canshu.com.canshu.LazyCatProgramUnt.Config;


/**
 * 设置下拉的时候控件大
 */
public class ScrollViewBiggerPhoto extends ScrollView {
    private View img_body;
    private float myFirstMove = 0;
    private DisplayMetrics metrics;//

    public ScrollViewBiggerPhoto(Context context) {
        super(context);
    }

    public ScrollViewBiggerPhoto(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewBiggerPhoto(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setImageHead(View _imgbody, DisplayMetrics _metrics) {
        this.img_body = _imgbody;
        this.metrics = _metrics;//屏幕矩阵
        Log.e(Config.DEBUG, "ScrollViewBiggerPhoto.java[+]屏幕宽度:" + this.metrics.widthPixels);
        Log.e(Config.DEBUG, "ScrollViewBiggerPhoto.java[+]屏幕高度:" + this.metrics.heightPixels);
        /*设置控件的高度和宽度*/
        ViewGroup.LayoutParams params = this.img_body.getLayoutParams();
        params.width = this.metrics.widthPixels;
        params.height = this.metrics.heightPixels * 8 / 16;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        ViewGroup.LayoutParams params = null;
        if (this.img_body != null) {
            params = this.img_body.getLayoutParams();
        } else {
            Log.e(Config.DEBUG, "ScrollViewBiggerPhoto.java[+]您必须设置一个控件");

        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                ClearImage();
                break;
            case MotionEvent.ACTION_DOWN:
                myFirstMove = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                /*判断是否在顶部*/
                if (getScrollY() == 0) {
                    Log.e(Config.DEBUG, "在顶部");
                    /*记录位置*/
                    /*计算滚动距离*/
                    int distance = (int) ((ev.getY() - myFirstMove) * 0.6);
                    if (distance < 0) {
                        /*不能放大*/
                        break;
                    }
                    /*开始处理放大*/
                    if (params != null) {
                        params.width = this.metrics.widthPixels + distance;
                        params.height = (this.metrics.heightPixels + distance) * 8 / 16;
                        Log.e(Config.DEBUG, "ScrollViewBiggerPhoto.java[+]改变的屏幕高度:" + params
                                .height + "改变屏幕的宽度:" + params.width);
                        this.img_body.setLayoutParams(params);
                    }

                }

                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    /**
     * 清空ImageView的放大效果
     */
    private void ClearImage() {
        ViewGroup.LayoutParams params = this.img_body.getLayoutParams();
        params.width = this.metrics.widthPixels;
        params.height = this.metrics.heightPixels * 8 / 16;
        this.img_body.setLayoutParams(params);
    }
}
