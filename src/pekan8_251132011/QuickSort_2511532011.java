package pekan8_251132011;

public class QuickSort_2511532011 {
	static void swap_2011(int[] arr_2011, int i_2011, int j_2011) {
		int temp_2011 = arr_2011[i_2011];
		arr_2011[i_2011] = arr_2011[j_2011];
		arr_2011[j_2011] = temp_2011;
	}

	static void medianOfThree_2011(int[] arr_2011, int low_2011, int high_2011) {
		int mid_2011 = low_2011 + (high_2011 - low_2011) / 2;

		if (arr_2011[low_2011] > arr_2011[mid_2011]) {
			swap_2011(arr_2011, low_2011, mid_2011);
		}
		if (arr_2011[low_2011] > arr_2011[high_2011]) {
			swap_2011(arr_2011, low_2011, high_2011);
		}
		if (arr_2011[mid_2011] > arr_2011[high_2011]) {
			swap_2011(arr_2011, mid_2011, high_2011);
		}
		swap_2011(arr_2011, mid_2011, high_2011);
	}
	
	static int partition_2011(int[] arr_2011, int low_2011, int high_2011) {
		
		medianOfThree_2011(arr_2011, low_2011, high_2011);

		int pivot_2011	= arr_2011[high_2011];
		int i_2011		= (low_2011 - 1);

		for (int j_2011 = low_2011; j_2011 <= high_2011 - 1; j_2011++) {
			
			if (arr_2011[j_2011] < pivot_2011) {
				
				i_2011++;
				swap_2011(arr_2011, i_2011, j_2011);
			}
		}
		swap_2011(arr_2011, i_2011 + 1, high_2011); 
		return (i_2011 + 1);
	}
	
	public static void quickSort_2011(int[] arr_2011, int low_2011, int high_2011) {
		if (low_2011 < high_2011) {
			int pi_2011 = partition_2011(arr_2011, low_2011, high_2011);
			quickSort_2011(arr_2011, low_2011, pi_2011 - 1);
			quickSort_2011(arr_2011, pi_2011 + 1, high_2011); 
		}
	}

	public static void printArr_2011(int[] arr_2011) {
		for (int i_2011 = 0; i_2011 < arr_2011.length; i_2011++) {
			System.out.print(arr_2011[i_2011] + " "); 
		}
		System.out.println();
	}
	
	public static void main (String[] args) {
		int[] arr_2011 = {10, 7, 8, 9, 1, 5};
		int N_2011 = arr_2011.length;
		printArr_2011(arr_2011);
		
		quickSort_2011(arr_2011, 0, N_2011 - 1);
		
		System.out.print("Data Terurut quicksort: ");
		printArr_2011(arr_2011);
	}

}
