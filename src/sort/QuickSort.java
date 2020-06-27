package sort;

import java.util.Arrays;

/**
 * 快排
 * 基本思想：选定一个基准值（这里选用了最后一个元素），然后找到左边大于等于基准值的元素移到右边，再找到右边小于基准值
 * 的元素移到左边空出来的位置，最后左右相遇时将基准值赋到对应的位置
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 7, 2, 6, 3, 7, 2, 8};
        ArrayQuickSort arrayQuickSort = new ArrayQuickSort();
        arrayQuickSort.sort(a, 0, 8);
        Arrays.stream(a).forEach(System.out::println);

    }

}

class ArrayQuickSort {

    void sort(int[] a, int begin, int end) {
        if (begin >= end) return;
        int temp = a[end];
        int left = begin;
        int right = end;
        while (left < right) {
            while (left < right && a[left] <= temp) left++;
            a[right] = a[left];
            while (left < right && a[right] >= temp) right--;
            a[left] = a[right];
        }
        a[left] = temp;
        sort(a, begin, left - 1);
        sort(a, left + 1, end);
    }

}
