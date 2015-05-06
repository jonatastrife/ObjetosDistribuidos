package br.edu.qi.util;

public class Numeric {

	public static boolean isNumeric(String n)
	{
		try
		{
			float num=Float.parseFloat(n);
			return true;
		}catch(Exception e)
		{
			return false;
		}
			
		
	}
}
