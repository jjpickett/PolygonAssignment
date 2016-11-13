package model;

public abstract class Polygon implements Comparable<Polygon>{
	
	protected double height;
	private char compareType;
	
	public double getHeight(){
		return height;
	}
	
	public abstract double getVolume();
	
	public abstract double getBaseArea();
	
	public int compareTo(Polygon other){
		switch(compareType){
		case 'h':
		case 'H':
			if(this.getHeight() < other.getHeight()) return - 1;
			if(this.getHeight() > other.getHeight()) return 1;
			return 0;
		case 'a':
		case 'A':
			if(this.getBaseArea() < other.getBaseArea()) return - 1;
			if(this.getBaseArea() > other.getBaseArea()) return 1;
			return 0;
		default:
				return - 5;
		}
	}

}
