package chapter4;

/**
 * Created by MrTuo on 2017/2/19.
 */
public class Daemon {
    public static void main(String[] args){
        Thread thread = new Thread(new DaemonRunner(),"DarmonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try {
                SleepUtils.second(100);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
