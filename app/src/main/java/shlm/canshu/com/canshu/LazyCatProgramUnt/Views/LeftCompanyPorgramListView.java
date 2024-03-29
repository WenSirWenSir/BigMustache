package shlm.canshu.com.canshu.LazyCatProgramUnt.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import shlm.canshu.com.canshu.LazyCatProgramUnt.Config;

public class LeftCompanyPorgramListView extends ListView implements AbsListView.OnScrollListener {
    private Context mcontext;
    private View bottomview;//尾部文件
    private View headview;//头部文件
    private int totalItemcounts;
    private int lassvisible;//上拉
    private int firstvisible;//下拉
    private LoadListener loadListener;//接口回调
    private int bottomHeight;
    private int headHeight;
    private int Yload;
    boolean isLoading;
    private TextView headTv, headTime;
    private ProgressBar progressBar;


    public LeftCompanyPorgramListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mcontext = context;
        init(context);
    }

    public LeftCompanyPorgramListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mcontext = context;
        init(context);
    }

    public LeftCompanyPorgramListView(Context context) {
        super(context);
        mcontext = context;
        init(context);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int
            totalItemCount) {
    }

    public void setHeadView(int v_id) {
        headview = LinearLayout.inflate(mcontext,v_id,null);
        //重新测量
        headview.measure(0,0);
        headHeight = headview.getMeasuredHeight();//获得重新测量的高度
        headview.setPadding(0,-headHeight,0,0);
        this.addHeaderView(headview);
    }

    public void setBottomview(int v_id){
        bottomview = LinearLayout.inflate(mcontext,v_id,null);
        //重新测量
        bottomview.measure(0,0);
        bottomHeight = bottomview.getMeasuredHeight();//重新获得高度
        bottomview.setPadding(0,-bottomHeight,0,0);
        this.addFooterView(bottomview);
    }

    private void init(Context tContext) {
        this.setOnScrollListener(this);
    }

    //接口回调
    public interface LoadListener {
        void onLoad();//加载

        void PullLoad();//下拉
    }


    //加载完成
    public void localComplete() {
        isLoading = false;
        bottomview.setPadding(0, -bottomHeight, 0, 0);
        headview.setPadding(0, -headHeight, 0, 0);
    }

    public void setInterface(LoadListener loadListener) {
        this.loadListener = loadListener;
    }

    @SuppressLint("LongLogTag")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Yload = (int) ev.getY();//定位
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) ev.getY();

                int paddingY = 0;
                try {
                    paddingY = headHeight + (moveY - Yload) / 2;
                } catch (Exception e) {
                    Log.i(Config.DEBUG,"listview没有头部文件");
                }
                if(paddingY < 0){
                    Toast.makeText(mcontext,"下拉刷新",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(mcontext,"松开刷新",Toast.LENGTH_SHORT).show();
                }
                if(headview != null){
                    headview.setPadding(0,paddingY,0,0);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(ev);
    }
}
