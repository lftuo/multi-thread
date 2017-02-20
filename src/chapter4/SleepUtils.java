package chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Created by MrTuo on 2017/2/19.
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
