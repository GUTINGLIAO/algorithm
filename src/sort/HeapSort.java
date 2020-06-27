package sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 3, 5, 2, 5, 7};
        Sort sort = new Sort();
        sort.sort(a);
    }

}

class Sort {
    void sort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            shiftDown(a, i, a.length);
        }
        for (int j = a.length - 1; j >= 0; j--) {
            swap(a, 0, j);
            System.out.println(a[j]);
            shiftDown(a, 0, j);
        }
    }

    private void shiftDown(int[] a, int i, int len) {
        int temp = a[i];
        for (int k = 2 * i + 1; k < len; k = k * 2 + 1) {
            if (k + 1 < len && a[k] > a[k + 1]) k++;
            if (a[k] < temp) {
                a[i] = a[k];
                i = k;
            } else {
                break;
            }
        }
        a[i] = temp;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
