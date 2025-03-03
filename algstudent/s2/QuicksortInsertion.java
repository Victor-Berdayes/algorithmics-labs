package algstudent.s2;

public class QuicksortInsertion {
	static int[] v;

	public static int medianOfThree(int[] a, int left, int right) { 
		
		int center = (left + right) / 2;
		if (a[left] > a[center])
			Vector.interchange(a, left, center);
		
		if (a[left] > a[right])
			Vector.interchange(a, left, right);
		
		if (a[center] > a[right])
			Vector.interchange(a, center, right);
		
		return center;
	}
	
	public static void quicksortInsertion(int[] a, int left, int right, int k) {
		int i = left;
		int j = right - 1;
		int pivot;
		
		if (left < right){
			if (right - left > k) {
				int center = medianOfThree(a, left, right);
				
				if ((right - left) >= 3){ 
					pivot = a[center];
					Vector.interchange(a, center, right);

					do {         
				    	while (a[i] <= pivot && i < right) 
				    		i++;
				    	
				    	while (a[j] >= pivot && j > left) 
				    		j--;
				    	
				        if (i < j) 
				        	Vector.interchange(a, i, j);
				        
				    } while (i < j);
					
					Vector.interchange(a, i, right);
					quicksortInsertion(a, left, i-1, k);
					quicksortInsertion(a, i+1, right, k);
				}
			}
			else {
				insertion(a, left, right);
			}
		}	
	}
	
	/* Sorting by the Insertion method */
	public static void insertion(int[] a, int left, int right) {
		int j;
		int pivot;
		
		for (int i = left+1; i <= right; i++) {
			pivot = a[i];
			j = i-1;
			
			while (j >= left && pivot < a[j]) {
				a[j+1] = a[j];
				j--;
			}
			
			a[j+1] = pivot;
		}
	}

	public static void quicksortInsertion(int[] a, int k) {
		quicksortInsertion(a, 0, a.length-1, k);
	}
	
	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //size of the problem
		int k = 10;
		v = new int[n];

		Vector.sorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v, k);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.reverseSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v, k);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v, k);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	}
}
