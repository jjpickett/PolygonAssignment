package sorting;

import java.util.Random;

import shapes.Polygon;

public class Sorting {
	private Polygon[] list;
	
	public Sorting() {}
	public Sorting(Polygon[] list) {
		this.list = list;
	}
	
	public Polygon[] bubbleSort(){	
		Polygon temp;
		
		boolean isSorted = true;
		while(isSorted){
			isSorted = false;
			for(int i = 0; i < list.length - 1; i++){
				if(list[i].compareTo(list[i+1]) > 0){
					temp = list[i];
					list[i] = list[i + 1];
					list[i+1] = temp;
					isSorted = true;
				}
			}
		}	
		for(int i = 0; i < list.length; i++){
			System.out.println(list[i].getClass() + " " + list[i].getBaseVolume() + " " + i);
		}
		System.out.println("done");
		return list;
	}
	
	public Polygon[] selectionSort(){
		Polygon temp;
		
		for (int i = 0; i < list.length - 1; i++){
	      int minIndex = i;
	      for (int j = i + 1; j < list.length; j++){
	        if (list[j].compareTo(list[minIndex]) < 0)
	          minIndex = j;
	      }
	      temp = list[i];
	      list[i] = list[minIndex];
	      list[minIndex] = temp;
	    }
		
		for(int i = 0; i < list.length; i++){
			System.out.println(list[i].getClass() + " " + list[i].getBaseVolume() + " " + i);
		}
		System.out.println("done");
		return list;
	}
	
	public Polygon[] insertionSort(){
		
			Polygon temp;
			
			for(int i = 1; i < list.length; i++){				
				for(int j = i; j > 0; j--){
					if(list[j].compareTo(list[j-1]) < 0){					
						temp = list[j];
						list[j] = list[j-1];
						list[j-1] = temp;
					}
				}
			}
			
			for(int i = 0; i < list.length; i++){
				System.out.println(list[i].getClass() + " " + list[i].getBaseVolume() + " " + i);
			}
			System.out.println("done");
			return list;
		}
	
	public Polygon[] mergeSort(Polygon[] list){
		
		if (list.length <= 1)
	      return list;
	    
	    
	    // Split into two new arrays
	    int mid = list.length / 2;
	    int secondLength = list.length - mid;
	    Polygon[] first = new Polygon[mid];
	    
	    for (int i = 0; i < mid; ++i){
	      first[i] = list[i];
	    }
	    Polygon[] second = new Polygon[secondLength];
	    for (int i = 0; i < secondLength; ++i){
	      second[i] = list[mid + i];
	    }
	    
	    // Recursively sort each half and merge back together
	    mergeSort(first);
	    mergeSort(second);
	    
	    Polygon[] result = merge(first, second);
	    for (int i = 0; i < result.length; ++i)
	    {
	      list[i] = result[i];
	    }
		
		return list;
	}
	private static Polygon[] merge(Polygon[] a, Polygon[] b)
	  {
	    Polygon[] result = new Polygon[a.length + b.length];
	    
	    int i = 0;                  // starting index in a
	    int j = 0;                  // starting index in b
	    final int iMax = a.length;  // max index in a
	    final int jMax = b.length;  // max index in b
	    int k = 0;                  // index in result
	    
	    while (i < iMax && j < jMax)
	    {
	      if (a[i].compareTo(b[j]) <= 0)
	      {
	        result[k] = a[i];
	        i = i + 1;
	        k = k + 1;
	       }
	      else
	      {
	        result[k] = b[j];
	        j = j + 1;
	        k = k + 1;
	      }
	    }
	    
	    // pick up any stragglers
	    while (i < iMax)
	    {
	      result[k] = a[i];
	      i = i + 1;
	      k = k + 1;
	    }
	    while (j < jMax)
	    {
	      result[k] = b[j];
	      j = j + 1;
	      k = k + 1;
	    }
	    
	    return result;
	  }

	public Polygon[] quickSort(){
		quick(list, 0, list.length -1);
	    
		return list;
	}
	private void quick(Polygon[] a, int i, int j) {
			if (i<j) {
			    int l = partition(a,i,j);
			    quick(a, i, l);
			    quick(a, l+1, j);
			}
	    }

	    private int partition(Polygon[] a, int p, int q) {
			Polygon x = list[p];
			int m = (p+q)/2;
			if ((list[p].compareTo(list[m])<=0 && list[m].compareTo(list[q])<=0) || (list[q].compareTo(list[m])<=0 && list[m].compareTo(list[p])<=0))
			    x = list[m];
			if ((list[p].compareTo(list[q])<=0 && list[q].compareTo(list[m])<=0) || (list[m].compareTo(list[q])<=0 && list[q].compareTo(list[p])<=0))
			    x = list[q];
			int i = p-1;
			int j = q+1;
			while (true) {
			    do i++; while (!(i>q || list[i].compareTo(x)>=0));
			    do j--; while (!(j<p || list[j].compareTo(x)<=0));
			    if (i<j) swap(a, i, j);
			    else return j;
			}
	    }

	    private void swap (Polygon[] a, int i, int j) {
			Polygon x;
			x = list[i];
			list[i] = list[j];
			list[j] = x;
	    }
	 

	 
	 
	

}
