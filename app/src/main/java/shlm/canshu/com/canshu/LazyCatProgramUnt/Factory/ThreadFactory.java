package shlm.canshu.com.canshu.LazyCatProgramUnt.Factory;


import android.util.Log;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import shlm.canshu.com.canshu.LazyCatProgramUnt.Config;


/**
 * 多线程处理类
 */
public class ThreadFactory {
    private boolean can_load;
    private ThreadPoolExecutor threadPoolExecutor;

    public ThreadFactory() {
        can_load = true;
    }

    /**
     * 使用多线程处理事务
     */
    public void doThread(List<Runnable> r_list) {
        Log.e(Config.DEBUG, "doThread");
        //基本线程池
        threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new
                LinkedBlockingQueue<Runnable>(100));
        Log.e(Config.DEBUG, "doThread2" + r_list.size());
        for (int i = 0; i < r_list.size(); i++) {
            if (this.can_load) {
                Log.e(Config.DEBUG, "can_load");
                threadPoolExecutor.execute(r_list.get(i));
            } else {
                threadPoolExecutor.shutdownNow();
                Log.e(Config.DEBUG, "canno_load");

            }
        }
    }

    public void Stop() {
        this.can_load = false;//不可以加载
        threadPoolExecutor.shutdownNow();//关闭
        threadPoolExecutor = null;
    }

    public void Restart(List<Runnable> r_list) {
        this.can_load = true;
        if (threadPoolExecutor != null) {
            doThread(r_list);

        }
    }


}
