package shlm.canshu.com.canshu.LazyCatProgramUnt.Factory;


import java.util.ArrayList;

/**
 * XML对应的数据解析
 */
public class XmlTagValuesFactory {


    /*用户界面的xmlTag*/
    public static class XMLKeyUserPageXml {
        /*卡片*/
        public final static String key_card = "card";
        /*卡片标题*/
        public final static String key_card_title = "card_title";
        /*卡片的按钮ITEM*/
        public final static String key_card_item = "item";
        /*卡片的按钮的标题*/
        public final static String key_card_item_title = "title";
        /*卡片的按钮的颜色*/
        public final static String key_card_item_titlecolor = "title_color";
        /*卡片的按钮的图片地址*/
        public final static String key_card_item_imgurl = "img_url";
    }

    public static class XMLKeyMainXml {
        public final static String key_only_code = "only_code";/*唯一的代码更新*/
        public final static String key_photo_addr = "photo_addr";/*图片地址*/
        public final static String key_adver_head = "adver_head";/*广告图片*/
        public final static String key_adver_head_first = "first";/*第一个广告图片*/
        public final static String key_adver_head_second = "second";/*第二个产品图片*/
        public final static String key_adver_head_three = "three";/*第三个产品图片*/
        public final static String key_nav_ico = "nav_ico";/*导航的xml参数*/
        public final static String key_nav_body = "nav_xml";/*单个导航*/
        public final static String key_nav_ico_ico = "ico";/*导航的参数*/
        public final static String key_nav_ico_title = "title";/*导航参数*/
        public final static String key_nav_ico_color = "color";/*导航参数*/
        public final static String key_nav_ico_auto_link = "auto_link";/*导航参数链接地址*/
        public final static String key_nav_ico_static = "static";/*导航图标的状态*/
        public final static String key_nav_ico_static_titleColor = "static_titleColor";/*状态的颜色*/
        public final static String key_nav_ico_static_backColor = "static_backColor";/*状态的背景*/
        public final static String key_nav_ico_auto_link_titleColor = "auto_link_titleColor";
        /*打开webview的字体颜色*/
        public final static String key_nav_ico_auto_link_titleBackColor =
                "auto_link_titleBackColor";/*打开webview的标题背景颜色*/
        public final static String key_nav_ico_auto_link_staticColor = "auto_link_staticColor";
        /*打开的webview的状态栏颜色*/
        /*更换状态颜色*/
        public final static String key_main_static_color = "static_color";
        /*更换搜索框的背景颜色*/
        public final static String key_main_searchBody_BackColor = "searchbody_backcolor";

        /*搜索框文字颜色*/
        public final static String key_main_searchBody_inputColor = "searchbody_inputcolor";
        /*搜索框文字背景颜色*/
        public final static String key_main_searchBody_inputBackColor = "searchbody_inputbackcolor";
        /*搜索框线条颜色*/
        public final static String key_main_searchBody_inputLineColor = "searchbody_inputlinecolor";
    }

    public static class XMLTagMainNavValues {
        public String Nav_ico;
        public String Nav_title;
        public String Nav_color;
        public String Nav_link_url;
        public String Nav_static_titleColor;
        public String Nav_static_backColor;
        /*状态栏颜色*/
        public String Main_static_color;
        /*搜索框背景颜色*/
        public String Main_searchback_color;
        /*输入框文字颜色*/
        public String Main_input_color;
        /*输入框背景颜色*/
        public String Main_inputback_color;
        /*输入框线条颜色*/
        public String Main_input_line_color;

        public String getAuto_link_titleColor() {
            return Auto_link_titleColor;
        }

        public void setAuto_link_titleColor(String auto_link_titleColor) {
            Auto_link_titleColor = auto_link_titleColor;
        }

        public String getAuto_link_titleBackColor() {
            return Auto_link_titleBackColor;
        }

        public void setAuto_link_titleBackColor(String auto_link_titleBackColor) {
            Auto_link_titleBackColor = auto_link_titleBackColor;
        }

        public String getAuto_link_staticColor() {
            return Auto_link_staticColor;
        }

        public void setAuto_link_staticColor(String auto_link_staticColor) {
            Auto_link_staticColor = auto_link_staticColor;
        }

        public String Auto_link_titleColor;/*webview标题文字颜色*/
        public String Auto_link_titleBackColor;/*webview标题背景颜色*/
        public String Auto_link_staticColor;/*webview状态栏颜色*/

        public String getNav_static_titleColor() {
            return Nav_static_titleColor;
        }

        public void setNav_static_titleColor(String nav_static_titleColor) {
            Nav_static_titleColor = nav_static_titleColor;
        }

        public String getNav_static_backColor() {
            return Nav_static_backColor;
        }

        public void setNav_static_backColor(String nav_static_backColor) {
            Nav_static_backColor = nav_static_backColor;
        }

        public String getNav_static() {
            return Nav_static;
        }

        public void setNav_static(String nav_static) {
            Nav_static = nav_static;
        }

        public String Nav_static;

        public String getNav_ico() {
            return Nav_ico;
        }

        public void setNav_ico(String nav_ico) {
            Nav_ico = nav_ico;
        }

        public String getNav_title() {
            return Nav_title;
        }

        public void setNav_title(String nav_title) {
            Nav_title = nav_title;
        }

        public String getNav_color() {
            return Nav_color;
        }

        public void setNav_color(String nav_color) {
            Nav_color = nav_color;
        }

        public String getNav_link_url() {
            return Nav_link_url;
        }

        public void setNav_link_url(String nav_link_url) {
            Nav_link_url = nav_link_url;
        }
    }

    /**
     * 首页的新品促销
     */
    public static class XMLKeyMainNewshopIn {
        public static String key_newshopin_title = "newshopin_title";
        public static String key_newshopin_title_color = "newshopin_title_color";/*标题的颜色*/
        public static String key_newshopin_photoaddr = "newshopin_photoaddr";/*图片地址*/
        public static String key_newshopin_text = "newshopin_text";
        public static String key_newshopin_text_color = "newshopin_text_color";
        public static String key_title_color = "title_color";/*控件标题的颜色*/
        public static String key_text_color = "text_color";/*控件的内容的颜色*/
        public static String key_status_color = "status_color";/*控件状态的文字颜色*/
        public static String key_status_back_color = "status_back_color";/*控件的状态背景颜色*/
        public static String key_values_title = "title";
        public static String key_values_text = "text";
        public static String key_values_status = "status";
        public static String key_values_img = "img";
        public static String key = "values";

    }


    /*用户界面的卡片*/
    public static class XMLValuesUserpageCard {
        public String card_title;

        public String getCard_title() {
            return card_title;
        }

        public void setCard_title(String card_title) {
            this.card_title = card_title;
        }

        public ArrayList<XMLValuesUserpageBtnItem> getList() {
            return list;
        }

        public void addList(XMLValuesUserpageBtnItem item) {
            if (list != null) {
                list.add(item);
            } else {
            }
        }

        /*存储Item的数量*/
        public ArrayList<XMLValuesUserpageBtnItem> list = new
                ArrayList<XMLValuesUserpageBtnItem>();


    }

    public static class XMLValuesUserpageBtnItem {
        public String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_color() {
            return title_color;
        }

        public void setTitle_color(String title_color) {
            this.title_color = title_color;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String title_color;
        public String img_url;
    }

    /*首页新品促销的商品表格*/
    public static class XMLValuesMainNewshopIn {
        public String title;
        public String title_color;
        public String text;
        public String text_color;
        public String status;
        public String status_color;
        public String status_back_color;
        public String img_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_color() {
            return title_color;
        }

        public void setTitle_color(String title_color) {
            this.title_color = title_color;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText_color() {
            return text_color;
        }

        public void setText_color(String text_color) {
            this.text_color = text_color;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus_color() {
            return status_color;
        }

        public void setStatus_color(String status_color) {
            this.status_color = status_color;
        }

        public String getStatus_back_color() {
            return status_back_color;
        }

        public void setStatus_back_color(String status_back_color) {
            this.status_back_color = status_back_color;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }
    }


    /*首页新品促销的初始化表格*/
    public class XMLInitMainNewshopIn {
        public String getBody_title() {
            return body_title;
        }

        public void setBody_title(String body_title) {
            this.body_title = body_title;
        }

        public String getBody_title_color() {
            return body_title_color;
        }

        public void setBody_title_color(String body_title_color) {
            this.body_title_color = body_title_color;
        }

        public String getBody_text() {
            return body_text;
        }

        public void setBody_text(String body_text) {
            this.body_text = body_text;
        }

        public String getBody_text_color() {
            return body_text_color;
        }

        public void setBody_text_color(String body_text_color) {
            this.body_text_color = body_text_color;
        }

        public String getPhoto_addr() {
            return photo_addr;
        }

        public void setPhoto_addr(String photo_addr) {
            this.photo_addr = photo_addr;
        }

        public String body_title;
        public String body_title_color;
        public String body_text;
        public String body_text_color;
        public String photo_addr;

    }


    /**
     * 首页的经销商管理的界面
     */

    public static class XMLtagMainMerchant {
        public static String key_merchant_title = "merchant_title";/*大界面标题*/
        public static String key_merchant_photoaddr = "merchant_photoaddr";/*图片的地址*/
        public static String key_merchant_values = "values";/*包裹开始标签*/
        public static String key_merchant_values_title = "title";/*控件值的标题*/
        public static String key_merchant_values_text = "text";/*控件的标语*/
        public static String key_merchant_values_status = "status";/*控件的状态*/
        public static String key_merchant_values_background = "background";/*控件的背景图片*/


        private static String merchant_title;

        public static String getMerchant_photoaddr() {
            return merchant_photoaddr;
        }

        public static void setMerchant_photoaddr(String merchant_photoaddr) {
            XMLtagMainMerchant.merchant_photoaddr = merchant_photoaddr;
        }

        private static String merchant_photoaddr;

        public static String getMerchant_title() {
            return merchant_title;
        }

        public static void setMerchant_title(String merchant_title) {
            XMLtagMainMerchant.merchant_title = merchant_title;
        }
    }


    /**
     * 首页的品牌促销的整理
     */
    public static class XMLtagMainBrandPromotion {
        public static String key_back = "background";
        public static String key_title_a = "title_a";
        public static String key_title_b = "title_b";
        public static String key_big_img = "big_img";
        public static String key_shop_b_img = "shop_b_img";
        public static String key_shop_a_img = "shop_a_img";
        public static String key_shop_c_img = "shop_c_img";
        public static String key_shop_a_title = "shop_a_title";
        public static String key_shop_b_title = "shop_b_title";
        public static String key_shop_c_title = "shop_c_title";
        public static String key_shop_a_price = "shop_a_price";
        public static String key_shop_b_price = "shop_b_price";
        public static String key_shop_c_price = "shop_c_price";


        public static String back;

        public static String getBack() {
            return back;
        }

        public static void setBack(String back) {
            XMLtagMainBrandPromotion.back = back;
        }

        public static String title_a;

        public static String getKey_back() {
            return key_back;
        }

        public static void setKey_back(String key_back) {
            XMLtagMainBrandPromotion.key_back = key_back;
        }

        public static String title_b;

        public static String getShop_c_price() {
            return shop_c_price;
        }

        public static void setShop_c_price(String shop_c_price) {
            XMLtagMainBrandPromotion.shop_c_price = shop_c_price;
        }

        public static String getShop_b_price() {

            return shop_b_price;
        }

        public static void setShop_b_price(String shop_b_price) {
            XMLtagMainBrandPromotion.shop_b_price = shop_b_price;
        }

        public static String getShop_a_price() {

            return shop_a_price;
        }

        public static void setShop_a_price(String shop_a_price) {
            XMLtagMainBrandPromotion.shop_a_price = shop_a_price;
        }

        public static String getShop_c_title() {

            return shop_c_title;
        }

        public static void setShop_c_title(String shop_c_title) {
            XMLtagMainBrandPromotion.shop_c_title = shop_c_title;
        }

        public static String getShop_b_title() {
            return shop_b_title;

        }

        public static void setShop_b_title(String shop_b_title) {
            XMLtagMainBrandPromotion.shop_b_title = shop_b_title;
        }

        public static String getShop_a_title() {

            return shop_a_title;
        }

        public static void setShop_a_title(String shop_a_title) {
            XMLtagMainBrandPromotion.shop_a_title = shop_a_title;
        }

        public static String getShop_c_img() {

            return shop_c_img;
        }

        public static void setShop_c_img(String shop_c_img) {
            XMLtagMainBrandPromotion.shop_c_img = shop_c_img;
        }

        public static String getShop_a_img() {
            return shop_a_img;

        }

        public static void setShop_a_img(String shop_a_img) {
            XMLtagMainBrandPromotion.shop_a_img = shop_a_img;
        }

        public static String getShop_b_img() {

            return shop_b_img;
        }

        public static void setShop_b_img(String shop_b_img) {
            XMLtagMainBrandPromotion.shop_b_img = shop_b_img;
        }

        public static String getBig_img() {

            return big_img;
        }

        public static void setBig_img(String big_img) {
            XMLtagMainBrandPromotion.big_img = big_img;
        }

        public static String getTitle_b() {

            return title_b;
        }

        public static void setTitle_b(String title_b) {
            XMLtagMainBrandPromotion.title_b = title_b;
        }

        public static String getTitle_a() {

            return title_a;
        }

        public static void setTitle_a(String title_a) {
            XMLtagMainBrandPromotion.title_a = title_a;
        }

        public static String big_img;
        public static String shop_b_img;
        public static String shop_a_img;
        public static String shop_c_img;
        public static String shop_a_title;
        public static String shop_b_title;
        public static String shop_c_title;
        public static String shop_a_price;
        public static String shop_b_price;
        public static String shop_c_price;


    }
}
