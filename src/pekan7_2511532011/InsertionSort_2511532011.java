package pekan7_2511532011;

public class InsertionSort_2511532011 {
	public static void InsertionSort_2511532011(int[] arr_2011) {
		int n_2011 = arr_2011.length;
		for ( int i_2011 = 1; i_2011 < n_2011; i_2011++) {
			int key_2011 = arr_2011[i_2011];
			int j_2011 = i_2011 - 1 ;
			while (j_2011 >= 0 && arr_2011[j_2011] > key_2011 ) {
				arr_2011[j_2011 + 1] = arr_2011[j_2011];
				j_2011 --;
			}
			arr_2011[j_2011 + 1] = key_2011;
		}
	}
	
	public static void main( String[] args) {
		int arr_2011[] = {23, 78, 45, 8, 32, 56, 1};
		int n_2011 = arr_2011.length;
		System.out.printf("array yang belum terurut:\n");
		for (int i = 0; i < n_2011; i++) {
			System.out.print(arr_2011[i ] + " ");
		}
		System.out.println("");
		InsertionSort_2511532011(arr_2011);
		System.out.printf("array yang sudah terurut:\n");
		for (int i = 0; i < n_2011; i++) {
			System.out.print(arr_2011[i ] + " ");
		}
		System.out.println("");
	}
}
