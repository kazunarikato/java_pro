package heap_sort2;

public class sort_test {
	public static void showArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		int[] a={0, 3, 5, 4, 6, 8, 10, 20, 11, 23, 549, 20, 394, 232, 54, 101, 2, 212, 5948, 102, 29, 31, 92};
		showArray(a);
		HeapSort hs=new HeapSort();
		hs.sort(a);
		showArray(a);
	}
}
