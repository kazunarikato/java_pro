import java.util.*;

class MergeSort {
    public static void sort(ArrayList<Integer> arrayList) {
        sortImpl(arrayList, 0, arrayList.size());
    }

    // sorting arrayList[l..r)
    private static void sortImpl(ArrayList<Integer> arrayList, int l, int r) {
        if(r - l > 1) {
            int mid = (l+r)/2;
            sortImpl(arrayList, l, mid);
            sortImpl(arrayList, mid, r);
            merge(arrayList, l, mid, r);
        }
    }

    private static void merge(ArrayList<Integer> arrayList, int l, int m, int r) {
        int lSize = m - l;
        int rSize = r - m;
        int[] L = new int[lSize+1];
        int[] R = new int[rSize+1];
        for(int i=0; i<lSize; ++i) {
            L[i] = arrayList.get(l+i);
        }
        for(int i=0; i<rSize; ++i) {
            R[i] = arrayList.get(m+i);
        }
        L[lSize] = Integer.MAX_VALUE;
        R[rSize] = Integer.MAX_VALUE;
        for(int i=0, j=0, k=l; k<r; ++k) {
            if(L[i] <= R[j]) {
                arrayList.set(k, L[i]);
                i++;
            } else {
                arrayList.set(k, R[j]);
                ++j;
            }
        }
    }
};
