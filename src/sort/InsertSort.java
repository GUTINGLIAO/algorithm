package sort;


import java.util.Arrays;

/**
 * 插入排序
 * 主要思想：遍历元素，对于每一个元素a，将其与前一个元素b做比较，若a < b, 则交换ab，直到a插入正确位置
 * 时间复杂度：
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 1; i < 9; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
        Arrays.stream(array).forEach(System.out::print);
    }

}
