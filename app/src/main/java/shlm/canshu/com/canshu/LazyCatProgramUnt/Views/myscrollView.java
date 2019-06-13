package shlm.canshu.com.canshu.LazyCatProgramUnt.Views;import android.content.Context;import android.util.AttributeSet;import android.util.Log;import android.view.MotionEvent;import android.widget.ScrollView;public class myscrollView extends ScrollView {    private ScrollListener mscrollListener;    public myscrollView(Context context, AttributeSet attrs, int defStyleAttr) {        super(context, attrs, defStyleAttr);    }    public myscrollView(Context context) {        super(context);    }    public myscrollView(Context context, AttributeSet attrs) {        super(context, attrs);    }    public void setScrollListener(ScrollListener scrollListener) {        this.mscrollListener = scrollListener;    }    @Override    public boolean onTouchEvent(MotionEvent ev) {        switch (ev.getAction()) {            case MotionEvent.ACTION_MOVE:                if (mscrollListener != null) {                    int contentHeight = getChildAt(0).getHeight();                    int scrollHeight = getHeight();                    Log.i("capitalist", "1");                    int scrolly = getScrollY();                    mscrollListener.onScroll(scrolly);                    if (scrolly + scrollHeight >= contentHeight || contentHeight <= scrollHeight) {                        mscrollListener.onScrollToBottom();                    }                    else{                        mscrollListener.notBottom();                    }                    if(scrolly == 0 ){                        mscrollListener.onScrollToTop();                    }                }                break;            case MotionEvent.ACTION_DOWN:                break;            case MotionEvent.ACTION_UP:                break;        }        boolean result = super.onTouchEvent(ev);        requestDisallowInterceptTouchEvent(false);        return result;    }    public interface ScrollListener {        void onScrollToBottom();        void onScrollToTop();        void onScroll(int scrollY);        void notBottom();    }}