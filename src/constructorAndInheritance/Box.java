package constructorAndInheritance;

public class Box {
	 double l;
	double h;
	 double w;
	
	public Box(double l, double h, double w) {
		System.out.println("Box class constructor");
		this.l = l;
		this.h = h;
		this.w = w;
	}
	
	public Box(Box old){
		this.h = old.h;
		this.l = old.l;
		this.w = old.w;
	}
	
	Box(){
		this.h = -1;
		this.l = -1;
		this.w = -1;
	}
	
	public Box(double side) {
		this.w = side;
		this.h = side;
		this.l = side;
	}
	
	public void information() {
		System.out.println("Running the box");
	}
	
}
