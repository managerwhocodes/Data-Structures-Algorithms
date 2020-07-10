package graph;

import java.util.ArrayList;
import java.util.Stack;

public class DFSAdjMatrix{

    private ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    private int [][] adjMatrix;

    private DFSAdjMatrix(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        this.adjMatrix = new int[nodeList.size()][nodeList.size()];
    }

    private void bfs(GraphNode node){
        Stack<GraphNode> stack = new Stack<GraphNode>();
        stack.add(node);
        while(!stack.isEmpty()){
            GraphNode presentNode = stack.pop();
            presentNode.setVisited(true); 
            
            System.out.print(presentNode.getName()+" ");
            presentNode.setNeighbours(getNeighbors(presentNode));
            
            for(GraphNode neighbour : presentNode.getNeighbours()) {
                if(!neighbour.isVisited()) {
                    stack.push(neighbour);
                    neighbour.setVisited(true);
                }
            }
        }
    }

    private void addUndirectedEdge(int i, int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    private ArrayList<GraphNode> getNeighbors(GraphNode node) {
		ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
		int nodeIndex = node.getIndex();

		for(int i=0; i<adjMatrix.length;i++) {
			if(adjMatrix[nodeIndex][i]==1) {
				neighbors.add(nodeList.get(i));
			}
		}
		return neighbors;
	}

    public static void main(String args[]){

        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

        for(int i=0;i<10;i++){
            nodeList.add(new GraphNode("V"+i,i));
        }

        DFSAdjMatrix graph = new DFSAdjMatrix(nodeList);

        graph.addUndirectedEdge(0,1);
		graph.addUndirectedEdge(0,3);
		graph.addUndirectedEdge(1,2);
		graph.addUndirectedEdge(1,4);
		graph.addUndirectedEdge(2,5);
		graph.addUndirectedEdge(2,9);
		graph.addUndirectedEdge(3,6);
		graph.addUndirectedEdge(4,7);
		graph.addUndirectedEdge(5,8);
		graph.addUndirectedEdge(6,7);
		graph.addUndirectedEdge(7,8);
		graph.addUndirectedEdge(8,9);
		
        System.out.println("Printing BFS from source: "+nodeList.get(0).getName());
        graph.bfs(nodeList.get(0));

    }
}