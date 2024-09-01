package stack;

import java.util.Iterator;

public class DynamicStack extends CustomedStack{
	
	public DynamicStack() {
		super(); 
	}
	
	public DynamicStack(int size) {
		super(size);
	}
	
	@Override
	public boolean push(int item) {
		
		// this takes care of being full
		if(this.isFull()) {
			// double the size
			int[] temp = new int[data.length*2];
			
			// copy all the previous items in new data
			for (int i = 0; i < data.length; i++) {
				temp[i]=data[i];
			}
			data = temp;
		}
		
		return super.push(item);
	}
}
