package sorting;

import java.util.Random;

import utilities.PolygonADT;

/**
 * This is the Sorting class that contains the various sorts being used
 * throughout this application.
 * 
 * @author Jordan
 *
 */
public class Sorting {
	private PolygonADT[] list;

	/**
	 * Main Empty constructor
	 */
	public Sorting() {}

	/**
	 * Main constructor for creating the Sorting class.
	 * 
	 * @param list
	 *            is the unsorted PolygonADT[] being used that will be sorted.
	 */
	public Sorting(PolygonADT[] list) {
		this.list = list;
	}

	/**
	 * This method is the bubble sort. It goes through each of the PolygonADTs
	 * in the list and swaps if the object beside it is higher than itself.
	 * 
	 * @return this will return a PolygonADT[] list that contains the sorted
	 *         PolygonADT objects.
	 */
	public PolygonADT[] bubbleSort() {
		PolygonADT temp;

		boolean isSorting = true;
		while (isSorting) {
			isSorting = false;
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i].compareTo(list[i + 1]) < 0) {
					temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					isSorting = true;
				}
			}
		}
		return list;
	}

	/**
	 * This method is the selection sort. It goes through each of the
	 * PolygonADTs in the list and swaps the highest value with the location of
	 * the index. It then repeats this process until it has reached the end.
	 * 
	 * @return this will return a PolygonADT[] list that contains the sorted
	 *         PolygonADT objects.
	 */
	public PolygonADT[] selectionSort() {
		PolygonADT temp;

		for (int i = 0; i < list.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < list.length; j++)
				if (list[j].compareTo(list[index]) > 0)
					index = j;
			temp = list[i];
			list[i] = list[index];
			list[index] = temp;
		}
		return list;
	}

	/**
	 * This method is the insertion sort. It goes forward through each of the
	 * PolygonADTs in the list. Then the next value is compared against the
	 * previous sub list. The number will go incrementally backwards until it is
	 * correctly sorted.
	 * 
	 * @return this will return a PolygonADT[] list that contains the sorted
	 *         PolygonADT objects.
	 */
	public PolygonADT[] insertionSort() {
		PolygonADT temp;

		for (int i = 1; i < list.length; i++)
			for (int j = i; j > 0; j--)
				if (list[j].compareTo(list[j - 1]) > 0) {
					temp = list[j];
					list[j] = list[j - 1];
					list[j - 1] = temp;
				}

		return list;
	}

	/**
	 * This is the public method that is called merge sort. This is done so that
	 * the next method can be called recursively.
	 * 
	 * @return this will return a PolygonADT[] list that contains the sorted
	 *         PolygonADT objects.
	 */
	public PolygonADT[] mergeSort() {
		return mergeSort(list);
	}

	/**
	 * This is the recursive call for the merge sort which allows for the list
	 * to be broken up into the smallest possible lists.
	 * 
	 * Once the recursive calls are complete, call the merge method to rebuild
	 * it.
	 * 
	 * @param myList
	 *            is the PolygonADT list that will be broken down into its
	 *            smallest possibile size
	 * @return this will return a PolygonADT[] list that contains the sorted
	 *         PolygonADT objects.
	 */
	private PolygonADT[] mergeSort(PolygonADT[] myList) {

		if (myList.length <= 1)
			return myList;

		int mid = myList.length / 2;
		int secondLength = myList.length - mid;
		PolygonADT[] first = new PolygonADT[mid];

		for (int i = 0; i < mid; i++) {
			first[i] = myList[i];
		}
		PolygonADT[] second = new PolygonADT[secondLength];
		for (int i = 0; i < secondLength; i++) {
			second[i] = myList[mid + i];
		}

		mergeSort(first);
		mergeSort(second);

		PolygonADT[] result = merge(first, second);
		for (int i = 0; i < result.length; i++) {
			myList[i] = result[i];
		}
		return myList;
	}

	/**
	 * This is the merge method that will combine all of the PolygonADT lists
	 * based on the comparison size.
	 * 
	 * @param first
	 *            is the PolygonADT list that is being merged together first
	 * @param second
	 *            is the PolygonADT list that is being merged together second
	 * @return this will return a PolygonADT[] list that contains the sorted
	 *         PolygonADT objects.
	 */
	private PolygonADT[] merge(PolygonADT[] first, PolygonADT[] second) {
		PolygonADT[] result = new PolygonADT[first.length + second.length];

		int firstIndex = 0; // starting index in
		int secondIndex = 0; // starting index in b
		final int firstMax = first.length; // max index in a
		final int secondMax = second.length; // max index in b
		int finalIndex = 0; // index in result

		while (firstIndex < firstMax && secondIndex < secondMax) {
			if (first[firstIndex].compareTo(second[secondIndex]) >= 0) {
				result[finalIndex] = first[firstIndex];
				firstIndex = firstIndex + 1;
				finalIndex = finalIndex + 1;
			} else {
				result[finalIndex] = second[secondIndex];
				secondIndex = secondIndex + 1;
				finalIndex = finalIndex + 1;
			}
		}

		while (firstIndex < firstMax) {
			result[finalIndex] = first[firstIndex];
			firstIndex = firstIndex + 1;
			finalIndex = finalIndex + 1;
		}
		while (secondIndex < secondMax) {
			result[finalIndex] = second[secondIndex];
			secondIndex = secondIndex + 1;
			finalIndex = finalIndex + 1;
		}
		return result;
	}

	/**
	 * This is the public method that is called quick sort. This is done so that
	 * the next method can be called recursively.
	 * 
	 * @return this will return a PolygonADT[] list that contains the sorted
	 *         PolygonADT objects.
	 */
	public PolygonADT[] quickSort() {
		quickSort(list, 0, list.length - 1);
		return list;
	}

	/**
	 * This is the quick sort method that will partition the list it is given
	 * recursively.
	 * 
	 * @param myList
	 *            is the PolygonADT list that will be broken down into its
	 *            smallest possibile size
	 * @param low
	 *            is the low index
	 * @param high
	 *            is the high index
	 */
	private void quickSort(PolygonADT[] myList, int low, int high) {
		if (low < high) {
			int index = partition(low, high);
			quickSort(myList, low, index);
			quickSort(myList, index + 1, high);
		}
	}

	/**
	 * This is the partition method that will split the list and will use a
	 * random variable to determine the pivot.
	 * 
	 * @param low
	 *            is the low index
	 * @param high
	 *            is the high index
	 * @return this will return the pointer in the list
	 */
	private int partition(int low, int high) {
		PolygonADT lowList = list[low];
		Random rand = new Random();
		int pivot = rand.nextInt(low + high) / 2;
		if ((list[low].compareTo(list[pivot]) <= 0 && list[pivot].compareTo(list[high]) <= 0)
				|| (list[high].compareTo(list[pivot]) <= 0 && list[pivot].compareTo(list[low]) <= 0))
			lowList = list[pivot];
		if ((list[low].compareTo(list[high]) <= 0 && list[high].compareTo(list[pivot]) <= 0)
				|| (list[pivot].compareTo(list[high]) <= 0 && list[high].compareTo(list[low]) <= 0))
			lowList = list[high];
		int lowIndex = low - 1;
		int highIndex = high + 1;
		while (true) {
			do
				lowIndex++;
			while (!(lowIndex > high || list[lowIndex].compareTo(lowList) <= 0));
			do
				highIndex--;
			while (!(highIndex < low || list[highIndex].compareTo(lowList) >= 0));
			if (lowIndex < highIndex)
				swap(lowIndex, highIndex);
			else
				return highIndex;
		}
	}

	/**
	 * This method takes the low index and the high index of the list location
	 * and swaps them.
	 * 
	 * @param lowIndex
	 *            is the index location of the lower variable
	 * @param highIndex
	 *            is the index location of the higher variable
	 */
	private void swap(int lowIndex, int highIndex) {
		PolygonADT temp;
		temp = list[lowIndex];
		list[lowIndex] = list[highIndex];
		list[highIndex] = temp;
	}

	/**
	 * This is the method for the martini sort. It is similar to the bubble
	 * sort, but instead of only going one direction, it goes back and forth.
	 * 
	 * @return this will return a PolygonADT[] list that contains the sorted
	 *         PolygonADT objects.
	 */
	public PolygonADT[] martiniSort() {
		for (int i = 0; i < list.length / 2; i++) {
			boolean swapped = false;
			for (int j = i; j < list.length - i - 1; j++) {
				if (list[j].compareTo(list[j + 1]) < 0) {
					PolygonADT tmp = list[j];

					list[j] = list[j + 1];
					list[j + 1] = tmp;
				}
			}

			for (int j = list.length - 2 - i; j > i; j--) {
				if (list[j].compareTo(list[j - 1]) > 0) {
					PolygonADT tmp = list[j];

					list[j] = list[j - 1];
					list[j - 1] = tmp;
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}
		return list;
	}
}
