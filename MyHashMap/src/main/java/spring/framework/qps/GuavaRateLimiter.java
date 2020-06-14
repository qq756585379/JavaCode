package spring.framework.qps;

// https://blog.51cto.com/zhangfengzhe/2066683
public class GuavaRateLimiter {

    /**
     * Guava不仅仅在集合、缓存、异步回调等方面功能强大，而且还给我们封装好了限流的API！
     * Guava RateLimiter基于令牌桶算法，我们只需要告诉RateLimiter系统限制的QPS是多少，
     * 那么RateLimiter将以这个速度往桶里面放入令牌，然后请求的时候，
     * 通过tryAcquire()方法向RateLimiter获取许可（令牌）。
     */
    public static void main(String[] args) {

    }
}
