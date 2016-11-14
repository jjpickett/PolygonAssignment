package shapes;

public class Cylinder extends Polygon {

	private double radius;
	
	public Cylinder() {}
	
	public Cylinder(Double height, Double radius) {
		this.height = height;
		this.radius = radius;
	}
	
	@Override
	public double getBaseArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double getBaseVolume() {
		return getBaseArea() * height;
	}

}
