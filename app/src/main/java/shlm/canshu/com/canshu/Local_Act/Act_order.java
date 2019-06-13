package shlm.canshu.com.canshu.Local_Act;import android.annotation.SuppressLint;import android.os.Bundle;import android.support.v4.widget.ImageViewCompat;import android.util.Log;import android.view.View;import android.widget.ImageView;import android.widget.TextView;import android.widget.Toast;import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyAct.LazyCatAct;import shlm.canshu.com.canshu.LazyCatProgramUnt.Net;import shlm.canshu.com.canshu.LazyCatProgramUnt.Tools;import shlm.canshu.com.canshu.Local_Page.TAGS;import shlm.canshu.com.canshu.R;import static shlm.canshu.com.canshu.Local_Page.TAGS.LOCAL_TAGS.LOCAL_TAGS_TOKEN_ACCOUNT;import static shlm.canshu.com.canshu.Local_Page.TAGS.LOCAL_TAGS.LOCAL_TAGS_TOKEN_PASSWORD;public class Act_order extends LazyCatAct {    private String MSG = "Act_order.java[+]";    private TextView btn_addDay, btn_delDay, pay_day;    private String verfication;    private String pay_type;    private TextView paytype;    private ImageView img;    private TextView act_order_checktype;/*购买的验证类型*/    private ImageView check_img;/*验证方式*/    private TextView btn_pay;    @SuppressLint("NewApi")    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setTransparentBar();        setContentView(R.layout.act_order);        paytype = findViewById(R.id.act_order_paytype);/*购买的服务*/        btn_addDay = findViewById(R.id.act_order_addday);/*增加天数*/        btn_delDay = findViewById(R.id.act_order_delday);/*减少天数*/        pay_day = findViewById(R.id.act_order_payday);/*订购天数*/        img = findViewById(R.id.act_order_img);/*图标*/        act_order_checktype = findViewById(R.id.act_order_checktype);/*购买的验证方式*/        check_img = findViewById(R.id.act_order_checkimg);/*验证方式*/        btn_pay = findViewById(R.id.act_order_btnpay);/*预支付订单*/        /*设置边框*/        btn_addDay.setBackground(Tools.CreateDrawable(1, "#efefef", "#efefef", 50));        btn_delDay.setBackground(Tools.CreateDrawable(1, "#efefef", "#efefef", 50));        findViewById(R.id.act_order_PaytypeBody).setBackground(Tools.CreateDrawable(1, "#efefef",                "#efefef", 15));        if (LazyCatgetBundlerValue(TAGS.LOCAL_INFO.INFO).equals(TAGS.LOCAL_INFO.PAY_YOUKU)) {            paytype.setText("优酷视频日制会员共享使用(使用期限一天)");            img.setBackgroundResource(R.drawable.youku);        }        if (LazyCatgetBundlerValue(TAGS.LOCAL_INFO.INFO).equals(TAGS.LOCAL_INFO.PAY_AIQIYI)) {            paytype.setText("爱奇艺日制会员共享使用(使用期限一天)");            img.setBackgroundResource(R.drawable.aiqiyi);        }        if (LazyCatgetBundlerValue(TAGS.LOCAL_INFO.INFO).equals(TAGS.LOCAL_INFO.PAY_TENXUN)) {            paytype.setText("腾讯视频日制会员共享使用(使用期限一天)");            img.setBackgroundResource(R.drawable.tenxun);        }        init();    }    private void init() {        btn_pay.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Net.doGet(getApplicationContext(),                        "http://47.102.205.26/Bigmustache/pay/prepayment.php", new Net                                .onVisitInterServiceListener() {                    @Override                    public void onSucess(String tOrgin) {                        Log.i(MSG, "服务器返回数据:" + tOrgin.toString().trim());                    }                    @Override                    public void onNotConnect() {                    }                    @Override                    public void onFail(String tOrgin) {                    }                }, "account", Tools.gettoKen(getApplicationContext(), LOCAL_TAGS_TOKEN_ACCOUNT),                        "pass", Tools.gettoKen(getApplicationContext(),                                LOCAL_TAGS_TOKEN_PASSWORD), "day", "89", "type", "爱奇艺",                        "login_type", pay_type, "check_type", "手机", "phone_type", "vivoy79");            }        });        /**         * 增加         */        btn_addDay.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                int day = Integer.valueOf(pay_day.getText().toString().trim());                if ((day + 1) >= 8) {                    Toast.makeText(getApplicationContext(), "单次订购的VIP不建议超过7天", Toast                            .LENGTH_SHORT).show();                } else {                    day++;                    pay_day.setText(String.valueOf(day));                }            }        });        /**         * 减少         */        btn_delDay.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                int day = Integer.valueOf(pay_day.getText().toString().trim());                if ((day - 1) == 0) {                    Toast.makeText(getApplicationContext(), "购买的VIP天数不能小于1天哦", Toast                            .LENGTH_SHORT).show();                } else {                    day--;                    pay_day.setText(String.valueOf(day));                }            }        });    }}