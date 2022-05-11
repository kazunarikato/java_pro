package my_graph1;

import java.util.LinkedList;

public class AllShortestPath {
	
	public int[][] all_path_length(MyGraph mg){
		int num=mg.nodes.size();
		int d[][]=new int[num][num];
		final int INF=9999999;
		
		for(int i=0;i<mg.nodes.size();i++){
			for(int j=0;j<mg.nodes.size();j++){
				d[i][j]=INF;
			}
		}

		
		for(int i=0;i<mg.nodes.size();i++){
			LinkedList<MyEdge> me=mg.getEdges(i);//頂点iの隣接頂点を取得
			for(MyEdge mmyedge:me){
				d[i][mmyedge.getId()]=mmyedge.getWeight();//頂点iから
			}
		}
		for(int k=1;k<mg.nodes.size();k++){//kよりも小さい頂点を通る。
			for(int i=0;i<mg.nodes.size();i++){
				for(int j=i+1;j<mg.nodes.size();j++){
					if(d[i][j]>d[i][k]+d[k][j]){
						d[i][j]=d[i][k]+d[k][j];
					}
				}
			}
		}
		return d;
	}
}
