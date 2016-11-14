package shapes;

public class PentagonalPrism extends Polygon {
	
	private double edgeLength;

	public PentagonalPrism() {}
	
	public PentagonalPrism(Double height, Double edgeLength) {
		this.height = height;
		this.edgeLength = edgeLength;
	}

	@Override
	public double getBaseArea() {
		return (5 * Math.pow(edgeLength, 2) * Math.tan(54))/4;
	}

	@Override
	public double getBaseVolume() {
		return getBaseArea() + height;
	}

}
