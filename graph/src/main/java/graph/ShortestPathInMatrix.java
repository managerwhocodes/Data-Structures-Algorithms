package graph;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Node{
    int x;
    int y;
    int distanceFromSource;

    Node(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.distanceFromSource = dis;
    }
}

class ShortestPathInMatrix{

    private int adjMatrix [][];
    private boolean visited[][];
    
    private int[] row = {-1,1,0,0};
    private int[] col = {0,0,-1,1};

    public ShortestPathInMatrix(int matrix[][]){
        this.adjMatrix = matrix;
        this.visited = new boolean[matrix.length][matrix.length];
    }

    private int path(Node source, Node destination){
    	
    	if(adjMatrix.length==0)
    		return -1;
    	
    	if(source.x >= adjMatrix.length || destination.x >= adjMatrix.length || 
    			source.y >= adjMatrix[0].length || destination.y >= adjMatrix[0].length)
    		return -1;
    	// Check if source and destination are valid
        if(adjMatrix[source.x][source.y] !=1 || adjMatrix[destination.x][destination.y] !=1)
            return -1;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(source);

        while(!queue.isEmpty()){

            Node currentNode = queue.poll();
            visited[currentNode.x][currentNode.y] = true;

            if(currentNode.x == destination.x && currentNode.y == destination.y)
                return currentNode.distanceFromSource;

            List<Node> neighbourList = getNeighbours(currentNode, adjMatrix, visited);
            queue.addAll(neighbourList);

        }
        return -1;
    }

    private List<Node> getNeighbours(Node node, int [][] adjMatrix, boolean [][] visited) {
   
		List<Node> list = new ArrayList<Node>();
		
		for(int i=0;i<row.length;i++) {
			
			int x = node.x + row[i];
			int y = node.y + col[i];
						
			if((x >= 0) && (x < adjMatrix.length) && (y >= 0) && (y < adjMatrix[0].length) 
					&& (adjMatrix[x][y] == 1 && !visited[x][y])) {
				Node neighbour = new Node(x, y, node.distanceFromSource+1);	
				list.add(neighbour);
				visited[x][y] = true;	
			}
		}

		/*
		if((node.x-1 >= 0 && node.x-1 < adjMatrix.length) && adjMatrix[node.x-1][node.y] == 1
				&& !visited[node.x-1][node.y]) {
            Node neighbour = new Node(node.x-1, node.y, node.distanceFromSource+1);		
			list.add(neighbour);
			visited[node.x-1][node.y] = true;
		}
        if((node.x+1 >= 0 && node.x+1 < adjMatrix.length) && adjMatrix[node.x+1][node.y] == 1
        		&& !visited[node.x+1][node.y]) {
            Node neighbour = new Node(node.x+1, node.y, node.distanceFromSource+1);
			list.add(neighbour);
			visited[node.x+1][node.y] = true;
            
		}
        if((node.y-1 >= 0 && node.y-1 < adjMatrix[0].length) && adjMatrix[node.x][node.y-1] == 1
        		&& !visited[node.x][node.y-1]) {
            Node neighbour = new Node(node.x, node.y-1, node.distanceFromSource+1);
			list.add(neighbour);
			visited[node.x][node.y-1] = true;         
		}
        if((node.y+1 >= 0 && node.y+1 < adjMatrix[0].length) && adjMatrix[node.x][node.y+1] == 1
        		&& !visited[node.x][node.y+1]) {
            Node neighbour = new Node(node.x, node.y+1, node.distanceFromSource+1);
			list.add(neighbour);
			visited[node.x][node.y+1] = true;
		}
		*/
		
		return list;
	}


    public static void main(String args[]){
        int matrix[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
        
        int matrixTwo[][] = {{ 1, 0, 1, 1},
                			 { 1, 0, 1, 0},
                			 { 1, 1, 1, 0},
                			 { 0, 0, 1, 0},
                			 { 1, 1, 1, 1}};


        ShortestPathInMatrix graph = new ShortestPathInMatrix(matrix);
        ShortestPathInMatrix graphTwo = new ShortestPathInMatrix(matrixTwo);

        // Change the input from here
        Node source = new Node(0,0,0);
        Node destination = new Node(8,0,0);
        
        Node sourceTwo = new Node(0,0,0);
        Node destinationTwo = new Node(4,0,0);
        

        int distance = graph.path(source, destination);
        int distanceTwo = graphTwo.path(sourceTwo, destinationTwo);

        if (distance > 0)
            System.out.println("Shortest Path = " + distance);
        else
            System.out.println("Path doesn't exist");
        
        if (distanceTwo > 0)
            System.out.println("Shortest Path = " + distanceTwo);
        else
            System.out.println("Path doesn't exist");

    }
}
