package shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage;


import android.annotation.SuppressLint;
import android.os.Parcel;

import java.io.Serializable;

import shlm.canshu.com.canshu.LazyCatProgramUnt.Factory.WaitDialog;


/**
 * 构造WebView控件的信息
 */
@SuppressLint("ParcelCreator")
public class WEB_VALUES_ACT implements Serializable {
    private String _title;
    private String _TitleBackColor = "#e9e9e9";/*标题背景颜色*/
    private String _TitleColor = "#000000";/*标题文字颜色*/

    public String get_TitleBackColor() {
        return _TitleBackColor;
    }

    public void set_TitleBackColor(String _TitleBackColor) {
        this._TitleBackColor = _TitleBackColor;
    }

    public String get_TitleColor() {
        return _TitleColor;
    }

    public void set_TitleColor(String _TitleColor) {
        this._TitleColor = _TitleColor;
    }

    public String get_StaticColor() {
        return _StaticColor;
    }

    public void set_StaticColor(String _StaticColor) {
        this._StaticColor = _StaticColor;
    }

    private String _StaticColor = "#e9e9e9";/*状态栏颜色*/

    public WaitDialog.RefreshDialog get_dialog() {
        return _dialog;
    }

    public void set_dialog(WaitDialog.RefreshDialog _dialog) {
        this._dialog = _dialog;
    }

    private WaitDialog.RefreshDialog _dialog;

    /**
     * 默认构造一个URL其他为默认
     *
     * @param Url
     */
    private String _url = "";

    public WEB_VALUES_ACT(String Url) {
        this._url = Url;
    }

    protected WEB_VALUES_ACT(Parcel in) {

    }

    /**
     * 获取构造的URL地址信息
     *
     * @return
     */
    public String get_url() {
        return _url;
    }


    /**
     * 获取设置的Title
     *
     * @return
     */
    public String get_title() {
        return this._title;
    }


    /**
     * 设置Title
     */
    public void set_title(String title) {
        this._title = title;
    }

}