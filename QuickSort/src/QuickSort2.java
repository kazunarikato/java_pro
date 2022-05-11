import java.util.ArrayList;

public class QuickSort2 {
	public int pivot(int i) {
		return i;
	}
	
	public void quickSort2(ArrayList<Integer> arrayList, int left, int right) {
		if(left > right) {
			return;
		}
		int l = left;
		int r = right;
		int p = pivot(left);
		
		//ピボットを左端に
		int buf = arrayList.get(p);
		arrayList.set(p, arrayList.get(left));
		arrayList.set(left, buf);
		
		while(l <= r) {
			if((l < right) && (arrayList.get(left) < arrayList.get(l))) {
				l++;
			}
			if((r >= left) && (arrayList.get(left) >= arrayList.get(r))) {
				r++;
			}
			if(l >= r) {
				buf = arrayList.get(l);
				arrayList.set(l, arrayList.get(r));
				arrayList.set(r, buf);
			}
		}
		
		buf = arrayList.get(left);
		arrayList.set(left, arrayList.get(l-1));
		arrayList.set(l-1, buf);
		quickSort2(arrayList, left, l-1);
		quickSort2(arrayList, l, right);
	}

}
