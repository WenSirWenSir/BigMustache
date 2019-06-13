package shlm.canshu.com.canshu.Local_Act;import android.annotation.SuppressLint;import android.os.Bundle;import android.text.TextUtils;import android.view.View;import android.widget.ProgressBar;import android.widget.TextView;import android.widget.Toast;import java.util.Timer;import java.util.TimerTask;import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyAct.LazyCatAct;import shlm.canshu.com.canshu.LazyCatProgramUnt.Net;import shlm.canshu.com.canshu.LazyCatProgramUnt.Tools;import shlm.canshu.com.canshu.Local_Page.TAGS;import shlm.canshu.com.canshu.R;/*本APP内获取程序验证码*/public class Act_getcode extends LazyCatAct {    private TextView btn_sendok;    private TextView btn_loginok;    private TextView tv_code;    private ProgressBar progressBar;    private Timer timer;    private String code;    @SuppressLint("NewApi")    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.act_getcode);        setTransparentBar();        btn_sendok = findViewById(R.id.act_getcode_btnsenddone);/*发送短信完成*/        btn_loginok = findViewById(R.id.act_getcode_btnloginok);/*登录成功*/        progressBar = findViewById(R.id.act_getcode_wait);/*等待*/        tv_code = findViewById(R.id.act_getcode_code);/*验证码*/        /*设置边框*/        btn_sendok.setBackground(Tools.CreateDrawable(1, "#efefef", "#efefef", 5));        btn_loginok.setBackground(Tools.CreateDrawable(1, "#efefef", "#efefef", 5));        /*通知服务器 要进行登录验证了*/        init();    }    private void init() {        btn_sendok.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Toast.makeText(getApplicationContext(), "请稍作等待,程序正在获取验证码", Toast.LENGTH_SHORT)                        .show();                btn_sendok.setVisibility(View.GONE);                progressBar.setVisibility(View.VISIBLE);                /*开始循环获取验证码*/                timer = new Timer();                timer.schedule(new TimerTask() {                    @Override                    public void run() {                        Net.doGet(getApplicationContext(),                                "http://47.102.205.26/Bigmustache/search/search_code.php", new                                        Net.onVisitInterServiceListener() {                            @Override                            public void onSucess(String tOrgin) {                                if (TextUtils.isEmpty(tOrgin.trim())) {                                    /*为空*/                                } else {                                    /*不为空*/                                    code = tOrgin.toString().trim();                                    timer.cancel();                                    btn_sendok.setVisibility(View.VISIBLE);                                    progressBar.setVisibility(View.GONE);                                    tv_code.setText(code);                                }                            }                            @Override                            public void onNotConnect() {                            }                            @Override                            public void onFail(String tOrgin) {                            }                        }, "account", Tools.gettoKen(getApplicationContext(), TAGS.LOCAL_TAGS                                        .LOCAL_TAGS_TOKEN_ACCOUNT), "password", Tools.gettoKen                                        (getApplicationContext(), TAGS.LOCAL_TAGS                                                .LOCAL_TAGS_TOKEN_PASSWORD), "phone",                                "15206036936");                    }                }, 3000);            }        });    }    @Override    protected void onDestroy() {        if (timer != null) {            timer.cancel();        }        super.onDestroy();    }}