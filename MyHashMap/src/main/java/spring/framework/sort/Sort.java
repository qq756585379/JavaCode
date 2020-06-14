package spring.framework.sort;

public class Sort {

    public static void main(String[] args) {
        sort2();
    }

    /**
     * 选择排序
     */
    private static void sort() {
        int[] arr = {1, 3, 2, 45, 65, 33, 12};
        System.out.println("交换之前：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        System.out.println();
        System.out.println("交换后：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * 冒泡排序
     */
    private static void sort2() {
        int[] arr = {1, 3, 2, 45, 65, 33, 12};
        System.out.println("交换之前：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println();
        System.out.println("交换后：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
