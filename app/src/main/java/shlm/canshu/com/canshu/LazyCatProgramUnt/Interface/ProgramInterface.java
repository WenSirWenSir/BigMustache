package shlm.canshu.com.canshu.LazyCatProgramUnt.Interface;


import android.graphics.Bitmap;

import java.io.InputStream;
import java.util.ArrayList;

import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage.LOAD_IMAGEPAGE;
import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage.XMLUserAddr;


/**
 * 大家都可以用的接口
 */
public interface ProgramInterface {

    /**
     * 默认的处理方式
     *
     * @param data
     * @param code
     */
    public void onSucess(String data, int code);

    public void onFaile(String data, int code);

    /**
     * 短信发送接口
     */
    public interface SMSInterface {
        void onSendOk();

        void onSendError();
    }


    /**
     * XML获取接口
     */
    public interface XMLDomServiceInterface {
        void onSucess(InputStream is);

        void onFain();

        void onNotService();

        void onJson(String origin);//要用JSON解析
    }

    /**
     * 获取用户的数据处理之后的回调事件
     */
    public interface XMLforUserAllAddr {
        void onDone(ArrayList<XMLUserAddr> list);

        void onFain();

        /**
         * Token过期
         */
        void onDated();

        void onJson(String origin);

    }

    interface doGetImg {
        void onSucess(Bitmap bitmap);

        void onFain();
    }

    interface onMemorySize {
        void onGet(int max, float total, float free);
    }

    /**
     * 多线程事务处理完毕
     */
    interface onThreaddone {
        void onData(String tag);
    }


    /**
     * 图片管理的接口
     */
    interface ImageMonitoron {
        void onSucess(Bitmap bm, LOAD_IMAGEPAGE load_imagepage);

        void onFaile(String msg);
    }

}


