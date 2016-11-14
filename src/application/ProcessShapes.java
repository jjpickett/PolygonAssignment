package application;

import java.io.*;

import java.lang.reflect.*;


import shapes.Polygon;
import sorting.Sorting;

public class ProcessShapes
{

	public static void main(String[] args)
	{
		BufferedReader reader;
		try
		{
			reader = new BufferedReader(new FileReader("res/polyfor3.txt"));
			String line = reader.readLine();	
			String []tokens = line.split(" ");
			
			System.out.println(tokens[0]);
			int add = 0;
			Polygon [] polygons = new Polygon[Integer.parseInt(tokens[0])];
			for(int i=1; i<tokens.length - 1; i++)
			{
				String className = "shapes."+ tokens[i++];
				
				Class reflectClass = Class.forName(className);
								
				Constructor constructor = reflectClass.getConstructor(Double.class, Double.class);
				Object []argsList = {new Double(tokens[i++]), new Double(tokens[i])};
				Object o = constructor.newInstance(argsList);
				Polygon temp = (Polygon)o;
				
				temp.setCompareType('v');
				
				polygons[add++] = temp;
				//System.out.println(className + " " + polygons[add - 1].getBaseVolume());
			}
			Sorting sort = new Sorting(polygons);
			long startTime = System.nanoTime();
			polygons = sort.mergeSort();
			long endTime = System.nanoTime();
			
//			for(int i = 0; i < polygons.length; i++)
//				System.out.println(polygons[i].getBaseVolume());

			System.out.println("Done in " + ((endTime - startTime) / 1E9) +" seconds");
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
