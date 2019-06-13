package shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyTools;


import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage.USER_KEY_PAGE;
import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage.XMLUserAddr;
import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage.XML_PAGE;
import shlm.canshu.com.canshu.LazyCatProgramUnt.Config;
import shlm.canshu.com.canshu.LazyCatProgramUnt.Interface.ProgramInterface;
import shlm.canshu.com.canshu.LazyCatProgramUnt.Net;
import shlm.canshu.com.canshu.LazyCatProgramUnt.Tools;


/**
 * 公司获取用户的信息资料的操作API
 */
public class Usertools {
    /**
     * 获取用户的所有的资料信息
     */
    public static void getUservalues(Context mContext, final ProgramInterface programInterface) {
        String token = Tools.gettoKen(mContext, USER_KEY_PAGE.KEY_TOKEN);
        String phone = Tools.gettoKen(mContext, USER_KEY_PAGE.KEY_USERPHONE);
        Net.doGet(mContext, Config.HTTP_ADDR.getUser_init(), new Net.onVisitInterServiceListener() {
            @Override
            public void onSucess(String tOrgin) {
                if (programInterface != null) {
                    programInterface.onSucess(tOrgin, 0);
                }

            }

            @Override
            public void onNotConnect() {
                if (programInterface != null) {
                    programInterface.onFaile("", 0);
                }

            }

            @Override
            public void onFail(String tOrgin) {
                if (programInterface != null) {
                    programInterface.onFaile("", 0);
                }

            }
        }, Config.HttpMethodUserAction.KEY_ACTION, "" + Config.HttpMethodUserAction.GET_USERVAL,
                Config.HttpMethodUserAction.KEY_USER, Tools.getStringMD5(phone), Config
                        .HttpMethodUserAction.KEY_TOKEN, token);
    }

    /**
     * 获取用户的默认地址
     */

    public static void getUserdefaultaddr() {

    }


    /**
     * 用户插入一条收件地址
     *
     * @param mContext    上下文
     * @param name        用户名
     * @param phone       电话
     * @param addr        地址
     * @param physics_add 物理地址
     * @param addr_in     所属区域
     * @param sex         性别
     * @param year        年龄
     * @param _Default    是否默认
     * @param phone_md5   phone_md5 验证
     * @param token       token 验证
     */
    public static void insertUseraddr(Context mContext, String name, String phone, String addr,
                                      String physics_add, String addr_in, int sex, String year,
                                      String _Default, String phone_md5, String token, final
                                      ProgramInterface programInterface) {
        physics_add = URLEncoder.encode(physics_add);//编码
        XmlBuilder xmlBuilder = new XmlBuilder("body");
        XML_PAGE xml_page = new XML_PAGE("", "", "");
        xml_page.addGrandsonNode(Config.HttpMethodUserAction.KEY_USER, phone_md5).addGrandsonNode
                (Config.HttpMethodUserAction.KEY_TOKEN, token).addGrandsonNode(Config
                .HttpMethodUserAction.KEY_ADDR_NAME, name).addGrandsonNode(Config
                .HttpMethodUserAction.KEY_ADDR_TEL, phone).addGrandsonNode(Config
                .HttpMethodUserAction.KEY_ADDR_ADDR, addr).addGrandsonNode(Config
                .HttpMethodUserAction.KEY_ADDR_IN, addr_in).addGrandsonNode(Config
                .HttpMethodUserAction.KEY_ADDR_PHYSICS, physics_add).addGrandsonNode(Config
                .HttpMethodUserAction.KEY_ADDR_DEFAULT, _Default).addGrandsonNode(Config
                .HttpMethodUserAction.KEY_ACTION, Config.HttpMethodUserAction.INSERT_USER_ADDR)
                .addGrandsonNode(Config.HttpMethodUserAction.KEY_ADDR_USER_SEX, sex + "")
                .addGrandsonNode(Config.HttpMethodUserAction.KEY_ADDR_USER_YEAR, year);
        ArrayList<XML_PAGE> list = new ArrayList<XML_PAGE>();
        list.add(xml_page);
    }
}
