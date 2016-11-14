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
			reader = new BufferedReader(new FileReader("res/shapes.txt"));
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
				System.out.println(className + " " + polygons[add - 1].getBaseVolume());
			}
			Sorting sort = new Sorting(polygons);
			polygons = sort.quickSort();
			
			for(int i = 0; i < polygons.length; i++){
				System.out.println(polygons[i].getClass() + " " + polygons[i].getBaseVolume() + " " + i);
			}
			System.out.println("done");
			
//			polygons = sort.bubbleSort(polygons);
//			System.out.println(polygons[2000].getClass() + " " + polygons[2000].getHeight());
//			polygons = sort.selectionSort(polygons);
//			System.out.println(polygons[2000].getClass() + " " + polygons[2000].getHeight());
			
//			long startTime = System.nanoTime();
//			polygons = sort.bubbleSort(polygons);
//			long endTime = System.nanoTime();
//			
//			System.out.println("Bubble Sort Time: " + (endTime - startTime));
//			System.out.println(polygons[0].getBaseVolume());
//			System.out.println(polygons[1000].getBaseVolume());
//			System.out.println(polygons[2000].getBaseVolume());
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
