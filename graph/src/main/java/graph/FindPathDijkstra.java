package graph;

import java.util.PriorityQueue;
import java.util.ArrayList;

public class FindPathDijkstra{

    private ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

    public FindPathDijkstra(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
    }

    private void findPath(WeightedNode node){
        PriorityQueue<WeightedNode> queue = new PriorityQueue<WeightedNode>();
        node.setDistance(0);
        queue.addAll(nodeList);
        while(!queue.isEmpty()){
            WeightedNode currentNode = queue.remove();
            for(WeightedNode neighbour : currentNode.getNeighbours()){
                if(queue.contains(neighbour)){
                    if(neighbour.getDistance() > (currentNode.getDistance() + currentNode.getWeightMap().get(neighbour))){
                        neighbour.setDistance(currentNode.getDistance() + currentNode.getWeightMap().get(neighbour));
                        neighbour.setParent(currentNode);
                        //queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

        for(WeightedNode nodeToPrint : nodeList){
            System.out.println("Shortest Path from Node "+node+" to "+nodeToPrint+" distance :  "+nodeToPrint.getDistance()+", Path : ");
            printPath(nodeToPrint);
            System.out.println();
        }
    }

    private void printPath(WeightedNode node){
        if(node.getParent() != null){
            printPath(node.getParent());
            System.out.print("->"+node);
        } else {
            System.out.print(node);
        }
    }

    private void addWeightedEdge(int i, int j, int d){
        WeightedNode source = nodeList.get(i);
        WeightedNode destination = nodeList.get(j);
        source.getNeighbours().add(destination);
        //destination.getNeighbours().add(source);
        source.getWeightMap().put(destination,d);
        //destination.getWeightMap().put(source, d);
    }

    public static void main(String[] args) {

        ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

        for(int i=0;i<7;i++){
            nodeList.add(new WeightedNode("V"+i));
        }

        FindPathDijkstra graph = new FindPathDijkstra(nodeList);

        graph.addWeightedEdge(0,2,6);
		graph.addWeightedEdge(0,3,3);
		graph.addWeightedEdge(1,0,3);
		graph.addWeightedEdge(2,3,2);
		graph.addWeightedEdge(3,2,1);
		graph.addWeightedEdge(3,1,1);
		graph.addWeightedEdge(4,1,4);
		graph.addWeightedEdge(4,3,2);
		graph.addWeightedEdge(5,6,2);

		graph.findPath(nodeList.get(4));

    }
}
