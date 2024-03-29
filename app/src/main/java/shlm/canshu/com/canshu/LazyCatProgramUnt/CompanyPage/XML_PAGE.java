package shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage;


import android.text.TextUtils;

/**
 * XML节点信息
 * <p>
 * 返回的信息类似于
 * <fater sign = "values">
 * <name>你好全世界</name>
 * </fater>
 */
public class XML_PAGE {
    private StringBuilder xml = new StringBuilder();
    private String _fater_nodex;

    /**
     * 构造XML的子文件体
     *
     * @param fater_node  父文件头 如果为空 则会返回一个孙节点
     * @param sign        父文件的标志
     * @param sign_values 父文件的标志的值
     */
    public XML_PAGE(String fater_node, String sign, String sign_values) {
        this._fater_nodex = fater_node;//子节点信息


        /**
         * 判断是否创建孙节点
         *
         */
        if(TextUtils.isEmpty(fater_node)){
            //为空什么都不做

        }
        else{
            //不为空
            if (TextUtils.isEmpty(sign)) {
                xml.append("<" + fater_node + ">");//开始节点
            } else {
                xml.append("<" + fater_node + " " + sign + "=\"" + sign_values + "\">");//开始节点
            }

        }
    }

    /**
     * 插入一个孙节点
     */
    public XML_PAGE addGrandsonNode(String node, String value) {
        xml.append("<" + node + ">" + value + "</" + node + ">");//一个孙节点信息
        return this;
    }


    /**
     * 获取一个完整的XML子节点信息
     *
     * @return
     */
    public StringBuilder getXml() {
        if(TextUtils.isEmpty(this._fater_nodex)){
            //什么都不做
        }
        else{
            xml.append("</" + this._fater_nodex + ">");//闭合xml实体
        }
        return xml;//获取孙节点信息
    }
}
