package shapes;

import utilities.PolygonADT;

/**
 * @see PolygonADT
 */
public class PentagonalPrism extends PolygonADT {

	private double edgeLength;

	/**
	 * Main constructor for PentagonalPrism
	 * 
	 * @param height
	 *            is a double for the height
	 * @param edgeLength
	 *            is a double for the edge length
	 */
	public PentagonalPrism(Double height, Double edgeLength) {
		this.height = height;
		this.edgeLength = edgeLength;
	}

	/**
	 * @see PolygonADT#getBaseArea()
	 */
	@Override
	public double getBaseArea() {
		return (5 * Math.pow(edgeLength, 2) * Math.tan(Math.toRadians(54))) / 4;
	}

	/**
	 * @see PolygonADT#getBaseVolume()
	 */
	@Override
	public double getBaseVolume() {
		return getBaseArea() + height;
	}

}
