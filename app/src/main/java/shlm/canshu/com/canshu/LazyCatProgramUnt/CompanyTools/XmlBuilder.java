package shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyTools;


import java.util.ArrayList;

import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage.XML_PAGE;

/**
 * 生成一段XML的生成器
 */
public class XmlBuilder {
    private StringBuilder xml = new StringBuilder();
    private String mParcel;

    /**
     * @param parcel       最大的外围节点
     */
    public XmlBuilder(String parcel) {
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        xml.append("<"+parcel + ">");//添加最大的头部节点
        this.mParcel = parcel;
    }


    /**
     * 获取XML文件体
     * @param list 文件的配置信息
     * @return
     */
    public StringBuilder getXmlString(ArrayList<XML_PAGE> list) {
        for(int i = 0;i < list.size();i++){
            xml.append(list.get(i).getXml());
        }
        //添加尾部节点
        xml.append("</"+mParcel+">");
        return xml;

    }


}
