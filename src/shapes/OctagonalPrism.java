package shapes;

public class OctagonalPrism extends Polygon {

	private double edgeLength;
	
	public OctagonalPrism() {}
	
	public OctagonalPrism(Double height, Double edgeLength) {
		this.height = height;
		this.edgeLength = edgeLength;
	}

	@Override
	public double getBaseArea() {
		return 2*(1 + Math.sqrt(2))*Math.pow(edgeLength, 2) ;
	}

	@Override
	public double getBaseVolume() {
		return getBaseArea() * height;
	}

}
