package shapes;

import utilities.PolygonADT;

/**
 * @see PolygonADT
 */
public class OctagonalPrism extends PolygonADT {

	private double edgeLength;

	/**
	 * Main constructor for OctagonalPrism
	 * 
	 * @param height
	 *            is a double for the height
	 * @param edgeLength
	 *            is a double for the edge length
	 */
	public OctagonalPrism(Double height, Double edgeLength) {
		this.height = height;
		this.edgeLength = edgeLength;
	}

	/**
	 * @see PolygonADT#getBaseArea()
	 */
	@Override
	public double getBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(edgeLength, 2);
	}

	/**
	 * @see PolygonADT#getBaseVolume()
	 */
	@Override
	public double getBaseVolume() {
		return getBaseArea() * height;
	}

}
