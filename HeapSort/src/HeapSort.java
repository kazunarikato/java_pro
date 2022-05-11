package heap_sort2;

public class HeapSort {
	public void down_heap(int[] a, int reaf){
		int root=2;
		while(root<=reaf){
			updateHeap(a, root);
			root++;
		}
	}
	public void updateHeap(int[] a, int p){
		int i=p;
		while(i>1){
			if(a[i]>a[i/2]){
				int buf=a[i];
				a[i]=a[i/2];
				a[i/2]=buf;
			}
			i=i/2;
			for(int j=0;j<a.length;j++){
				System.out.print(a[j]+ " ");
				if(j==p){
					System.out.print("| ");
				}
			}
			System.out.println();
		}
		System.out.println("-");
	}
	public void sort(int[] a){
		for(int reaf=a.length-1;reaf>1;reaf--){
			System.out.println("----");
			down_heap(a, reaf);
			int buf=a[1];
			a[1]=a[reaf];
			a[reaf]=buf;
		}

	}
}
