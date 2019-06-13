package shlm.canshu.com.canshu.LazyCatProgramUnt.Factory;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage.WAIT_ITME_DIALOGPAGE;
import shlm.canshu.com.canshu.LazyCatProgramUnt.Config;


public class WaitDialog {

    public static RefreshDialog instanceRefreshDialog(Context _Context) {
        return new RefreshDialog(_Context);
    }

    public static class RefreshDialog extends Dialog implements View.OnClickListener {
        private Context mContext;
        private WAIT_ITME_DIALOGPAGE _wait_itme_dialogpage;

        public RefreshDialog(Context context) {
            super(context);
            this.mContext = context;
        }

        @SuppressLint("LongLogTag")
        public void Init(WAIT_ITME_DIALOGPAGE wait_itme_dialogpage) {
            if (wait_itme_dialogpage != null) {
                this._wait_itme_dialogpage = wait_itme_dialogpage;
                setContentView(this._wait_itme_dialogpage.getView());
            } else {
                Log.e(Config.DEBUG, "WaitDialogRefreshDilog[+]没有初始化表格");
            }
        }

        /**
         * 配置显示的dialog
         *
         * @param msg      提示的信息
         * @param canClose 是否可以关闭
         */
        @SuppressLint("LongLogTag")
        public void showRefreshDialog(String msg, boolean canClose) {
            Window wd = getWindow();
            WindowManager.LayoutParams params = wd.getAttributes();
            ImageView img = findViewById(this._wait_itme_dialogpage.getImg());
            if (img == null) {
                Log.e(Config.DEBUG, "为NULL");
                Log.e(Config.DEBUG, "imageid" + this._wait_itme_dialogpage.getImg());
                return;
            }
            RotateAnimation rotateAnimation = new RotateAnimation(0f, 359f, Animation
                    .RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5F);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(-1);
            img.setAnimation(rotateAnimation);//开始旋转
            TextView tv = findViewById(_wait_itme_dialogpage.getTitle());
            if (tv == null) {
                //没有标题 就不要设置
            } else {
                tv.setText(msg.toString().trim());

            }
            params.gravity = Gravity.CENTER;
            wd.setAttributes(params);
            show();
        }

        @Override
        public void onClick(View v) {

        }
    }
}
