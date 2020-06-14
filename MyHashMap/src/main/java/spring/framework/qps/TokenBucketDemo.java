package spring.framework.qps;

public class TokenBucketDemo {

    private static long time = System.currentTimeMillis();
    private static int createTokenRate = 3;
    private static int size = 10;
    private static int tokens = 0;

    public static boolean grant() {
        long now = System.currentTimeMillis();
        int in = (int) ((now - time) / 50 * createTokenRate);
        tokens = Math.min(size, tokens + in);
        time = now;
        if (tokens > 0) {
            --tokens;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (grant()) {
                        System.out.println("执行业务");
                    } else {
                        System.out.println("限流");
                    }
                }
            }).start();
        }
    }
}
