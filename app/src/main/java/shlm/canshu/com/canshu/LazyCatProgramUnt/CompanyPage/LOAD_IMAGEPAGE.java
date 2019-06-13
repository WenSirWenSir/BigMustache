package shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage;


import android.widget.LinearLayout;

import java.io.File;

/**
 * 在线程池中下载时候 要传入的IMAGE的值
 */
public class LOAD_IMAGEPAGE {
    private LinearLayout imgBody;
    private String LruchTag;

    public File getDefaultFile() {
        return defaultFile;
    }

    public void setDefaultFile(File defaultFile) {
        this.defaultFile = defaultFile;
    }

    private File defaultFile;//默认的图片缓存路径

    private String img_url;

    public String getSaveName() {
        return saveName;
    }


    /**
     * 保存到本地的图片名字 必须加后缀名字
     *
     * @param saveName
     */
    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    private String saveName;

    public String getPostPixt() {
        return postPixt;
    }

    public void setPostPixt(String postPixt) {
        this.postPixt = postPixt;
    }

    private String postPixt;

    public LinearLayout getImg() {
        return this.imgBody;
    }

    public void setImgBody(LinearLayout _imgBody) {
        this.imgBody = _imgBody;
    }


    /**
     * 保存到缓存的
     *
     * @return
     */
    public String getLruchTag() {
        return LruchTag;
    }

    public void setLruchTag(String tag) {
        this.LruchTag = tag;
    }


    /**
     * 获取一个图片的地址  一般的格式为
     * dirs/name.jpg
     *
     * @return
     */
    public String getImg_url() {
        return img_url;
    }


    /**
     * 设置一个图片的地址 一般格式为
     * dirs/name.jpg
     *
     * @param img_url
     */
    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }


    /**
     * 清空所有的数据信息
     */
    public void clear() {
        this.imgBody = null;
        this.img_url = "";
        this.LruchTag = "";
    }
}
