package sort;


import java.util.Arrays;

/**
 * 冒泡排序
 * 主要思想：双重循环，进行n次冒泡，每次冒泡操作时元素两两比较，若左边>右边，
 * 则交换值，一轮冒泡之后，会有一个较大值沉底
 * 时间复杂度：O(n2)
 */
public class PopSort {

    public static void main(String[] args) {
        int[] array = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        Arrays.stream(array).forEach(System.out::println);
    }

}
