package my_graph1;

import java.util.*;
import java.io.*;

import java.util.LinkedList;

public class MyGraph {
	
	ArrayList<LinkedList<MyEdge>> nodes;
	int[] prev;
	
	MyGraph(){
		nodes=new ArrayList<LinkedList<MyEdge>>();
	}
	
	public void ReadFromFile(String filename){
		//nodes=new ArrayList<LinkedList<MyEdge>>();
		int v;	//頂点数
		int e;	//枝数
		int node;	//頂点
		int next;	//もう一方の頂点
		int w;		//枝の重み
		String str;	//一時記憶用文字列
		int ne=0, nv=0;	//読み込んでいる頂点の個数を保持する
		int node_buf=-1;
		try{
			File inputFile=new File(filename);
			Scanner sc=new Scanner(inputFile);
			//1行目
			str=sc.next();
			v=Integer.parseInt(str);//一行目は頂点数
			if(v>50){
				System.out.println("頂点数が50を超えています");
				return;
			}
			//2行目
			str=sc.next();
			e=Integer.parseInt(str);//二行目は枝数
			if(e>100){
				System.out.println("枝の本数が100を超えています");
				return;
			}
			//v個のインスタンスを生成
			for(int i=0;i<v;i++){
				nodes.add(i, new LinkedList<MyEdge>());
			}
			//3行目から
			while(sc.hasNext()){
				if(ne>e){//2行目に書かれた頂点数よりも多い頂点になったら
					System.out.println("記載された枝数と実際の枝数があっていません");
					System.out.println("ファイルを確認してください");
				}
				//一文字目:頂点番号
				str=sc.next();
				node=Integer.parseInt(str);
				
				//二文字目:隣接頂点
				str=sc.next();
				next=Integer.parseInt(str);
				//三文字目:重み
				str=sc.next();
				w=Integer.parseInt(str);
				if(w>9999 || w<1){
					System.out.println("枝の重みが0以下または10000以上なので不正です。");
					System.out.println("この枝は破棄されます。");
					continue;
				}
				//グラフへの要素の追加
				
				nodes.get(node).add(new MyEdge(next, w));
				//逆方向のエッジも追加(自作グラフを使うとき)
				nodes.get(next).add(new MyEdge(node, w));
				//Ssc.close();
				ne++;
			}
			if(ne>100){
				
			}
		}catch(FileNotFoundException ex){
			System.out.println("ファイルが見つかりませんでした");
			return;
		}
	}
	
	//idの頂点の隣接頂点を取得
	public LinkedList<MyEdge> getEdges(int id){
		return nodes.get(id);
	}
	
	//v0からいける全ての頂点を捜査
	public ArrayList<Integer> GraphSearch(int v0){
		
		LinkedList<Integer> A=new LinkedList<Integer>();//スタック
		ArrayList<Integer> B=new ArrayList<Integer>();
		
		A.push(v0);//Aに最初の頂点v0をしまう
		B.add(v0);
		
		while(!A.isEmpty()){//Aが空でなければ
			System.out.println("A="+A);
			System.out.println("B="+B);
			int v=A.pop();//Aから頂点要素を取り出す⇨vへ
			System.out.println("v="+v);
			LinkedList<MyEdge> node=getEdges(v);//vの隣接頂点を取得
			System.out.println("node="+node);
			for(MyEdge mmyedge:node){
				if(!B.contains(mmyedge.getId())){
					A.push(mmyedge.getId());
					B.add(mmyedge.getId());
				}
			}
			System.out.println();
		}
		return B;
	}
	
	//最短経路探索
	public int ShortestPath(int vs, int vt){
		int d[]=new int[nodes.size()];
		int prev[]=new int[nodes.size()];
		final int INF=9999999;
		
		d[vs]=0;
		for(int i=0; i<nodes.size();i++){
			if(i!=vs){
				d[i]=INF;
			}
		}
		
		ArrayList<Integer> A=new ArrayList<Integer>();
		//ArrayList<Integer> B=new ArrayList<Integer>();
		
		//Aにスタート地点を格納
		A.add(vs);
		//B.add(vs);
		
		while(true){
			int buf=INF;
			int num=0;
			//System.out.println("A="+A);
			
			//Aに含まれる点の中でdが最小のものを探す
			for(int i=0;i<A.size();i++){
				//System.out.println("d["+A.get(i)+"]="+d[A.get(i)]);
				if(d[A.get(i)]<buf){
					buf=d[A.get(i)];
					num=i;
				}
			}
			
			int v=A.get(num);//Aの中でdが最少となった点v
			//B.add(v);
			//System.out.println("v="+v);
			A.remove(num);
			
			int ls=v;
			//System.out.print("current path="+v+" ");
			while(ls!=vs){
				//System.out.print(prev[ls]+" ");
				ls=prev[ls];
			}
			//System.out.println();
			
			//dの表示
			//for(int i=0;i<d.length;i++){
				//System.out.println("d["+i+"]="+d[i]);
			//}
			
			//ヒープを使った方法
			/*
			HeapSort hs=new HeapSort();
			hs.downheap(A,  A.size()-1, 0);
			int v=A.get(0);
			A.remove(0);
			*/
			
			//ゴールに着いたらループを抜ける
			if(v==vt){
				break;
			}
			LinkedList<MyEdge> edges=getEdges(v);//vの隣接頂点をリストへ
			//System.out.println("edges="+edges);
			for(MyEdge mmyedge:edges){//リストを探索
				if(d[mmyedge.getId()]==INF){//スタート地点からの距離が無限大に設定されているものを
					A.add(mmyedge.getId());//Aに追加
					d[mmyedge.getId()]=d[v]+mmyedge.getWeight();//スタート地点からの距離を更新
					prev[mmyedge.getId()]=v;//直前の経路を記憶
					//System.out.println("prev["+mmyedge.getId()+"]="+prev[mmyedge.getId()]);
				}
				else if(d[mmyedge.getId()]>d[v]+mmyedge.getWeight()){//保存されているスタート地点からの距離より新たに探索した経路の距離が短かったら
					d[mmyedge.getId()]=d[v]+mmyedge.getWeight();//スタート地点からの距離を更新
					prev[mmyedge.getId()]=v;//直前の距離を記憶
					//System.out.println("perv["+mmyedge.getId()+"]="+prev[mmyedge.getId()]);
				}
			}
			//System.out.println("B="+B);
			//System.out.println();
		}
		int ls=vt;
		//System.out.print("path="+vt+" ");
		while(ls!=vs){
			//System.out.print(prev[ls]+" ");
			ls=prev[ls];
		}
		//System.out.println();
		return d[vt];
	}
}
