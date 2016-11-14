package shapes;

public class TriangularPrism extends Polygon {

	private double edgeLength;
	
	public TriangularPrism() {}
	
	public TriangularPrism(Double height, Double edgeLength) {
		this.height = height;
		this.edgeLength = edgeLength;
	}
	
	@Override
	public double getBaseArea() {
		return (Math.pow(edgeLength, 2) * Math.sqrt(3))/4;
	}

	@Override
	public double getBaseVolume() {
		return getBaseArea() * height;
	}

}
