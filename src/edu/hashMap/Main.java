package edu.hashMap;

import java.util.HashSet;
import java.util.TreeMap;






public class Main {
	public static void main(String[] args) {
		
		Main mn = new Main();
		System.out.println(mn.hashCode());
		String str = "Sagar";
		System.out.println(str.hashCode());
		
		
		TreeMap<String, Integer> map =  new TreeMap<>();
		
		map.put("Sagar",98012);
		map.put("Ashis",28273);
		
		System.out.println(map.containsKey("Sunar"));
		
		System.out.println(map.getOrDefault("Sagar", 80));
		
		System.out.println(map);
		HashSet<Integer> set = new HashSet<>();
		
		
		MapUsingHash ma = new MapUsingHash();
		ma.put("Sagar","Sunar");
		ma.put("Sunar","Sagar");
		
		System.out.println(ma.get("Sagar"));
	}
}

