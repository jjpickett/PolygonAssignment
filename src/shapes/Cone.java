package shapes;

import utilities.PolygonADT;

/**
 * @see PolygonADT
 */
public class Cone extends PolygonADT {

	private double radius;

	/**
	 * Main constructor for Cone
	 * 
	 * @param height
	 *            is a double for the height
	 * @param radius
	 *            is a double for the radius
	 */
	public Cone(Double height, Double radius) {
		this.height = height;
		this.radius = radius;
	}

	/**
	 * @see PolygonADT#getBaseArea()
	 */
	@Override
	public double getBaseArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	/**
	 * @see PolygonADT#getBaseVolume()
	 */
	@Override
	public double getBaseVolume() {
		return (getBaseArea() * height) * 1 / 3;
	}

}
