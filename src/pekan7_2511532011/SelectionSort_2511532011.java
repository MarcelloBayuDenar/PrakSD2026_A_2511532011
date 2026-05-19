package pekan7_2511532011;

public class SelectionSort_2511532011 {
	public static void SelectionSort_2511532011(int[] arr_2011) {
		int n_2011 = arr_2011.length;
		for ( int i_2011 = 0; i_2011 < n_2011; i_2011++) {
			int minIndex_2011 = i_2011;
			for ( int j_2011 = i_2011 + 1; j_2011 < n_2011; j_2011++) {
				if ( arr_2011[j_2011] < arr_2011[minIndex_2011] ) {
					minIndex_2011 = j_2011;
				}
			}
			int temp_2011 = arr_2011[i_2011];
			arr_2011[i_2011] = arr_2011[minIndex_2011];
			arr_2011[minIndex_2011] = temp_2011;
		}
	}
	
	public static void main( String[] args ) {
		int arr_2011[] = {23, 78, 45, 8, 32, 56, 1};
		int n_2011 = arr_2011.length;
		System.out.printf("array yang belum terurut:\n");
		for (int i = 0; i < n_2011; i++) {
			System.out.print(arr_2011[i ] + " ");
		}
		System.out.println("");
		SelectionSort_2511532011(arr_2011);
		System.out.printf("array yang sudah terurut:\n");
		for (int i = 0; i < n_2011; i++) {
			System.out.print(arr_2011[i ] + " ");
		}
		System.out.println("");
	}
}
