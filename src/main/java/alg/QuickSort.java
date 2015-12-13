package alg;

public class QuickSort {

    public static void sort(int[] a) {
        if (null == a || a.length <= 1) {
            return;
        }
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int p = partition(a, lo, hi);
            quickSort(a, lo, p-1);
            quickSort(a, p + 1, hi);
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v)
                if (i == hi) break;

            while (v < a[--j])
                if (j == lo) break;

            if (i >= j) break;

            swap(a, i, j);
        }

        swap(a, lo, j);

        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
