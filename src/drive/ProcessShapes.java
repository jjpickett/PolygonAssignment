package application;

import java.io.*;

import java.lang.reflect.*;


import shapes.Polygon;

public class ProcessShapes
{

	public static void main(String[] args)
	{
		BufferedReader reader;
		try
		{
			reader = new BufferedReader(new FileReader("res/shapes"));
			int size = Integer.parseInt(reader.readLine());
			Polygon [] polygons = new Polygon[size];
			for(int i=0; i<size ; i++)
			{
				String line = reader.readLine();
	
				String []tokens = line.split(" ");
				String className = "shapes."+ tokens[0];
				
				Class reflectClass = Class.forName(className);
				
				Class []parameterTypes = {Double.TYPE, Double.TYPE, Character.TYPE};
				
				Constructor constructor = reflectClass.getConstructor(parameterTypes);
				Object []argsList = {new Double(tokens[1]), new Double(tokens[2]), new Character('V')};
				Object o = constructor.newInstance(argsList);
				polygons[i] = (Polygon)o;
				System.out.println(className + " " + polygons[i]);
			}
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
