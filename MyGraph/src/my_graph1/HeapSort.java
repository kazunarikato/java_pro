package my_graph1;

import java.util.ArrayList;

public class HeapSort {
	public void downheap(int[] a, int leaf, int root){
		int i;
		i=root*2;//子の左側を指定
		if(i<=leaf){//子が葉よりも小さければ
			if(i<leaf && a[i+1]>a[i]){//子が葉より小さく、右の子が左の子より大きい時
				i++;//指定を右の子へ
			}
			if(a[root]>=a[i]){return;}//親の方が子より大きい時は抜ける
			int buf=a[root];//要素の交換
			a[root]=a[i];	//親に小さい値を移動させる。
			a[i]=buf;
			
			downheap(a, leaf, i);//子を親として繰り返し。
		}
		/*while(i<=leaf){
			if(i<leaf && a[i+1]>a[i]){
				i++;
			}
			if(a[root]>=a[i]){
				break;
			}
			int buf=a[root];
			a[root]=a[i];
			a[i]=buf;
			
			root=i;
			i=root*2;
		}*/
	}
	//ArrayList番
	public void downheap(ArrayList<Integer> a, int leaf, int root){
		int i;
		i=root*2;
		if(i<=leaf){
			if(i<leaf && a.get(i+1)>a.get(i)){
				i++;
			}
			if(a.get(root)>=a.get(i)){return;}
			int buf=a.get(root);
			a.set(root,  a.get(i));
			a.set(i, buf);
		}
	}
	
	public int[] sort(int[] a, int n){
		int leaf, root;
		
		leaf=n;
		root=n/2;
		
		while(root>0){
			downheap(a, leaf, root);
			root--;
		}
		//System.out.println("半順序木を構成：");
		
		while(leaf>0){
			int buf=a[1];
			a[1]=a[leaf];
			a[leaf]=buf;
			leaf--;
			downheap(a, leaf, 1);
		}
		int[] out=a;
		return out;
	}
}
