package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// Problem : Given a binary matrix where 0 represents water and 1 represents land, 
//			 count the number of islands in it. A island is formed by connected one’s.

// Approach : The idea is to start BFS from each unprocessed node and increment the island count. 
//			  Each BFS traversal will mark all cells which make one island as processed. 
//			  So, the problem reduces to finding number of BFS calls.

class IslandsInMatrix{

	// For valid moves
	private final int[] row = { -1, -1, -1, 0, 1, 0, 1, 1 };
	private final int[] col = { -1, 1, 0, -1, -1, 1, 0, 1 };

	// Check if the move is allowed
	protected boolean canMove(int[][] mat, int x, int y, boolean[][] visited) {
		return (x >= 0) && (x < visited.length) &&
				(y >= 0) && (y < visited[0].length) &&
				(mat[x][y] == 1 && !visited[x][y]);
	}

	// BFS
    protected void findIsland(int[][] mat, boolean[][] visited, int i, int j) {

    	Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(i, j));

		visited[i][j] = true;

		/*
		while (!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			queue.poll();

			for (int k = 0; k < 8; k++) {
				if (canMove(mat, x + row[k], y + col[k], visited)) {
					visited[x + row[k]][y + col[k]] = true;
					queue.add(new Pair(x + row[k], y + col[k]));
				}
			}
		}
		*/
		
        while(!queue.isEmpty()){

            Pair pair = queue.poll();
            int x = pair.x ;
            int y = pair.y;
            visited[x][y] = true;

            List<Pair> neighbourList = getNeighbours(pair, mat, visited);
            queue.addAll(neighbourList);

        }
	}
    
    // Get all valid neighbours
    private List<Pair> getNeighbours(Pair pair, int [][] mat, boolean [][] visited) {
    	   
		List<Pair> list = new ArrayList<Pair>();
		
		for(int i=0;i<row.length;i++) {
			
			int x = pair.x + row[i];
			int y = pair.y + col[i];
						
			if((x >= 0) && (x < mat.length) && (y >= 0) && (y < mat[0].length) 
					&& (mat[x][y] == 1 && !visited[x][y])) {
				Pair neighbour = new Pair(x, y);	
				list.add(neighbour);
				visited[x][y] = true;	
			}
		}
		return list;
    }

    public static void main(String args[]){
    	
    	IslandsInMatrix matrix = new IslandsInMatrix();
    	
    	int[][] mat=
    		{
    			{ 1, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
    			{ 0, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
    			{ 1, 1, 1, 1, 0, 0, 1, 0, 0, 0 },
    			{ 1, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
    			{ 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
    			{ 0, 1, 0, 1, 0, 0, 1, 1, 1, 1 },
    			{ 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
    			{ 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
    			{ 1, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
    			{ 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
    			{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
    			{ 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 }
    		};

		int M = mat.length;
		int N = mat[0].length;

		boolean[][] visited = new boolean[M][N];

		int island = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (mat[i][j] == 1 && !visited[i][j]) {
					matrix.findIsland(mat, visited, i, j);
					island++;
				}
			}
		}
		System.out.print("Number of islands are " + island);
    }
}
