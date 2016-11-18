package shapes;

import utilities.PolygonADT;

/**
 * @see PolygonADT
 */
public class TriangularPrism extends PolygonADT {

	private double edgeLength;

	/**
	 * Main constructor for TriangularPrism
	 * 
	 * @param height
	 *            is a double for the height
	 * @param edgeLength
	 *            is a double for the edge length
	 */
	public TriangularPrism(Double height, Double edgeLength) {
		this.height = height;
		this.edgeLength = edgeLength;
	}

	/**
	 * @see PolygonADT#getBaseArea()
	 */
	@Override
	public double getBaseArea() {
		return (Math.pow(edgeLength, 2) * (Math.sqrt(3))) / 4;
	}

	/**
	 * @see PolygonADT#getBaseVolume()
	 */
	@Override
	public double getBaseVolume() {
		return getBaseArea() * height;
	}

}
