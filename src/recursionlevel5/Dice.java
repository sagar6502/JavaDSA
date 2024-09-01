package recursionlevel5;

import java.util.ArrayList;
import java.util.Arrays;

public class Dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target=7;
		int noOfDice = 2;
		int face=6;
//		diceGoal("",target,noOfDice);
		System.out.println(diceGoalRet("",target,noOfDice,face).size());
	}
	
	private static void diceGoal(String p, int target,int k) {
		if(target==0) {
			System.out.println(p);
			if(p.length()==k) {
				
			}
			return;
		}
		
		for(int i=1;i<=6 && i <=target;i++) {
			diceGoal(p+i,target-i,k-i);
		}
	}
	
	private static ArrayList<String> diceGoalRet(String p, int target,int k, int face) {
		if(target==0) {
			if(p.length()==k) {
				return new ArrayList<String>(Arrays.asList(p));
			}
		}
		ArrayList<String> ans1 = new ArrayList<String>();
		for(int i=1;i<=face && i <=target;i++) {
				ans1.addAll(diceGoalRet(p+i,target-i,k,face));				
		}
		return ans1;
	}

}
