package constructorAndInheritance;

public class BoxWeight extends Box{
	double weight;
	
	public BoxWeight() {
		this.weight = -1;
	}
	
	public BoxWeight(double l, double h, double w, double weight) {
		super(l, h, w); //calls the parent class constructor
		
		this.weight = weight;
	}
	
	public BoxWeight(double side, double weight) {
		super(side);
	}
	
	public BoxWeight(BoxWeight other) {
		super(other);
		weight = other.weight;
	}
}


/*
 * Single Inheritance - one class extends to another class
 * Multi-level inheritance - one class extends to another class and again another class extends to it.
 * Multiple inheritance - one class extending more than one classes
 * Hierarchial inheritance - One class is inherited  by many classes
 * Hybrid inheritance -  combination of single and multiple inheritance 
 */
