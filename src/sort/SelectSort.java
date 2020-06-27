package sort;


import java.util.Arrays;

/**
 * 选择排序
 * 主要思想: 双重循环，每次找到最小的值和第i个元素交换
 * 时间复杂度：O(n2)
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < 8; i++) {
            int min = array[i];
            int index = i;
            for (int j = i + 1; j < 9; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = min;
        }
        Arrays.stream(array).forEach(System.out::print);
    }

}
