package edu.Patterns;

public class Pattern1 {
	public static void main(String[] args) {
//		pattern1(5);
		pattern22(6);
	}
	
	private static void pattern22(int n) {
		for(int row=1;row<=n;row++) {
			for(int col=n-row+1;col>0;col--) {
				System.out.print(row+" ");
			}
			System.out.println();
		}
	}
	
	private static void pattern21(int n) {
		for(int row=1;row<n;row++) {
			for(int space=n-row+1;space>=0;space--) {
				System.out.print(' ');
			}
			for(int col=-row;col<=row;col++) {
				if(col != 0 && col != -1) {
					System.out.print(Math.abs(col));
				}
			}
			System.out.println();
		}
		for(int row=n-2;row>0;row--) {
			for(int space=1;space<=n-row+2;space++) {
				System.out.print(' ');
			}
			for(int col=-row;col<=row;col++) {
				if(col != 0 && col != -1) {
					System.out.print(Math.abs(col));
				}
			}
			System.out.println();
		}
	}
	
	private static void pattern20(int n) {
		int or = n+1;
		n = 2*n;
		for(int row=1;row<n;row++) {
			for(int col=1;col<n;col++) {
					int atEveryIndex = or - Math.min(Math.min(row, col), Math.min(n-row, n-col));
					System.out.print(atEveryIndex+" ");
			}
			System.out.println();
		}
	}
	
	private static void pattern19(int n) {
		for(int row=1;row<=n;row++) {
			for(int space=2*(n-row+1)-2;space>=0;space--) {
				System.out.print(' ');
			}
			for(int col=-row;col<=row;col++) {
				if(col != 0 && col != -1) {
					System.out.print(Math.abs(col)+" ");
				}
			}
			System.out.println();
		}
	}
	
	private static void pattern18(int n) {
		for(int row=1;row<=n;row++) {
			for(int space=2*(n-row+1)-2;space>=0;space--) {
				System.out.print(' ');
			}
			for(int col=-row;col<=row;col++) {
				if(col != 0 && col != -1) {
					System.out.print(Math.abs(col)+" ");
				}
			}
			System.out.println();
		}
	}
	
	
	
	private static void pattern16(int n) {
		int times = -n;
		for(int row=1; row<=2*n;row++) {
			if(times==0) {
				times++;
			}
			int time = n+1-Math.abs(times);
			if(times != 1) {
				for(int space=n-Math.abs(time);space>0;space--) {
					System.out.print(" ");
				}
				System.out.print("*");
				for(int space=2;space<2*Math.abs(time)-1;space++) {
					System.out.print(" ");
				}
				if(Math.abs(time)>1) {
					System.out.print("*");
				}
				System.out.println();
			}
				
			times++;
			
		}
		System.out.println();
	}
	
	private static void pattern1(int n) {
		for(int row=0; row<n;row++) {
			for(int col=0;col<=row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern2(int n) {
		for(int row=0; row<n;row++) {
			for(int col=0;col<n;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern3(int n) {
		for(int row=n; row>0;row--) {
			for(int col=0;col<row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern4(int n) {
		for(int row=1; row<=n;row++) {
			for(int col=1;col<=row;col++) {
				System.out.print(col+"  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern5(int n) {
		int times = -n;
		for(int row = 2*n; row>0; row--) {
			for(int col=0;col<n-Math.abs(times);col++) {
				System.out.print("*");
			}
			times ++;
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern6(int n) {
		for(int row=0; row<n;row++) {
			for(int space=n-1-row;space>0;space--) {
				System.out.print(" ");
			}
			for(int col=0;col<=row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern7(int n) {
		for(int row=n; row>0;row--) {
			for(int space=0;space<n-row;space++) {
				System.out.print(" ");
			}
			for(int col=0;col<row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern8(int n) {
		for(int row=1; row<=n;row++) {
			for(int space=n-row;space>0;space--) {
				System.out.print(" ");
			}
			for(int col=1;col<=(2*row-1);col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern9(int n) {
		for(int row=n; row>=1;row--) {
			for(int space=n-row;space>0;space--) {
				System.out.print(" ");
			}
			for(int col=1;col<=(2*row-1);col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern10(int n) {
		for(int row=1; row<=n;row++) {
			for(int space=n-row;space>0;space--) {
				System.out.print(" ");
			}
			for(int col=1;col<=row;col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern11(int n) {
		for(int row=n; row>=0;row--) {
			for(int space=n-row;space>0;space--) {
				System.out.print(" ");
			}
			for(int col=1;col<=row;col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * @param n
	 */
	private static void pattern12(int n) {
		int times = -n;
		for(int row=2*n; row>0;row--) {
			if(times == 0) times++;
			for(int space=n-Math.abs(times);space>0;space--) {
				System.out.print(" ");
			}
			for(int col=1;col<=Math.abs(times);col++) {
				System.out.print("* ");
			}
			times++;
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern13(int n) {
		for(int row=1; row<=n;row++) {
			if(row==n) {
				for(int i=1;i<=2*row-1;i++) {
					System.out.print("*");
				}
			}else {
				for(int space=n-row;space>0;space--) {
					System.out.print(" ");
				}
				System.out.print("*");
				for(int space=2;space<2*row-1;space++) {
					System.out.print(" ");
				}
				if(row>1) {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern14(int n) {
		for(int row=n; row>0;row--) {
			if(row==n) {
				for(int i=1;i<=2*row-1;i++) {
					System.out.print("*");
				}
			}
			else {
				for(int space=n-row;space>0;space--) {
					System.out.print(" ");
				}
				System.out.print("*");
				for(int space=2;space<2*row-1;space++) {
					System.out.print(" ");
				}
				if(row>1) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void pattern15(int n) {
		int times = -n;
		for(int row=0; row<2*n;row++) {
			if(times==0) {
				times++;
			}
				for(int space=n-Math.abs(times);space>0;space--) {
					System.out.print(" ");
				}
				System.out.print("*");
				for(int space=2;space<2*Math.abs(times)-1;space++) {
					System.out.print(" ");
				}
				if(Math.abs(times)>1) {
					System.out.print("*");
				}
			
			times++;
			System.out.println();
		}
		System.out.println();
	}
	
	
}
