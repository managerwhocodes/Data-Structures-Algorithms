package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSFindPath{

    private ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    private BFSFindPath(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
    }

    private static void printPath(GraphNode node){
        if(node.getParent() != null)
            printPath(node.getParent());
        System.out.print(node.getName()+" ");
    }

    // Set parent in the original BFS to print the path
    private void bfs(GraphNode node){
    	
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            GraphNode currentNode = queue.poll();
            currentNode.setVisited(true);
            
            System.out.print("Path for node "+currentNode.getName()+" :  ");
            printPath(currentNode);
            System.out.println();
            
            for(GraphNode neighbour : currentNode.getNeighbours()){
                if(!neighbour.isVisited()){
                    queue.add(neighbour);
                    neighbour.setVisited(true);
                    // Set parent to print the path
                    neighbour.setParent(currentNode);
                }
            }
        }
    }

    private void addUndirectedEdge(int i, int j) {
		GraphNode source = nodeList.get(i);
		GraphNode destination = nodeList.get(j);
		source.getNeighbours().add(destination);
		destination.getNeighbours().add(source);
	}

    public static void main(String args[]){

        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        //Use this to change the source
        int source = 3;

		for(int i=0;i<10; i++) {
			nodeList.add(new GraphNode("V"+i));
		}

		BFSFindPath graph = new BFSFindPath(nodeList);

		graph.addUndirectedEdge(0,8);
		graph.addUndirectedEdge(8,2);
		graph.addUndirectedEdge(8,9);
		graph.addUndirectedEdge(2,1);
		graph.addUndirectedEdge(9,1);
		graph.addUndirectedEdge(2,4);
		graph.addUndirectedEdge(1,3);
		graph.addUndirectedEdge(1,7);
		graph.addUndirectedEdge(3,4);
		graph.addUndirectedEdge(3,5);
		graph.addUndirectedEdge(7,6);
		graph.addUndirectedEdge(5,6);

		System.out.println("BFS path from source : V"+source);
		graph.bfs(nodeList.get(source));
    }
}
