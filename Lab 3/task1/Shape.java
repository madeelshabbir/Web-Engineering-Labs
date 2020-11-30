abstract class Shape{
	private double area;
	private double volume;
	protected double getArea(){
		return this.area;
	}
	protected double getVolume(){
		return this.volume;
	}
	protected void setArea(double d){
		this.area = d;
	}
	protected void setVolume(double d){
		this.volume = d;
	}
	public abstract double calculateArea();
	public abstract double calculateVolume();
	public String toString(){
		return "Area = " + this.area + "\n" + "Volume = " + this.volume;
	}
}
class Square extends Shape{
	private double length;
	private double width;
	private double height;
	public Square(){
		this(0.0, 0.0, 0.0);
	}
	public Square(double d1, double d2, double d3){
		this.length = d1;
		this.width = d2;
		this.height = d3;
	}
	public Square(Square s){
		this(s.length, s.width, s.height);
	}
	public double calculateArea(){
		setArea(this.length*this.width);
		return getArea();
	}
	public double calculateVolume(){
		setVolume(this.length*this.width*this.height);
		return getVolume();
	}
}
class Sphere extends Shape{
	private double radius;
	private final double Pi = 3.14;
	public Sphere(){
		this(0.0);
	}
	public Sphere(double d){
		this.radius = d;
	}
	public Sphere(Sphere s){
		this(s.radius);
	}
	public double calculateArea(){
		setArea(this.Pi*this.radius*this.radius);
		return getArea();
	}
	public double calculateVolume(){
		setVolume(this.Pi*this.radius*this.radius*this.radius);
		return getVolume();
	}
}