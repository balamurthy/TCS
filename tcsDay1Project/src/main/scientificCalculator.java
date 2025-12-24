package main;

public class scientificCalculator extends Calculator {
	//overridden method
	public static int add(int i,int j)
	{
		System.out.println("Scifi says i will add it my way");
		return i +j;
				
	}
	
	public static double sin(double d)
	{
		return Math.sin(d);
	}
	
	public static double cos(int j) {
		return Math.cos(j);
	}
	

}
