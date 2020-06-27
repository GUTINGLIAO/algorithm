package sort;

import java.util.Arrays;

/**
 * 归并排序
 * 基本思想：将数组或链表等分成两部分，先对每一部分进行归并排序，再合并两个部分
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] a = new int[]{2, 6, 4, 7, 8, 34, 2, 5};
//        ArraySort arraySort = new ArraySort();
//        arraySort.mergeSort(a, 0, 7);
//        Arrays.stream(a).forEach(System.out::println);
        Node node = new Node(3);
        node.next = new Node(1);
        node.next.next = new Node(5);
        node.next.next.next = new Node(4);
        ListSort listSort = new ListSort();
        listSort.mergeSort(node, 4);
        for (int i = 0; i < 4; i++) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}

/**
 * 数组实现
 */
class ArraySort {

    void mergeSort(int[] arr, int begin, int end) {
        if (begin == end) return;
        int middle = (begin + end) / 2;
        mergeSort(arr, begin, middle);
        mergeSort(arr, middle + 1, end);
        merge(arr, begin, end);
    }
    private void merge(int[] arr, int begin, int end) {
        int[] temp = new int[end - begin + 1];
        int middle = (begin + end) / 2;
        int i = begin, j = middle + 1, k = 0;
        while (i <= middle && j <= end) {
            if (arr[i] < arr[j]) temp[k] = arr[i++];
            else temp[k] = arr[j++];
            k++;
        }
        while (i <= middle) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];
        k = 0;
        for (i = begin; i <= end; i++) arr[i] = temp[k++];
    }
}

/**
 * 链表实现
 */

class Node {
    Node next;
    int val;

    Node(int val) {
        this.val = val;
    }
}

class ListSort {
    void mergeSort(Node node, int len) {
        Node start = node;
        if (len == 1) return;
        int middle = len / 2;
        mergeSort(node, middle);
        for (int i = 0; i < middle; i++) {
            node = node.next;
        }
        if (len % 2 == 0) middle--;
        mergeSort(node, middle + 1);
        merge(start, len);
    }

    private void merge(Node node, int len) {
        int middle = len / 2;
        Node temp = new Node(0);
        Node start = node;
        Node tempStart = temp;
        Node left = node;
        int i = 1, j = middle + 1;
        for (int k = 0; k < middle; k++) {
            node = node.next;
        }
        while (i <= middle && j <= len) {
            if (left.val > node.val) {
                temp.val = node.val;
                node = node.next;
                j++;
            } else {
                temp.val = left.val;
                left = left.next;
                i++;
            }
            temp = temp.next = new Node(0);
        }
        while (i <= middle) {
            temp.val = left.val;
            left = left.next;
            temp = temp.next = new Node(0);
            i++;
        }
        while (j <= len) {
            temp.val = node.val;
            node = node.next;
            temp = temp.next = new Node(0);
            j++;
        }
        for (i = 0; i < len; i++) {
            start.val = tempStart.val;
            start = start.next;
            tempStart = tempStart.next;
        }
    }
}
