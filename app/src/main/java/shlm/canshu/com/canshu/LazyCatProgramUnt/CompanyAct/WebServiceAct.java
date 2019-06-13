package shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyAct;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyClass.WebMonitor;
import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage.WAIT_ITME_DIALOGPAGE;
import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage.WEB_VALUES_ACT;
import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage.WINDOW_PAGE;
import shlm.canshu.com.canshu.LazyCatProgramUnt.Config;
import shlm.canshu.com.canshu.LazyCatProgramUnt.Factory.WaitDialog;


/**
 * 用来管理显示Url的View界面
 * <p>
 */
public class WebServiceAct extends LazyCatAct {
    private WebView _WebView;
    private String MSG = "WebServiceAct.java[+]";
    private DisplayMetrics metrics;/*屏幕矩阵*/
    private Button ButtonTitle;
    private LinearLayout item;
    private WEB_VALUES_ACT web_values_act;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            if (web_values_act != null) {
                Button bt = (Button) item.getChildAt(0);
                bt.setText(msg.obj.toString());
                bt.setTextColor(Color.parseColor(web_values_act.get_TitleColor()));
                bt.setBackgroundColor(Color.parseColor(web_values_act.get_TitleBackColor()));

            }
            super.handleMessage(msg);
        }
    };
    private WaitDialog.RefreshDialog refreshDialog;

    @SuppressLint({"LongLogTag", "SetJavaScriptEnabled", "JavascriptInterface"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //获取构造数据信息
        web_values_act = (WEB_VALUES_ACT) getIntent().getSerializableExtra(WINDOW_PAGE
                .RESULT_WEBVIEW);
        item = new LinearLayout(getApplicationContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        item.setLayoutParams(params);//设置布局
        item.setOrientation(LinearLayout.VERTICAL);
        setStatusBar(web_values_act.get_StaticColor());
        item.setBackgroundColor(Color.parseColor("#ffffff"));
        /*获取屏幕矩阵*/
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        /*增加Title布局*/
        ButtonTitle = new Button(item.getContext());
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(ViewGroup
                .LayoutParams.MATCH_PARENT, metrics.heightPixels / 10);
        ButtonTitle.setLayoutParams(titleParams);
        ButtonTitle.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        ButtonTitle.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        ButtonTitle.setGravity(Gravity.CENTER);
        ButtonTitle.setTextSize(15);
        ButtonTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v;
                Toast.makeText(getApplicationContext(), tv.getText().toString(), Toast
                        .LENGTH_SHORT).show();
            }
        });
        item.addView(ButtonTitle);
        //增加WebView布局
        _WebView = new WebView(item.getContext());
        _WebView.addJavascriptInterface(new WebMonitor(getApplicationContext(), this),
                "webmonitor");
        item.addView(_WebView);
        _WebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                Message msg = new Message();
                msg.obj = title;
                handler.sendMessage(msg);
                Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
                super.onReceivedTitle(view, title);
            }
        });

        if (web_values_act != null) {
            Log.i(Config.DEBUG, "WebServiceAct.java[+]获取到的构造的URL:" + web_values_act.get_url());
            _WebView.loadUrl(web_values_act.get_url());
            WebSettings webSettings = _WebView.getSettings();//获取配置
            webSettings.setJavaScriptEnabled(true);//对JAVA的支持
            _WebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String request) {
                    view.loadUrl(request);
                    return true;
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    /*开始加载信息*/
                    refreshDialog = new WaitDialog.RefreshDialog(WebServiceAct.this);
                    WAIT_ITME_DIALOGPAGE wait_itme_dialogpage = new WAIT_ITME_DIALOGPAGE();
                    refreshDialog.showRefreshDialog("", false);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    Log.i(MSG, "网页加载完成");
                    refreshDialog.dismiss();
                }
            });
        } else {
            finish();
            Log.e(Config.DEBUG, "WebServiceAct.java[+] 获取WEB_VALUES_ACT为null");
        }
        super.onCreate(savedInstanceState);
        setContentView(item);
    }

    @Override
    protected void onDestroy() {
        if (_WebView != null) {
            _WebView.clearCache(true);//清空缓存
            _WebView.clearHistory();//清空历史
            _WebView = null;
            System.gc();
        }
        super.onDestroy();
    }
}
