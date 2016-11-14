package shapes;

public class Pyramid extends Polygon {
	
	private double edgeLength;

	public Pyramid() {}
	
	public Pyramid(Double height, Double edgeLength) {
		this.height = height;
		this.edgeLength = edgeLength;
	}

	@Override
	public double getBaseArea() {
		return Math.pow(edgeLength, 2);
	}

	@Override
	public double getBaseVolume() {
		return 1/3 * (getBaseArea() * height);
	}

}
