package shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyAct;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 展示的图片可以放大或者是缩小
 */
public class ZzomImage extends LazyCatAct {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 创建布局
         */
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams
                .MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        ImageView img = new ImageView(layout.getContext());
        setContentView(layout);
    }
}
