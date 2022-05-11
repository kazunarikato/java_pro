package my_graph1;

import java.util.*;
import java.io.*;

public class MyGraphTest {
	public static void main(String args[]){
		final int INF=9999999;
		MyGraph mg=new MyGraph();
		LinkedList<MyEdge> edges;
		int num;
		String str;
		
		
		
		System.out.println("ファイル名を入力してください");
		Scanner sc1=new Scanner(System.in);
		String filename=sc1.next();
		
		mg.ReadFromFile(filename);
		//System.out.println(mg.nodes);
		
		//指定した頂点から行くことができる全ての頂点の羅列--------
		/*
		ArrayList<Integer> graph=new ArrayList<Integer>();
		graph=mg.GraphSearch(0);
		System.out.println(graph);
		System.out.println();
		*/
		//---------------------------------------------
		//最短径路探索--------------------------------
		//System.out.println("始点を入力してください");
		//Scanner vs=new Scanner(System.in);
		//int vsi=Integer.parseInt(vs.next());
		//System.out.println("終点を入力してください");
		//Scanner vt=new Scanner(System.in);
		//int vti=Integer.parseInt(vt.next());
		
		int num1=mg.nodes.size();
		long start=System.currentTimeMillis();
		for(int vsi=0;vsi<num1;vsi++){
			for(int vti=vsi+1;vti<num1;vti++){
				int length=mg.ShortestPath(vsi, vti);
				System.out.println(vsi+"to"+vti+":"+"Length="+length);
			}
		}
		long end=System.currentTimeMillis();
		System.out.println((end-start)+"ms");
		
		//-----------------------------------------
		
		//指定した頂点の隣接点の羅列-------------------------------
		//while(true){
		/*
			System.out.println("頂点を入力");
			Scanner sc=new Scanner(System.in);
			str=sc.next();
			try{
				num=Integer.parseInt(str);
				//if(str.equals("exit")){
					//break;
				//}
				if(num>=0 && num<mg.nodes.size()){
					edges=mg.getEdges(num);
					for(MyEdge mmedge:edges){
						System.out.println(mmedge);
					}
				}
				else{
					System.out.println("不正な値です");
					//continue;
				}
			}catch(NumberFormatException ex){
				System.out.println("不正な値です");
			}
			sc.close();
			*/
//		}
		//System.out.println(mg.nodes);
		//--------------------------------------------
		
		//全ての頂点間の最短経路を取得（動的計画法）---------------
		try{
			File outputfile=new File("out.txt");
			FileWriter writer=new FileWriter(outputfile);
			String line_sep=System.getProperty("line.separator");
			
			start=System.currentTimeMillis();
			int d[][]=new int[mg.nodes.size()][mg.nodes.size()];
			AllShortestPath asp=new AllShortestPath();
			d=asp.all_path_length(mg);
			for(int i=0;i<mg.nodes.size();i++){
				for(int j=i+1;j<mg.nodes.size();j++){
					if(d[i][j]<INF){
						System.out.println("d["+i+"]"+"["+j+"]="+d[i][j]);
						writer.write("d["+i+"]"+"["+j+"]="+d[i][j]+line_sep);
					}
				}
			}
			end=System.currentTimeMillis();
			System.out.println((end-start)+"ms");
			writer.close();
		}catch(IOException ex){
			System.out.println("ファイルの出力に失敗しました");
		}
		//-----------------------------------------------
		
	}
}
