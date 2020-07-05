package graph;

public class Edge {
	private GraphNode first;
	private GraphNode second;

	public Edge(GraphNode first, GraphNode second) {
		this.first = first;
		this.second = second;
	}

	public GraphNode getFirst() {
		return first;
	}
	
	public void setFirst(GraphNode first) {
		this.first = first;
	}
	
	public GraphNode getSecond() {
		return second;
	}
	
	public void setSecond(GraphNode second) {
		this.second = second;
	}
	
	@Override
	public String toString() {
		return "Edge (" + first.getName() + "," + second.getName() + ")";
	}
}

