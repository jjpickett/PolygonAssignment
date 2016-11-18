package shapes;

import utilities.PolygonADT;

/**
 * @see PolygonADT
 */
public class SquarePrism extends PolygonADT {

	private double edgeLength;

	/**
	 * Main constructor for SquarePrism
	 * 
	 * @param height
	 *            is a double for the height
	 * @param edgeLength
	 *            is a double for the edge length
	 */
	public SquarePrism(Double height, Double edgeLength) {
		this.height = height;
		this.edgeLength = edgeLength;
	}

	/**
	 * @see PolygonADT
	 */
	@Override
	public double getBaseArea() {
		return Math.pow(edgeLength, 2);
	}

	/**
	 * @see PolygonADT
	 */
	@Override
	public double getBaseVolume() {
		return getBaseArea() * height;
	}

}
