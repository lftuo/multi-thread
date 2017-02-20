package chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Created by MrTuo on 2017/2/20.
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        // sleepThread不停地尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(),"SleepRunner");
        sleepThread.setDaemon(true);
        // busyThread 不停地运行
        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        // 休眠5秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
        SleepUtils.second(2);
    }

    // 不停地休眠
    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }

    // 一直运行
    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true){

            }
        }
    }
}
