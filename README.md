# JavaDSA

# What is class?
	Class is named group of properties(variables) and functions(method). It is abstract entity.
	
For example: in real life, a car is an object. The car has attributes, such as weight and color, and methods, such as drive and brake. A Class is like an object constructor, or a "blueprint" for creating objects.
	Now, BMW, Audi and Hyundai all have same property like weight and color but they vary accordingly. Hence, class can also be called as Template.

	
When a baby is born, s/he is the instance of Human class.

Therefore, java object are the instances of the class. In other world, class is abstract template while object is the physical existence of the value.


State , identity and behavior of the object.
  - State refers to value of an object.
  - Identity refers to where the value is stored .
  - Behavior means effect of the data type object.
 
A constructor in Java Programming is a block of code that initializes (constructs) the state and value during object creation. It is called every time an object with the help of a new () keyword is created. Even if you haven't specified any constructor in the code, the Java compiler calls a default constructor.


"this()" and "super()" must be the first statements in a constructor. "this()" can only be used to invoke other constructors within the same class, while "super()" invokes the parent class constructor. If neither "this()" nor "super()" is used, the default constructor of the parent class is implicitly called.
The final keyword in java is used to restrict the user. The java final keyword can be used in many context. Final can be:

variable
method
class
The final keyword can be applied with the variables, a final variable that have no value it is called blank final variable or uninitialized final variable. It can be initialized in the constructor only. The blank final variable can be static also which will be initialized in the static block only. 

If you make any variable as final, you cannot change the value of final variable(It will be constant).

Final variable has to be always initialized.

If you make any method as final, you cannot override it.

If you make any class as final, you cannot extend it.



What is garbage collection (GC)?
Garbage collection (GC) is a memory recovery feature built into programming languages such as C# and Java. A GC-enabled programming language includes one or more garbage collectors (GC engines) that automatically free up memory space that has been allocated to objects no longer needed by the program. The reclaimed memory space can then be used for future object allocations within that program.

Garbage collection ensures that a program does not exceed its memory quota or reach a point that it can no longer function. It also frees up developers from having to manually manage a program's memory, which, in turn, reduces the potential for memory-related bugs.