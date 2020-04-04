package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode>{

    private String name;
    private int distance;
    private ArrayList<WeightedNode> neighbours = new ArrayList<WeightedNode>();
    private HashMap<WeightedNode, Integer> weightMap = new HashMap<WeightedNode, Integer>();
    private WeightedNode parent;

    public WeightedNode(String name){
        this.name = name;
        this.distance = Integer.MAX_VALUE;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getDistance(){
        return distance;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    public ArrayList<WeightedNode> getNeighbours(){
        return neighbours;
    }

    public void setNeighbours(ArrayList<WeightedNode> neighbours){
        this.neighbours = neighbours;
    }

    public HashMap<WeightedNode, Integer> getWeightMap(){
        return weightMap;
    }

    public void setWeightMap(HashMap<WeightedNode, Integer> weightMap){
        this.weightMap = weightMap;
    }

    public WeightedNode getParent(){
        return parent;
    }

    public void setParent(WeightedNode parent){
        this.parent = parent;
    }

    @Override
    public String toString() {
        return name;
    }

	public int compareTo(WeightedNode w) {
		return this.distance - w.distance;
	}
}
