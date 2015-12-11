package alg;

public class MergeSort {
    public static void mergeSort(int[] a) {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] tmp, int left, int right) {
        if (left < right ) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[] a, int[] tmp, int lStart, int rStart, int rEnd) {
        int lEnd = rStart - 1;
        int start = lStart;
        int end = rEnd - start + 1;

        while (lStart <= lEnd && rStart <= rEnd)
            tmp[start++] = a[lStart] < a[rStart] ? a[lStart++] : a[rStart++];

        while (lStart <= lEnd)
            tmp[start++] = a[lStart++];

        while (rStart <= rEnd)
            tmp[start++] = a[rStart++];

        while (end-- > 0)
            a[rEnd] = tmp[rEnd--];
    }
}
