package application;

import java.io.*;

import java.lang.reflect.*;

import sorting.Sorting;
import utilities.PolygonADT;

/**
 * This is the main class that will run the application.
 * 
 * @author Jordan
 *
 */
public class ProcessShapes {
	/**
	 * This is the main constructor that is passed in the arguments from the
	 * user. The program will only run if there are 3 arguments given that have
	 * at least one filename, one sorting type and one comparison type.
	 * 
	 * Once completed it will retrieve the list from the file and then sort the
	 * list accordingly.
	 * 
	 * @param args
	 *            are the arguments being passed in. These will contain the name
	 *            of the song
	 */
	public static void main(String[] args) {
		String filename = null;
		char compareType = ' ';
		char sortType = ' ';

		int f = 0;
		int t = 0;
		int s = 0;

		if (args.length < 3) {
			System.out.println("Not enough arguements to compile");
			System.exit(0);
		} else if (args.length > 3) {
			System.out.println("Too many arguements to compile.");
			System.exit(0);
		}

		for (String flags : args) {
			if (flags.substring(0, 2).trim().equalsIgnoreCase("–f") || (flags.substring(0, 2).trim().equalsIgnoreCase("-f"))) {
				filename = flags.substring(2, flags.length());
				f++;
			} else if (flags.substring(0, 2).trim().equalsIgnoreCase("–t") || (flags.substring(0, 2).trim().equalsIgnoreCase("-t"))) {
				compareType = flags.toLowerCase().charAt(2);
				t++;
			} else if (flags.substring(0, 2).trim().equalsIgnoreCase("–s") || (flags.substring(0, 2).trim().equalsIgnoreCase("-s"))) {
				sortType = flags.toLowerCase().charAt(2);
				s++;
			}
		}
		if (f == 1 && s == 1 && t == 1) {
			sortList(processList(filename, compareType), sortType, compareType);
		} else {
			System.out
					.println("Incorrect amount of flags.\n" + "Please ensure there is only one of each: -f -t and -s.");
			System.exit(0);
		}

	}

	/**
	 * This method will process the list that was given by the user. The method
	 * will go through each of the Polygons and add it to an array. It will also
	 * set the comparison type of each Polygon.
	 * 
	 * @param filename
	 *            is a String of the file name
	 * @param compareType
	 *            is a character that represents the comparison type being used
	 * @return this will return a PolygonADT[] list that contains the unsorted
	 *         PolygonADT objects.
	 */
	public static PolygonADT[] processList(String filename, char compareType) {
		System.out
		.println("Proccessing. Please be patient...");
		BufferedReader reader;
		PolygonADT[] polygons = null;
		try {
			reader = new BufferedReader(new FileReader("res/" + filename));
			String line = reader.readLine();
			String[] tokens = line.split(" ");

			int add = 0;
			polygons = new PolygonADT[Integer.parseInt(tokens[0])];
			for (int i = 1; i < tokens.length - 1; i++) {
				String className = "shapes." + tokens[i++];

				Class reflectClass = Class.forName(className);

				Constructor constructor = reflectClass.getConstructor(Double.class, Double.class);
				Object[] argsList = { new Double(tokens[i++]), new Double(tokens[i]) };
				Object o = constructor.newInstance(argsList);
				PolygonADT temp = (PolygonADT) o;

				temp.setCompareType(compareType);

				polygons[add++] = temp;			
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return polygons;
	}

	/**
	 * This method will take the unsorted PolygonADT[] list and then sort them
	 * based on the sorting type. Once the sort has been completed, the results
	 * will be printed to the screen.
	 * 
	 * The results will include the 1st shape of the polygon and the size based
	 * on the comparison type, every 1000th shape of the polygon and the size
	 * based on the comparison type, and the last shape of the polygon and the
	 * size based on the comparison type.
	 * 
	 * The final results will also show what it was sorted by, what the sort
	 * type was the lists size and how long it took to complete.
	 * 
	 * @param polygons is the list of PolygonADT[] that will be sorted
	 * @param sortType is the sort type that is being used
	 * @param compareType is the comparison type that is being used
	 */
	public static void sortList(PolygonADT[] polygons, char sortType, char compareType) {
		System.out.print("Sorting. This may take a while...");
		Sorting sort = new Sorting(polygons);
		String s = "";
		long startTime = 0;
		long endTime = 0;
			System.out.print(".");
		switch (sortType) {
		case 'b':
			startTime = System.nanoTime();
			polygons = sort.bubbleSort();
			endTime = System.nanoTime();
			s = "Bubble Sort";
			break;
		case 's':
			startTime = System.nanoTime();
			polygons = sort.selectionSort();
			endTime = System.nanoTime();
			s = "Selection Sort";
			break;
		case 'i':
			startTime = System.nanoTime();
			polygons = sort.insertionSort();
			endTime = System.nanoTime();
			s = "Insertion Sort";
			break;
		case 'm':
			startTime = System.nanoTime();
			polygons = sort.mergeSort();
			endTime = System.nanoTime();
			s = "Merge Sort";
			break;
		case 'q':
			startTime = System.nanoTime();
			polygons = sort.quickSort();
			endTime = System.nanoTime();
			s = "Quick Sort";
			break;
		case 'z':
			startTime = System.nanoTime();
			polygons = sort.martiniSort();
			endTime = System.nanoTime();
			s = "Martini Sort";
			break;
		default:
			System.out.println("Sort Type: " + sortType + " is invalid.\n"
					+ "Please select a valid sort type such as b, s, i, m, q or z.");
			System.exit(0);
			break;

		}
		switch (compareType) {
		case 'h':
			for (int i = 0; i < polygons.length; i += 1000)
				System.out.println("List Location: " + (i) + "\nShape: "
						+ polygons[i].getClass().toString().replace("class shapes.", "") + "\nHeight: "
						+ polygons[i].getHeight() + "\n---------------------------------------------------------");
			System.out.println("List Location: " + (polygons.length) + "\nShape: "
					+ polygons[polygons.length - 1].getClass().toString().replace("class shapes.", "") + "\nHeight: "
					+ polygons[polygons.length - 1].getHeight()
					+ "\n=========================================================");
			System.out.println("FINAL RESULTS\n" + "Sort by: Height");
			break;
		case 'a':
			for (int i = 0; i < polygons.length; i += 1000)
				System.out.println("List Location: " + (i) + "\nShape: "
						+ polygons[i].getClass().toString().replace("class shapes.", "") + "\nArea: "
						+ polygons[i].getBaseArea() + "\n---------------------------------------------------------");
			System.out.println("List Location: " + (polygons.length) + "\nShape: "
					+ polygons[polygons.length - 1].getClass().toString().replace("class shapes.", "") + "\nArea: "
					+ polygons[polygons.length - 1].getBaseArea()
					+ "\n=========================================================");
			System.out.println("FINAL RESULTS\n" + "Sort by: Area");
			break;
		case 'v':
			for (int i = 0; i < polygons.length; i += 1000)
				System.out.println("List Location: " + (i) + "\nShape: "
						+ polygons[i].getClass().toString().replace("class shapes.", "") + "\nVolume: "
						+ polygons[i].getBaseVolume() + "\n---------------------------------------------------------");
			System.out.println("List Location: " + (polygons.length) + "\nShape: "
					+ polygons[polygons.length - 1].getClass().toString().replace("class shapes.", "") + "\nVolume: "
					+ polygons[polygons.length - 1].getBaseVolume()
					+ "\n=========================================================");
			System.out.println("FINAL RESULTS\n" + "Sort by: Volume");
			break;
		}

		System.out.println("Sort type: " + s + "\nList Size: " + polygons.length + "\nCompletion time: "
				+ (endTime - startTime) / 1E9 + " seconds.");

	}

}
