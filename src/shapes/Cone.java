package shapes;

public class Cone extends Polygon {

	private double radius;
	
	public Cone() {}
	public Cone(Double height, Double radius) {
		this.height = height;
		this.radius = radius;
	}

	@Override
	public double getBaseArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double getBaseVolume() {
		return (getBaseArea() * height) * 1/3;
	}

}
