package shlm.canshu.com.canshu.LazyCatProgramUnt.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import shlm.canshu.com.canshu.LazyCatProgramUnt.Config;

/**
 * 滑动监听的View
 */
@SuppressLint("LongLogTag")
public class RefreshScrollView extends ScrollView {
    private int ViewWidth;//宽度
    private LinearLayout layout;
    private int _scrollY;//滑动的距离
    public static int CAN_REFRESH = 0;
    public static int ING_REFRESH = 1;
    public static int RUNNOW_REFRESH = 2;
    private int _downY;//记录距离
    private int _downH;//记录高度
    private boolean b_down;
    private int viewHeight;//可以刷新的高度
    private boolean onGetHeadimg = false;
    private int total_distance;
    private Handler handler;
    public boolean inLoadMessage = false;//由调用的地方手动调节 如果外部调用了加载 就必须在外部设置已经加载 不能再次加载
    public boolean onStopHandle = false;/*由外部给出这个值 来判断外部是否已经在处理滑动停止事件*/
    private RefreshScrollViewListener _RefreshScrollViewListener;//滑动监听对象
    private int RefershLog = 0;
    private int RefershImg = 0;

    public RefreshScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public RefreshScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RefreshScrollView(Context context) {
        super(context);
        init();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ViewWidth = getWidth();
    }

    private void init() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
    }

    /**
     * 设置头部View
     *
     * @param view 必须已经存在于ScrollView中
     */
    public void SetHeadView(LinearLayout view, int viewHeight, int refershLogid, int refreshImgid) {
        this.RefershLog = refershLogid;
        this.RefershImg = refreshImgid;
        layout = view;//加载文件
        if (layout == null) {
            Log.e(Config.DEBUG, "RefreshScrollView.java[+]view为空");
        }
        LinearLayout.LayoutParams _params = null;
        try {
            _params = (LinearLayout.LayoutParams) layout.getLayoutParams();
        } catch (Exception e) {
            Log.e(Config.DEBUG, "RefreshScrollView.java[+]" + e.getMessage());
        }
        this.viewHeight = viewHeight;
        if (_params == null) {
            Log.e(Config.DEBUG, "RefreshScrollView.java[+]_params为空");
        } else {
            _params.width = ViewWidth;
            _params.height = 0;
            _params.gravity = Gravity.CENTER;
        }

    }

    public void SetLinstener(RefreshScrollViewListener i) {
        if (i != null) {
            this._RefreshScrollViewListener = i;
        } else {
            Log.e(Config.DEBUG, "RefreshScrollView.java[+]监听事件对象为空");
        }
    }

    /**
     * 停止刷新
     */
    public void stopRefresh() {

        LinearLayout.LayoutParams params = null;
        try {
            params = (LinearLayout.LayoutParams) this.layout.getLayoutParams();
        } catch (Exception e) {
            Log.e(Config.DEBUG, "RefreshScrollView.java[+]" + e.getMessage());
        }
        if (params != null) {
            params.width = ViewWidth;
            params.height = 0;
            this.layout.setLayoutParams(params);
            inLoadMessage = false;//可以加载外部信息
        }
    }


    /**
     * 关键代码
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            /*判断onStophandle*/
            if (onStopHandle) {
                //可以回调滑动停止事件
                onStopHandle = false;
            }
            _downY = (int) ev.getY();
            total_distance = 0;
            //按下鼠标
        }
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            //鼠标移动
            if (_scrollY == 0) {
                //可以进行下拉刷新  在顶部位置
                Log.i(Config.DEBUG, "RefreshScrollView.java[+]在顶部");
                if (ev.getY() - _downY > 0) {
                    //向下滑动  可以刷新
                    int downRange = (int) ((ev.getY() - _downY * 1) / 2);
                    /*计算出来滑动距离 就进行回调*/
                    if (_RefreshScrollViewListener != null) {
                        _RefreshScrollViewListener.onScrollDistance(downRange);
                    }
                    b_down = false;//刚刚开始滑动 松手不能刷新
                    if (layout != null) {
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) layout
                                .getLayoutParams();
                        final ImageView head_img = (ImageView) layout.findViewById(this.RefershImg);
                        /*这边要加载网络图片*/
                        params.width = ViewWidth;
                        params.height = downRange;
                        layout.setLayoutParams(params);
                    }
                    if (downRange >= viewHeight) {
                        if (_RefreshScrollViewListener != null) {
                            _RefreshScrollViewListener.onState(RefreshScrollView.CAN_REFRESH);

                        }
                        if (this.RefershLog == 0) {
                            Log.e(Config.DEBUG, "RefreshScrollView.java[+]你必须要设置一个加载的等待ID");
                        } else {
                            ProgressBar progressBar = layout.findViewById(this.RefershLog);
                            progressBar.setVisibility(View.VISIBLE);
                        }

                        b_down = true;
                    } else {
                        if (this.RefershLog == 0) {
                            Log.e(Config.DEBUG, "RefreshScrollView.java[+]你必须要设置一个加载的等待ID");

                        } else {
                            ProgressBar progressBar = layout.findViewById(this.RefershLog);
                            progressBar.setVisibility(View.GONE);
                        }
                        if (_RefreshScrollViewListener != null) {
                            _RefreshScrollViewListener.onState(RefreshScrollView.ING_REFRESH);

                        }

                        b_down = false;
                    }
                    total_distance = downRange;//设置拉动的距离
                } else {
                    b_down = false;
                    return super.dispatchTouchEvent(ev);
                }
            } else {
                b_down = false;
                return super.dispatchTouchEvent(ev);
                //不在顶部位置  就不进行操作
            }
        }
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            //鼠标抬起
            if (b_down) {
                //可以刷新
                if (inLoadMessage == false) {
                    if (total_distance >= viewHeight * 2) {
                        //下拉大于2倍就开始加载广告
                        if (_RefreshScrollViewListener != null) {
                            _RefreshScrollViewListener.onloadMessage();
                        }
                    }
                } else {
                    Log.i(Config.DEBUG, "RefreshScrollView.java[+]外部已经开始打开广告窗口");
                }
                if (layout != null) {
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) layout
                            .getLayoutParams();
                    params.width = ViewWidth;
                    params.height = viewHeight;
                    layout.setLayoutParams(params);
                    if (_RefreshScrollViewListener != null) {
                        _RefreshScrollViewListener.onState(RefreshScrollView.RUNNOW_REFRESH);
                        //可以加载信息了
                        _RefreshScrollViewListener.onLoadMore();
                    }
                }

            } else {
                //不可以刷新 就停止
                stopRefresh();
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        _scrollY = t;//滑动的距离
        Log.i(Config.DEBUG, "RefreshScrooView.java[+]滑动的距离为:" + _scrollY);
        if (t + this.getMeasuredHeight() == this.getChildAt(0).getMeasuredHeight()) {
            Log.i(Config.DEBUG, "RefreshScrollView.java[+]滑动到底部");
            if (_RefreshScrollViewListener != null) {
                _RefreshScrollViewListener.onLoadBottom();//滑动到底部
            }
        }
    }


    /**
     * 监听
     */

    public interface RefreshScrollViewListener {
        void onRefresh();//正在刷新

        void onRefreshDone();//刷新完成

        void onStopRefresh();//停止刷新

        void onState(int _static);//状态

        void onLoadMore();//加载信息

        void onLoadBottom();//在底部

        void onScrollStop();//滑动停止

        void onloadMessage();//加载广告

        void onScrollDistance(int distance);//滑动的距离
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int
            scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean
            isTouchEvent) {
        if (deltaY <= 2 && deltaY >= -2 && !isTouchEvent) {
            if (onStopHandle) {
                //表示外部已经在处理 不用重复提交
            } else {
                _RefreshScrollViewListener.onScrollStop();
            }
        }
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY,
                maxOverScrollX, maxOverScrollY, isTouchEvent);
    }
}
