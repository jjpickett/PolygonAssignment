package shapes;

import utilities.PolygonADT;

/**
 * @see PolygonADT
 */
public class Cylinder extends PolygonADT {

	private double radius;

	/**
	 * Main constructor for Cylinder
	 * 
	 * @param height
	 *            is a double for the height
	 * @param radius
	 *            is a double for the radius
	 */
	public Cylinder(Double height, Double radius) {
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
		return getBaseArea() * height;
	}

}
