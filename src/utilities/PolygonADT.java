package utilities;

/**
 * This is the contract specification for a Polygon. A polygon needs at least
 * the height to calculate the rest of the dimensions.
 * 
 * A user is able to set the comparison type and is able to get its height, base
 * area and base volume.
 * 
 * The polygon can also compare itself to other polygons.
 * 
 * @author Jordan
 *
 */
public abstract class PolygonADT implements Comparable<PolygonADT> {

	protected double height;
	private char compareType;

	/**
	 * Accessor method that returns the height as a double.
	 * 
	 * Preconditions: A valid PolygonADT exists
	 * 
	 * Postconditions: A double value representing the height is returned
	 * 
	 * @return The height of the polygon
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Mutator method that sets the comparison type of the polygon
	 * 
	 * Preconditions: A valid PolygonADT exists
	 * 
	 * Postconditions: A char is added to the object to represent the comparison
	 * type
	 * 
	 * @param compareType
	 *            is a character used to compare the polygons based on height,
	 *            area or volume
	 */
	public void setCompareType(char compareType) {
		this.compareType = compareType;
	};

	/**
	 * Accessor method that returns the base area as a double
	 * 
	 * Preconditions: A valid PolygonADT exists
	 * 
	 * Postconditions: A double value representing the base area is returned
	 * 
	 * @return The base area of the polygon
	 */
	public abstract double getBaseArea();

	/**
	 * Accessor method that returns the base volume as a double.
	 * 
	 * Preconditions: A valid PolygonADT exists
	 * 
	 * Postconditions: A double value representing the base volume is returned
	 * 
	 * @return The base volume of the polygon
	 */
	public abstract double getBaseVolume();

	/**
	 * The compareTo method will be implemented by the Comparable interface it
	 * will adhere to the Comparable interface contract referenced in the Java
	 * API - java.lang.*; and will have the following signature. public int
	 * compareTo(PolygonADT other);.
	 */
	public int compareTo(PolygonADT other) {
		switch (compareType) {
		case 'h':
		case 'H':
			if (this.getHeight() < other.getHeight())
				return -1;
			if (this.getHeight() > other.getHeight())
				return 1;
			return 0;
		case 'a':
		case 'A':
			if (this.getBaseArea() < other.getBaseArea())
				return -1;
			if (this.getBaseArea() > other.getBaseArea())
				return 1;
			return 0;
		case 'v':
		case 'V':
			if (this.getBaseVolume() < other.getBaseVolume())
				return -1;
			if (this.getBaseVolume() > other.getBaseVolume())
				return 1;
			return 0;
		default:
			System.out.println("Compare Type: " + compareType + " is invalid.\n"
					+ "Please select a valid compare type such as h, v or a.");
			System.exit(0);
			return 0;
		}
	}

}
