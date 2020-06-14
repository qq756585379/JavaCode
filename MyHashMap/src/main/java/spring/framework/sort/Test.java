package spring.framework.sort;

public class Test {

    public static void main(String[] args) {
        // rabits(9);
        rabits2();
    }

    /**
     * 一对兔子，每三个月生产2只兔子，求每个月有多少只兔子
     */
    private static int rabits(int month) {
        int r = 2;
        for (int i = 1; i <= month; i++) {
            if (i % 3 == 0) {
                r = r * 2;
                System.out.println("开始生产");
            }
            System.out.println("第" + i + "月，" + r + "只兔子");
        }
        return r;
    }

    /**
     * 有一对兔子，从出生到第3个月起每个月都会生一对兔子，小兔子长到第三个月后每个月又会生一对兔子，假如兔子都不会死，问每个月的兔子总数为多少？
     * 兔子总数分别为：1、1、2、3、5、8、13……
     */
    private static void rabits2() {
        for (int i = 1; i < 20; i++) {
            System.out.println("第" + i + "个月兔子数为：" + f(i));
        }
    }

    private static int f(int x) {
        if (x == 1 || x == 2) {
            return 1;
        } else {
            return f(x - 1) + f(x - 2);
        }
    }
}
