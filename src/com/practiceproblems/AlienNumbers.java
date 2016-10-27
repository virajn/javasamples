package com.practiceproblems;

import java.io.BufferedReader;
import java.io.FileReader;

public class AlienNumbers {
	
	public static void main(String args[])
	{
		try
		{
			String sCurrentLine;
			BufferedReader bufferedReader = new BufferedReader(new FileReader("inputfiles/A-small-practice.in"));
			
			int countInput = Integer.parseInt(bufferedReader.readLine());
			int itr = 0;
			while (itr < 1 && (sCurrentLine = bufferedReader.readLine()) != null) {	
				String [] newStrArray = sCurrentLine.split(" ");
				String newNumber = convertNumber(newStrArray[0], newStrArray[1], newStrArray[2]);
				System.out.println(newStrArray[0]+ " "+newStrArray[1]+ " "+newStrArray[2]+ " "+newNumber);
			}
			bufferedReader.close();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		finally
		{
			
		}
	}
	
	public static String convertNumber(String number,String existingFormat,String newformat)
	{
		String newNumber;
		int decimal = Integer.valueOf(number, existingFormat.length());
		newNumber= decimalToNewBase(decimal, newformat.length());
		char[] replaceFormat = newformat.toCharArray();
		
		char itr = 0;
		
		while(itr<replaceFormat.length)
		{
			newNumber.replace(itr, replaceFormat[itr]);
			itr++;
		}
		
		return newNumber;
	}
	
	public static String decimalToNewBase(int decimal,int newformatBase)
	{
		String newFormatNum=Integer.toString(decimal, newformatBase);
		return newFormatNum;
		
	}

}
