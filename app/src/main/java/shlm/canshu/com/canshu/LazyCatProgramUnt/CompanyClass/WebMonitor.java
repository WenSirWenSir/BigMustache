package shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyClass;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import shlm.canshu.com.canshu.LazyCatProgramUnt.Config;


/**
 * 网页调用的方法
 */

public class WebMonitor {
    private Context mContext;
    private Activity mAc;

    public WebMonitor(Context _Context, Activity ac) {
        this.mAc = ac;
        this.mContext = _Context;
    }

    /**
     * 网页接口  增加用户一个抵用卷  可以直接使用抵用券使用
     *
     * @param _pagetype 抵用卷类型
     * @param price     抵用的金额
     * @param message   备注信息
     */
    @JavascriptInterface
    public void Getpage(int price, int _pagetype, String message) {

    }

    /**
     * 获取赠品信息
     *
     * @param barcode 商品条码
     * @param id      商品唯一ID
     * @param number  赠送数量
     * @param message 备注信息
     */
    @JavascriptInterface
    public void Getshop(int barcode, int id, int number, String message) {

    }


    /**
     * 执行MYSQL数据信息
     *
     * @param sql MySQL语句
     * @param url 提交地址
     */
    @JavascriptInterface
    public void ExeclMysql(String sql, String url) {

    }

    /**
     * 获取积分
     *
     * @param Integral 积分数量
     * @param message  备注信息
     */
    @JavascriptInterface

    public void GetIntegral(int Integral, String message) {

    }


    /**
     * 获取手机的物理地址
     */
    @JavascriptInterface

    public void GetphoneAddr() {

    }

    /**
     * 提示一个提示信息
     *
     * @param message 信息
     * @param in      0代表短提示 1代表长提示
     */
    @JavascriptInterface
    public void ShowToast(String message, int in) {
        if (in == 0) {
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 启动登录
     */
    @JavascriptInterface

    public void StartLogin() {

    }

    /**
     * 浏览一个做特价或者做促销的商品
     *
     * @param barcode 商品的条码
     * @param id      商品的唯一ID
     * @param title   商品的标题
     */
    public void StartShop(int barcode, int id, String title) {

    }


    /**
     * 关闭WebView的窗口
     */
    @JavascriptInterface
    public void Finish() {
        if (mAc != null) {
            mAc.finish();
        } else {
            Log.e(Config.DEBUG, "WebMonitor.java[+]传入的Activity为空的值 不能关闭");
        }
    }

    /**
     * 打开用户的购物车
     */
    public void StartShopCart() {

    }

    /**
     * 更新系统的日志信息
     *
     * @param logMessage 日志的信息
     * @param logTitle   日志的标题
     * @param code       日志的标号
     */
    public void SystemLog(String logMessage, String logTitle, int code) {

    }

    /**
     * 回到用户的主界面
     */
    public void Goindex() {

    }


    /**
     * 跳转到用户的主界面
     */
    public void GoinUsercontent() {

    }

    /**
     * 跳转到用户的运送界面
     */
    public void GoinUserFreight() {

    }

    /**
     * 发送手机验证码
     *
     * @param phone   手机号码
     * @param sendUrl 发送的地址
     */
    public void SendMessage(String phone, String sendUrl) {

    }


    /**
     * 检查验证码是否正确 正确的话 要调用JS端的代码  xml提交方式
     *
     * @param phone   手机号码
     * @param code    短信验证码
     * @param sendUrl 检查的地址
     */
    public void CheckSendCode(String phone, String code, String sendUrl) {

    }


    /**
     * 分享到微信空间的推荐的信息 如果调用成功的话  就要回调到JS提供的接口地址
     *
     * @param title       分享的标题
     * @param content     分享的内容
     * @param photo       分享的图片
     * @param callBackurl 成功的回调地址
     */
    public void ShareWX(String title, String content, String photo, String callBackurl) {

    }

    /**
     * 分享到QQ控件的推荐的信息  如果调用成功的话 就要回调大JS提供的接口的地址
     *
     * @param title       分享的标题
     * @param content     分享的内容
     * @param photo       分享的图片
     * @param callBackurl 成功的回调地址
     */
    public void ShareQQ(String title, String content, String photo, String callBackurl) {

    }

}
