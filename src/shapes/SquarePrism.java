package shapes;

public class SquarePrism extends Polygon {

	private double edgeLength;
	
	public SquarePrism() {}
	
	public SquarePrism(Double height, Double edgeLength) {
		this.height = height;
		this.edgeLength = edgeLength;
	}

	@Override
	public double getBaseArea() {
		return Math.pow(edgeLength, 2);
	}

	@Override
	public double getBaseVolume() {
		return getBaseArea() * height;
	}

}