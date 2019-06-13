package shlm.canshu.com.canshu.Local_Act;import android.annotation.SuppressLint;import android.os.Bundle;import android.support.annotation.NonNull;import android.support.design.widget.BottomNavigationView;import android.support.v7.app.AppCompatActivity;import android.text.TextUtils;import android.util.Log;import android.view.LayoutInflater;import android.view.MenuItem;import android.view.View;import android.view.Window;import android.view.WindowManager;import android.widget.LinearLayout;import android.widget.TextView;import android.widget.Toast;import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyAct.LazyCatAct;import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyClass.LazyCatFragment;import shlm.canshu.com.canshu.LazyCatProgramUnt.Net;import shlm.canshu.com.canshu.LazyCatProgramUnt.Tools;import shlm.canshu.com.canshu.Local_Page.TAGS;import shlm.canshu.com.canshu.R;public class Act_main extends LazyCatAct {    private TextView mTextMessage;    private String MSG = "Act_main.java[+]";    private LinearLayout btn_userCen;    private TextView btn_payaiqiyi;    private TextView btn_paytenxun;    private TextView btn_payyouku;    @SuppressLint("NewApi")    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setTransparentBar();        setBackStatic(true);        setContentView(R.layout.act_main);        btn_userCen = findViewById(R.id.act_main_BtnUsercent);/*点击进入用户的订单界面*/        btn_userCen.setBackground(Tools.CreateDrawable(1, "#e9e9e9", "#ffffff", 100));        /*设置边框*/        findViewById(R.id.act_main_AiqiyiBody).setBackground(Tools.CreateDrawable(1, "#efefef",                "#efefef", 15));        findViewById(R.id.act_main_TenxunBody).setBackground(Tools.CreateDrawable(1, "#efefef",                "#efefef", 15));        findViewById(R.id.act_main_YoukuBody).setBackground(Tools.CreateDrawable(1, "#efefef",                "#efefef", 15));        /*设置边框*/        btn_payaiqiyi = findViewById(R.id.act_main_BtnPayAiqiyi);/*订购爱奇艺*/        btn_paytenxun = findViewById(R.id.act_main_BtnPayTenxun);/*订购腾讯*/        btn_payyouku = findViewById(R.id.act_main_BtnPayYouku);/*订购爱奇艺*/        btn_payaiqiyi.setBackground(Tools.CreateDrawable(2, "#ffffff", "#e9e9e9", 15));        btn_paytenxun.setBackground(Tools.CreateDrawable(2, "#ffffff", "#e9e9e9", 15));        btn_payyouku.setBackground(Tools.CreateDrawable(2, "#ffffff", "#e9e9e9", 15));        mTextMessage = (TextView) findViewById(R.id.message);        init();    }    private void init() {        /*订购爱奇艺*/        btn_payaiqiyi.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                if (isLogin()) {                    /*已经登录成功*/                    /*判断是否还有账号*/                    Net.doGet(getApplicationContext(),                            "http://47.102.205.26/Bigmustache/search/search_loginphone" + ".php",                            new Net.onVisitInterServiceListener() {                        @Override                        public void onSucess(String tOrgin) {                            if (TextUtils.isEmpty(tOrgin.trim())) {                                Toast.makeText(getApplicationContext(), "不好意思,暂时没有该平台的账户咯", Toast                                        .LENGTH_SHORT).show();                            } else {                                LazyCatActStartActivityWithBundler(Act_order.class, false, TAGS                                        .LOCAL_INFO.INFO, TAGS.LOCAL_INFO.PAY_AIQIYI);                            }                        }                        @Override                        public void onNotConnect() {                        }                        @Override                        public void onFail(String tOrgin) {                        }                    }, "login_type", "aiqiyi");                } else {                    LazyCatActStartActivity(Act_login.class, false);                }            }        });        /*订购优酷*/        btn_payyouku.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                if (isLogin()) {                    /*已经登录成功*/                    LazyCatActStartActivityWithBundler(Act_pay.class, false, TAGS.LOCAL_INFO                            .INFO, TAGS.LOCAL_INFO.PAY_YOUKU);                } else {                    LazyCatActStartActivity(Act_login.class, false);                }            }        });        /*订购腾讯*/        btn_paytenxun.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                if (isLogin()) {                    /*已经登录成功*/                    LazyCatActStartActivityWithBundler(Act_pay.class, false, TAGS.LOCAL_INFO                            .INFO, TAGS.LOCAL_INFO.PAY_TENXUN);                } else {                    LazyCatActStartActivity(Act_login.class, false);                }            }        });        /*进入订单界面*/        btn_userCen.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                LazyCatActStartActivity(Act_orderpage.class, false);            }        });    }    /*判断是否已经登录了*/    private Boolean isLogin() {        if (Tools.gettoKen(getApplicationContext(), TAGS.LOCAL_TAGS.LOCAL_TAGS_TOKEN_ACCOUNT)                .equals("")) {            return false;        } else {            Log.i(MSG, "登录的账号:" + Tools.gettoKen(getApplicationContext(), TAGS.LOCAL_TAGS                    .LOCAL_TAGS_TOKEN_ACCOUNT));            return true;        }    }}