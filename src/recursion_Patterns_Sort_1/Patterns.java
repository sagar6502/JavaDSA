package recursion_Patterns_Sort_1;

public class Patterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Pattern1(5);
//		Pattern2(5,0);
//		Pattern3(5,0);
		Pattern4(5,0);
//		Pattern5(5);
//		exitFunction(5);
	}
	private static void Pattern1(int row) {
		 if(row==0) {
			 return;
		 }
		 for(int col=row;col>0;col--) {
			 System.out.print("* ");
		 }
		 System.out.println();
		 Pattern1(row-1);
	}
	
	private static void Pattern2(int row,int val) {
		 if(val==row) {
			 return;
		 }
		 for(int col=val;col>=0;col--) {
			 System.out.print("* ");
		 }
		 System.out.println();
		 Pattern2(row,val+1);
	}
	
	private static void Pattern3(int row,int col) {
		 if(row==0) {
			 return;
		 }
		 if(col < row) {
			 System.out.print("* ");
			 Pattern3(row,col+1);
		 }else {
			 System.out.println();
			 Pattern3(row-1,0);
		 }
	}
	
	private static void Pattern4(int row,int col) {
		if(row==0) {
			 return;
		 }
		 if(col < row) {
			 Pattern4(row,col+1);
			 System.out.print("* ");
		 }else {
			 Pattern4(row-1,0);
			 System.out.println();
		 }
	}
	
	private static void Pattern5(int n){
		for(int row=1;row<=n; row++) {
			for(int col=1;col<=row;col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	private static void exitFunction(int n) {
		if(n==0) {
			return;
		}
		
		exitFunction(n-1);
		System.out.println(n);
	}
}
