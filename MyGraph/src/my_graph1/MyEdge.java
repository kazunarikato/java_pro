package my_graph1;

public class MyEdge {
	private int id, weight;
	
	public MyEdge(int id, int weight){
		this.id=id;
		this.weight=weight;
	}
	
	public int getId(){return id;}
	public int getWeight(){return weight;}
	
	public String toString(){
		return id+" "+weight;
	}
}
