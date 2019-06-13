package shlm.canshu.com.canshu.LazyCatProgramUnt.Factory;


import android.annotation.SuppressLint;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import shlm.canshu.com.canshu.LazyCatProgramUnt.Config;


/**
 * XML解析工厂
 */
@SuppressLint("LongLogTag")
public class XmlanalysisFactory {
    private InputStream is;

    public XmlanalysisFactory(String _Xmldata) {
        is = new ByteArrayInputStream(_Xmldata.getBytes());/*重新转换为InputStream*/
    }

    /**
     * 开始解析
     */
    public void Startanalysis(XmlanalysisInterface _XmlanalysisInterface) {
        if (_XmlanalysisInterface != null) {
            XmlPullParser pullParser = Xml.newPullParser();//得到解析器
            if (is != null) {
                try {
                    pullParser.setInput(is, "UTF-8");
                    /*获取事件类型*/
                    int eventType = pullParser.getEventType();
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        switch (eventType) {
                            case XmlPullParser.START_DOCUMENT:
                                _XmlanalysisInterface.onStartDocument();/*文档开始的处理事件*/
                                break;
                            case XmlPullParser.START_TAG:
                                _XmlanalysisInterface.onStartTag(pullParser.getName(),
                                        pullParser, 0);
                                break;
                            case XmlPullParser.END_TAG:
                                _XmlanalysisInterface.onEndTag(pullParser.getName(), pullParser,
                                        0);/*结束标签*/
                                break;
                        }
                        eventType = pullParser.next();
                        if (eventType == XmlPullParser.END_DOCUMENT) {
                            _XmlanalysisInterface.onEndDocument();
                            return;
                        }
                    }
                } catch (Exception e) {
                    Log.e(Config.DEBUG, "XmlanalysisFactory.java[+]解析失败" + e.getMessage());
                    _XmlanalysisInterface.onFaile();
                    e.printStackTrace();
                }
            }

        } else {
            Log.e(Config.DEBUG, "XmlanalysisFactory.java[+]没有监听事件");
        }
    }

    /**
     * 定义两个接口 关于解析成功和解析失败
     */

    public interface XmlanalysisInterface {
        void onFaile();

        void onStartDocument();//文档开始

        void onStartTag(String tag, XmlPullParser pullParser, Integer id);//开始解析节点

        void onEndTag(String tag, XmlPullParser pullParser, Integer id);//结束节点

        void onEndDocument();//文档结束回调方法
    }
}
